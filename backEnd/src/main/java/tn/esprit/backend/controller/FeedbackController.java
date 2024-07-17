package tn.esprit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.entity.Feedback;
import tn.esprit.backend.serviceInterface.FeedbackServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackController {
    @Autowired
    private FeedbackServiceInterface feedbackServiceInterface;

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackServiceInterface.getAllFeedbacks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Feedback feedback=feedbackServiceInterface.getFeedbackById(id);
        if (feedback!=null) {
            return ResponseEntity.ok(feedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackServiceInterface.saveFeedback(feedback);
    }
    @PostMapping("/property/{propertyId}")
    public ResponseEntity<Feedback> addFeedback(@PathVariable Long propertyId, @RequestBody Feedback feedback) {
        try {
            Feedback newFeedback = feedbackServiceInterface.addFeedbackToProperty(propertyId, feedback);
            return ResponseEntity.ok(newFeedback);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback feedbackDetails) {
        Feedback updatedFeedback=feedbackServiceInterface.updateFeedback(id,feedbackDetails);
        if (updatedFeedback!=null) {
            return ResponseEntity.ok(updatedFeedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackServiceInterface.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
