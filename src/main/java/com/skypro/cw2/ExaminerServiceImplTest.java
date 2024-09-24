package com.skypro.cw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class ExaminerServiceImplTest {
    private ExaminerServiceImpl service;
    private JavaQuestionService mockQuestionService;

    @BeforeEach
    public void setUp() {
        mockQuestionService = Mockito.mock(JavaQuestionService.class);
        service = new ExaminerServiceImpl();
        service.JavaQuestionService = mockQuestionService;
    }

    @Test
    public void testGetQuestionsThrowsException() {
        Mockito.when(mockQuestionService.getRandomQuestion()).thenReturn(null);

        Exception exception = assertThrows(BadRequestException.class, () -> {
            service.getQuestions(5);
        });

        assertEquals("Not enough unique questions available.", exception.getMessage());
    }
}
