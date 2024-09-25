package com.skypro.cw2.app;

import com.skypro.cw2.exceptions.BadRequestException;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount) throws BadRequestException;
}