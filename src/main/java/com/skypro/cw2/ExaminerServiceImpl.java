package com.skypro.cw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    public com.skypro.coursework2.JavaQuestionService JavaQuestionService;
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
            throw new BadRequestException("Запрошено слишком большое количество вопросов.");
        }

        return List.copyOf(uniqueQuestions);
    }
}
