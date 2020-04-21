package com.example.springbootexamples.service;

import com.example.springbootexamples.entity.Course;
import com.example.springbootexamples.entity.Student;
import com.example.springbootexamples.entity.Teacher;
import com.example.springbootexamples.entity.User;
import com.example.springbootexamples.repository.CourseRepository;
import com.example.springbootexamples.repository.StudentRepository;
import com.example.springbootexamples.repository.TeacherRepository;
import com.example.springbootexamples.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    public Course addCourse(Course c){
        return courseRepository.refresh(courseRepository.save(c));
    }

    public List<Course> listCourse(int tid) {
        return teacherRepository.getOne(tid).getCourses();
    }

    public Course getCourse(int cid, int uid) {
        return courseRepository.find(cid, uid);
    }

    /**
     * 对user声明了persist/remove级联操作
     * 缺少判断该生已经被其它老师选择，可以抛出异常
     * @param s
     * @param tid
     * @return
     */
    public Student addStudent(Student s, int tid) {
        Student student = Optional.ofNullable(studentRepository.find(s.getUser().getName(), s.getUser().getNumber()))
                .orElseGet(() -> {
                    User u = s.getUser();
                    u.setPassword(encoder.encode(String.valueOf(s.getUser().getNumber())));
                    u.setRole(User.Role.STUDENT);
                    return s;
                });

        student.setTeacher(new Teacher(tid));
        studentRepository.save(student);
        //studentRepository.refresh(student);
        return student;
    }
}
