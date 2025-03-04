package com.coursework.Javacore.service;

import com.coursework.Javacore.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> allQuestions = questionService.getAllQuestions();
        if (allQuestions.isEmpty()) {
            throw new RuntimeException("Нет доступных вопросов");
        }
        Question[] questionArray = allQuestions.toArray(new Question[0]);
        Random random = new Random();
        int randomIndex = random.nextInt(questionArray.length);
        return questionArray[randomIndex];
    }

    @Override
    public Question addQuestion(String question, String answer) {
        return questionService.add(question, answer);
    }

    @Override
    public Question removeQuestion(String question) {
        return questionService.remove(question);
    }

    @Override
    public Question findQuestion(String question) {
        return questionService.find(question);
    }

    @Override
    public Collection<Question> getAllQuestions(int amount) {
        return questionService.getAllQuestions();
    }
}
