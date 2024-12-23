package com.WitsHelp.WitsHelp.Entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;
    private String body;
    private Date creation_date;
    private boolean is_accepted;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // To: Do -> getters and setters



    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }
    public Long getAnswer_id() {
        return answer_id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer_id=" + answer_id +
                ", body='" + body + '\'' +
                ", creation_date=" + creation_date +
                ", is_accepted=" + is_accepted +
                ", question=" + question +
                ", user=" + user +
                '}';
    }
}
