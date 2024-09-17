package Interns.BlueRingInternship.mapper;
import Interns.BlueRingInternship.dto.UserDTO;
import Interns.BlueRingInternship.entity.MytableEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO mytableEntityToUserDTO(MytableEntity mytableEntity);

    MytableEntity userDTOToMytableEntity(UserDTO userDTO);

}
