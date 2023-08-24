package com.es.quizmania.Repositories;

import com.es.quizmania.Entity.Question;
import com.es.quizmania.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
