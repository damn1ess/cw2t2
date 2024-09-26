package com.skypro.cw2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionService service;

    @BeforeEach
    public void setUp() {
        service = new JavaQuestionService();
    }

    @Test
    public void testAddQuestion() {
        Question question = new Question("What is Java?", "A programming language.");
        service.addQuestion(question);
        assertEquals(1, service.getAllQuestions().size());
    }

    @Test
    public void testRemoveQuestion() {
        Question question = new Question("What is Java?", "A programming language.");
        service.addQuestion(question);
        service.removeQuestion(question);
        assertEquals(0, service.getAllQuestions().size());
    }

    @Test
    public void testGetRandomQuestion() {
        service.addQuestion(new Question("What is Java?", "A programming language."));
        service.addQuestion(new Question("What is OOP?", "Object-Oriented Programming."));
        assertNotNull(service.getRandomQuestion());
    }
}
