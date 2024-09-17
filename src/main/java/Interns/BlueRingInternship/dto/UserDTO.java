package Interns.BlueRingInternship.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDTO {
    private String  name;
    private List<String> roles;
}
