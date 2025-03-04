package com.coursework.Javacore.controller;

import com.coursework.Javacore.model.Question;
import com.coursework.Javacore.service.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private ExaminerService examinerService;

    @Autowired
    public ExamController(ExaminerService examinerService)   {
        this.examinerService = examinerService;
    }
    @RequestMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        Collection<Question> questions = examinerService.getAllQuestions(amount);
        return questions;
    }
}
