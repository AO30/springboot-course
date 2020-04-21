package com.example.springbootexamples.controller.vo;

import com.example.springbootexamples.entity.Course;
import com.example.springbootexamples.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class CourseVO {
    private Course course;
    private List<Student> students;
}
