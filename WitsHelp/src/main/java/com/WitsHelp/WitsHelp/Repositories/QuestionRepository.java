package com.WitsHelp.WitsHelp.Repositories;

import com.WitsHelp.WitsHelp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
