package tn.esprit.backend.serviceInterface;

import tn.esprit.backend.entity.Feedback;

import java.util.List;

public interface FeedbackServiceInterface {
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Long id);
    List<Feedback> getFeedbacksByPropertyId(Long propertyId);
    Feedback saveFeedback(Feedback feedback);
    Feedback addFeedbackToProperty(Long propertyId, Feedback feedback);
    Feedback updateFeedback(Long id, Feedback feedback);
    void deleteFeedback(Long id);
}
