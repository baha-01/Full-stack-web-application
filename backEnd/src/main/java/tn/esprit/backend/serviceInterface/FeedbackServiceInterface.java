package tn.esprit.backend.serviceInterface;

import tn.esprit.backend.entity.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackServiceInterface {
    public List<Feedback> getAllFeedbacks();
    public Optional<Feedback> getFeedbackById(Integer id);
    public Feedback saveFeedback(Feedback feedback);
    public Feedback updateFeedback(Feedback feedback);
    public void deleteFeedback(Integer id);
}
