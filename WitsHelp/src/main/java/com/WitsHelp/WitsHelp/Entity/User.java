package com.WitsHelp.WitsHelp.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
//import lombok.Data;

@Entity
//@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String username;
    private String email;
    private String password_hash;
    private String reputation;
    private Date joined_date;
    @OneToMany(mappedBy = "user")
    private List<Question> questions;
    @OneToMany(mappedBy = "user")
    private List<Answer> answers;
//  We are going to come back to add other stuff
// Getter and Setter for user_id
public Long getUser_id() {
    return user_id;
}

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for password_hash
    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    // Getter and Setter for reputation
    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    // Getter and Setter for joined_date
    public Date getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(Date joined_date) {
        this.joined_date = joined_date;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", reputation='" + reputation + '\'' +
                ", joined_date='" + joined_date + '\'' +
                '}';
    }

    // Override equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id != null && user_id.equals(user.user_id);
    }

    // Override hashCode() method
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
