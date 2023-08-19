package com.es.quizmania.Service;

import com.es.quizmania.Entity.Question;
import com.es.quizmania.Entity.QuestionWrapper;
import com.es.quizmania.Entity.Quiz;
import com.es.quizmania.Repositories.QuestionRepository;
import com.es.quizmania.Repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();

    }
}
