package tn.esprit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend.entity.Feedback;
import tn.esprit.backend.entity.Property;
import tn.esprit.backend.entity.ResourceNotFoundException;
import tn.esprit.backend.repository.FeedbackRepository;
import tn.esprit.backend.repository.PropertyRepository;
import tn.esprit.backend.serviceInterface.FeedbackServiceInterface;

import java.util.List;

@Service
public class FeedbackService implements FeedbackServiceInterface {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }
    public List<Feedback> getFeedbacksByPropertyId(Long propertyId) {
        return feedbackRepository.findByPropertyPropertyId(propertyId);
    }
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    public Feedback addFeedbackToProperty(Long propertyId, Feedback feedback) {
        Property property=propertyRepository.findById(propertyId).orElseThrow(() -> new ResourceNotFoundException("Property not found"));
        feedback.setProperty(property);
        return feedbackRepository.save(feedback);
    }
    public Feedback updateFeedback(Long id, Feedback feedbackDetails) {
        Feedback feedback=feedbackRepository.findById(id).orElse(null);
        if (feedback!=null) {
            feedback.setContent(feedbackDetails.getContent());
            feedback.setRating(feedbackDetails.getRating());
            feedback.setDatePosted(feedbackDetails.getDatePosted());
            return feedbackRepository.save(feedback);
        } else {
            return null;
        }
    }
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
