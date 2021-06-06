package com.springBoot.application.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Data
@Entity
@Builder
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "hey! department name is not entred here !!!")

    /*@Length(max = 10,min = 0)
    @Size
    @Email
    @Positive
    @PositiveOrZero
    @Negative*/

    private String departmentName;
    private String departmentContact;
    private String departmentCode;
}
