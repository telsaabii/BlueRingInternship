package Interns.BlueRingInternship.Controller;

import Interns.BlueRingInternship.entity.MytableEntity;
import Interns.BlueRingInternship.service.MyService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/api/mytable")
public class MyController {
private final MyService myService;


    public MyController(MyService myService) {
        this.myService = myService;
    }

    @PostMapping("/create")
    public MytableEntity createEntity(@RequestBody Map<String, Object> entityDTO) {

        return myService.createEntity(entityDTO);
    }

    @GetMapping("/get/{id}")
    public Optional<MytableEntity> getEntity(@PathVariable Integer id) {
        return myService.getEntity(id);
    }

    @PatchMapping("/update/{id}")
    public MytableEntity patchEntity(@PathVariable Integer id, @RequestBody Map<String, Object> entityDTO) {
        Optional<MytableEntity> entityToUpdate = myService.getEntity(id);
        if (entityToUpdate.isPresent()) {
            return myService.updateEntity(entityDTO, entityToUpdate.get(), MytableEntity.class);
        }
        throw new RuntimeException("Entity not found");
    }
    // Delete an entity by ID
    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable Integer id) {

        myService.deleteEntity(id);
    }




}
