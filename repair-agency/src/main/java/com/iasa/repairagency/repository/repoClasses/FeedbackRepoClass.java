package com.iasa.repairagency.repository.repoClasses;


import com.iasa.repairagency.model.Feedback;
import com.iasa.repairagency.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FeedbackRepoClass {

    private final FeedbackRepository feedbackRepository;

    public void save(Feedback feedback){
        feedbackRepository.save(feedback);
    }
}
