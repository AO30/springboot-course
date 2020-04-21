package com.example.springbootexamples.service;

import com.example.springbootexamples.entity.Teacher;
import com.example.springbootexamples.entity.User;
import com.example.springbootexamples.repository.TeacherRepository;
import com.example.springbootexamples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public User getUser(int num) {
        return userRepository.find(num);
    }

    public Teacher getTeacher(int tid) {
        return teacherRepository.findById(tid).orElse(null);
    }

    /**
     * 对user声明了persist/remove操作
     * @param teacher
     * @return
     */
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(int quantity, int ranges, int tid){
        Teacher t = teacherRepository.findById(tid)
                .orElseThrow();
        t.setQuantity(quantity);
        t.setRanges(ranges);
        return t;
    }
}
