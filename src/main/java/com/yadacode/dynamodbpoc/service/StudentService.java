package com.yadacode.dynamodbpoc.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.yadacode.dynamodbpoc.config.DynamoDbConfig;
import com.yadacode.dynamodbpoc.model.student.Student;
import com.yadacode.dynamodbpoc.model.student.StudentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StudentService {

    private final DynamoDBMapper dynamoDBMapper;

    private final DynamoDbConfig dynamoDbConfig;

//    @PostConstruct
//    @Profile("dev")
//    public void init(){
//        //Create table
//        CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(Student.class);
//        createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
//        TableUtils.createTableIfNotExists(dynamoDbConfig.amazonDynamoDB(), createTableRequest);
//    }

    public StudentService(DynamoDBMapper dynamoDBMapper, DynamoDbConfig dynamoDbConfig) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.dynamoDbConfig = dynamoDbConfig;
    }

    public StudentDTO createNewStudent(StudentDTO dto) {

        Student student = new Student();
        BeanUtils.copyProperties(dto, student);

        dynamoDBMapper.save(student);

        StudentDTO response = new StudentDTO();
        BeanUtils.copyProperties(student,response);

        return response;
    }
}
