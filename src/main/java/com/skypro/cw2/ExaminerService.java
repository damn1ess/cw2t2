package com.skypro.cw2;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount) throws BadRequestException;
}