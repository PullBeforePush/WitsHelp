package com.WitsHelp.WitsHelp.Service;

import com.WitsHelp.WitsHelp.Entity.Answer;
import com.WitsHelp.WitsHelp.Repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    public Answer createAnswer(Answer answer){
        return answerRepository.save(answer);
    }

}
