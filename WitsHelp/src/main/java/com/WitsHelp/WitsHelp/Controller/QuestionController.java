package com.WitsHelp.WitsHelp.Controller;

import com.WitsHelp.WitsHelp.Entity.Question;
import com.WitsHelp.WitsHelp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        try{
            Question createdQuestion = questionService.createQuestion(question);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
        } catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("x-error-message", "Something went wrong when creating question");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .headers(headers)
                    .build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            List<Question> questions = questionService.getAllQuestion();
            if (questions.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(questions);
        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .headers(headers)
                    .build();
        }
    }
}
