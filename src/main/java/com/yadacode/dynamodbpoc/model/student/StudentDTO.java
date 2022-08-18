package com.yadacode.dynamodbpoc.model.student;

import lombok.Data;

@Data
public class StudentDTO {

    private Long studentId;
    private String firstName;
    private String lastName;

}
