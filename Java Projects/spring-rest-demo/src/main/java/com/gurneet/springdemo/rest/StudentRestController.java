package com.gurneet.springdemo.rest;


import com.gurneet.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data.. only once!

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Gurneet", "Singh"));
        theStudents.add(new Student("Manpreet", "Singh"));
        theStudents.add(new Student("Mario", "Singh"));

    }

    // define endpoint for "/students" - return list of students;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }


    @GetMapping("/students/{studentId}")

    public Student getStudent(@PathVariable int studentId){

        // just index into the list...keep it simple for now
        return theStudents.get(studentId);
    }



}
