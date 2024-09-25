package com.skypro.cw2.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
@Autowired
private ExaminerService examinerService;

@GetMapping("/get/{amount}")
public List<Question> getQuestions(@PathVariable int amount) {
    return examinerService.getQuestions(amount);
}
}