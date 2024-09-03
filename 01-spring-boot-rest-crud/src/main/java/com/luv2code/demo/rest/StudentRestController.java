package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudent;

    @PostConstruct
    public void loadData(){

        theStudent = new ArrayList<>();

        theStudent.add(new Student("Erdal","Erdem"));
        theStudent.add(new Student("Güllü","Yücesoy"));
        theStudent.add(new Student("Emre","Eryü"));
        theStudent.add(new Student("Fatih","Eryü"));

    }

    @GetMapping("/students")
    public List<Student> getStudent(){


        return theStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student student(@PathVariable Integer studentId){


        if ( (studentId >= theStudent.size()) || studentId <0 ){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }

        return theStudent.get(studentId);

    }








}
