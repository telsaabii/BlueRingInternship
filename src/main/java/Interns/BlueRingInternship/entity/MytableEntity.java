package Interns.BlueRingInternship.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "mytable", schema = "internship", catalog = "")
public class MytableEntity {

    @Basic@Column(name = "first_name")
    private String firstName;

    @Basic@Column(name = "last_name")
    private String lastName;

    @Id@Column(name = "ID")
    private int id;

    @Basic@Column(name = "DOB")
    private Date dob;

    @Basic@Column(name = "Major")
    private String major;

}
