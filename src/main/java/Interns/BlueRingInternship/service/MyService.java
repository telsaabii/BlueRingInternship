package Interns.BlueRingInternship.service;

import Interns.BlueRingInternship.repository.MytableRepository;
import Interns.BlueRingInternship.entity.MytableEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
//It is commonly used in situations where the result of a
// method may or may not be present
@Service
public class MyService {//ask Roni about "class can be a record"
    //injecting repo
    private final MytableRepository repo;

    public MyService(MytableRepository repo) {
        this.repo = repo;
    }


    //create
    public MytableEntity createEntity(Map<String, Object> entityDTO) {
        MytableEntity table = new MytableEntity();

        if (entityDTO.get("first_name") != null) {
            table.setFirstName((String) entityDTO.get("first_name"));
        }

        if (entityDTO.get("last_name") != null) {
            table.setLastName((String) entityDTO.get("last_name"));
        }

        if (entityDTO.get("ID") != null) {
            table.setId((Integer) entityDTO.get("ID"));
        }

        if (entityDTO.get("DOB") != null) {
            try {
                table.setDob(java.sql.Date.valueOf((String) entityDTO.get("DOB")));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid date format for DOB. Use YYYY-MM-DD.");
            }
        }

        if (entityDTO.get("Major") != null) {
            table.setMajor((String) entityDTO.get("Major")); // Cast to String
        }
        return repo.save(table);
    }

    //update
    public MytableEntity updateEntity(Map<String,Object> entityDTO, Object entityToUpdate,
                                    Class<?> entityToUpdateClass) {
        entityDTO.forEach((k, v) -> {

            Field field = ReflectionUtils.findField(entityToUpdateClass, k);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, entityToUpdate, v);
            }

        });
    return repo.save((MytableEntity) entityToUpdate);
    }

    //getter
    public Optional<MytableEntity> getEntity(Integer id) {
        return repo.findById(id);
    }
    //delete
    public void deleteEntity(Integer id) {
        repo.deleteById(id);
    }

}


