package tn.esprit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend.entity.Feedback;
import tn.esprit.backend.repository.FeedbackRepository;
import tn.esprit.backend.serviceInterface.FeedbackServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService implements FeedbackServiceInterface {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    public Optional<Feedback> getFeedbackById(Integer id) {
        return feedbackRepository.findById(id);
    }
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    public Feedback updateFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    public void deleteFeedback(Integer id) {
        feedbackRepository.deleteById(id);
    }
}
