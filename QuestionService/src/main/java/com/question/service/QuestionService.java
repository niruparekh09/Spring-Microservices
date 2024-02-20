package com.question.service;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    List<Question> get();

    Question getOne(Long id);

    List<Question> getByQuiz(Long quizId);
}
