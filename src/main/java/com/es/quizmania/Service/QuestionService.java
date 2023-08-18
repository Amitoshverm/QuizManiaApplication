package com.es.quizmania.Service;

import com.es.quizmania.Entity.Question;
import com.es.quizmania.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository repository;

    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    public List<Question> getAllQuestionsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public String addQuestion(Question question) {
        repository.save(question);
        return "success";
    }

    public String deleteById(Integer id) {
        repository.deleteById(id);
        return "deleted: "+id;
    }

    public String updateQuestion(Integer id, Question question) {
        repository.save(question);
        return "updated";
    }
}
