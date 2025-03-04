package com.coursework.Javacore.service;


import com.coursework.Javacore.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestExaminerServiceImpl {

    private QuestionService questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService();
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void getRandomQuestionException() {
        assertThrows(RuntimeException.class, () -> examinerService.getRandomQuestion());
    }

    @Test
    void getRandomQuestion() {
        questionService.add("Вопрос 1", "Ответ 1");
        questionService.add("Вопрос 2", "Ответ 2");
        Question randomQuestion = examinerService.getRandomQuestion();
        assertNotNull(randomQuestion);
    }

    @Test
    void addQuestion() {
        Question question = examinerService.addQuestion("Вопрос", "Ответ");
        assertNotNull(question);
        assertEquals("Вопрос", question.getQuestion());
        assertEquals("Ответ", question.getAnswer());
    }

    @Test
    void removeQuestion() {
        examinerService.addQuestion("Вопрос для удаления", "Ответ");
        int size = questionService.getAllQuestions().size();
        examinerService.removeQuestion("Вопрос для удаления");
        assertEquals(size - 1, questionService.getAllQuestions().size());
    }

    @Test
    void findQuestion() {
        examinerService.addQuestion("Вопрос", "Ответ");
        Question foundQuestion = examinerService.findQuestion("Вопрос");
        assertNotNull(foundQuestion);
        assertEquals("Вопрос", foundQuestion.getQuestion());
    }
}
