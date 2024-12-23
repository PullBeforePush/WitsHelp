package com.WitsHelp.WitsHelp.Service;

import com.WitsHelp.WitsHelp.Entity.Question;
import com.WitsHelp.WitsHelp.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question){
           return questionRepository.save(question);
    }
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }
//    public Question getQuestionById(Long question_id){
//        return questionRepository.findAllById(question_id).orElse(null);
//    }
}
