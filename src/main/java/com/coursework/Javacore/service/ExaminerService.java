package com.coursework.Javacore.service;

import com.coursework.Javacore.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Question getRandomQuestion();
    Question addQuestion(String question, String answer);
    Question removeQuestion(String question);
    Question findQuestion(String question);
    Collection<Question> getAllQuestions(int amount);
}

