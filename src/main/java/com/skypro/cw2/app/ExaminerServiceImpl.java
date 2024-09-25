package com.skypro.cw2.app;

import com.skypro.cw2.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Autowired
    private QuestionService javaQuestionService;

    @Override
    public List<Question> getQuestions(int amount) throws BadRequestException {
        Set<Question> uniqueQuestions = new HashSet<>();

        while (uniqueQuestions.size() < amount) {
            Question question = javaQuestionService.getRandomQuestion();
            if (question != null) {
                uniqueQuestions.add(question);
            }
        }

        if (uniqueQuestions.size() < amount) {
            throw new BadRequestException("Not enough unique questions available.");
        }

        return List.copyOf(uniqueQuestions);
    }
}