package tn.esprit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.entity.Feedback;
import tn.esprit.backend.serviceInterface.FeedbackServiceInterface;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackServiceInterface feedbackServiceInterface;

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackServiceInterface.getAllFeedbacks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Integer id) {
        Optional<Feedback> feedback = feedbackServiceInterface.getFeedbackById(id);
        return feedback.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackServiceInterface.saveFeedback(feedback);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Integer id, @RequestBody Feedback feedbackDetails) {
        Optional<Feedback> feedbackOptional = feedbackServiceInterface.getFeedbackById(id);
        if (feedbackOptional.isPresent()) {
            Feedback feedback = feedbackOptional.get();
            feedback.setContent(feedbackDetails.getContent());
            feedback.setRating(feedbackDetails.getRating());
            feedback.setDatePosted(feedbackDetails.getDatePosted());
            feedback.setProperty(feedbackDetails.getProperty());

            Feedback updatedFeedback = feedbackServiceInterface.updateFeedback(feedback);
            return ResponseEntity.ok(updatedFeedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Integer id) {
        Optional<Feedback> feedbackOptional = feedbackServiceInterface.getFeedbackById(id);
        if (feedbackOptional.isPresent()) {
            feedbackServiceInterface.deleteFeedback(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
