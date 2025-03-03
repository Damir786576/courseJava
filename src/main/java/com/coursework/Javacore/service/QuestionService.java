package com.coursework.Javacore.service;

import com.coursework.Javacore.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(String question);
    Question find(String question);
    Collection<Question> getAllQuestions();
}
