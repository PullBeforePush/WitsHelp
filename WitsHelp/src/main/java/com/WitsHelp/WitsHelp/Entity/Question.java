package com.WitsHelp.WitsHelp.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long question_id;
    private String title;
    private String body;
    private Date creation_date;
    private Date last_activity_date;
    private Integer view_count;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setLast_activity_date(Date last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public Date getLast_activity_date() {
        return last_activity_date;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", creation_date=" + creation_date +
                ", last_activity_date=" + last_activity_date +
                ", view_count=" + view_count +
                ", user=" + user +
                ", answers=" + answers +
                '}';
    }
}
