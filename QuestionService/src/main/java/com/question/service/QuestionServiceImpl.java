package com.question.service;

import com.question.entities.Question;
import com.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepo;

    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Question with that id not found"));
    }

    @Override
    public List<Question> getByQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
