package com.skypro.cw2.app;

import java.util.List;

public interface QuestionService {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    List<Question> getAllQuestions();
    Question getRandomQuestion();
}