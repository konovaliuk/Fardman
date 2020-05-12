package com.iasa.repairagency.repository;

import com.iasa.repairagency.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
