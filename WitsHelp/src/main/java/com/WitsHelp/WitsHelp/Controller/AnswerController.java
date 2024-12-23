package com.WitsHelp.WitsHelp.Controller;

import com.WitsHelp.WitsHelp.Entity.Answer;
import com.WitsHelp.WitsHelp.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer){
        try{
            Answer createdAnswer = answerService.createAnswer(answer);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("x-error-message","Something went wrong when creating answer");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .headers(headers)
                    .build();
        }
    }
}
