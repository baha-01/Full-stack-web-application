package tn.esprit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.entity.Analysis;
import tn.esprit.backend.entity.Feedback;
import tn.esprit.backend.serviceInterface.AnalysisServiceInterface;
import tn.esprit.backend.serviceInterface.FeedbackServiceInterface;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {
    @Autowired
    private AnalysisServiceInterface analysisServiceInterface;

    @GetMapping
    public List<Analysis> getAllAnalysis() {
        return analysisServiceInterface.getAllAnalysis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analysis> getAnalysisById(@PathVariable Integer id) {
        Optional<Analysis> analysis = analysisServiceInterface.getAnalysisById(id);
        return analysis.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    @PostMapping
    public Analysis createAnalysis(@RequestBody Analysis analysis) {
        return analysisServiceInterface.saveAnalysis(analysis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Analysis> updateAnalysis(@PathVariable Integer id, @RequestBody Analysis analysisDetails) {
        Optional<Analysis> analysisOptional = analysisServiceInterface.getAnalysisById(id);
        if (analysisOptional.isPresent()) {
            Analysis analysis = analysisOptional.get();
            analysis.setReport(analysisDetails.getReport());
            analysis.setDateGenerated(analysisDetails.getDateGenerated());
            analysis.setUser(analysisDetails.getUser());
            // Update other fields as necessary

            Analysis updatedAnalysis = analysisServiceInterface.updateAnalysis(analysis);
            return ResponseEntity.ok(updatedAnalysis);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalysis(@PathVariable Integer id) {
        Optional<Analysis> analysisOptional = analysisServiceInterface.getAnalysisById(id);
        if (analysisOptional.isPresent()) {
            analysisServiceInterface.deleteAnalysis(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}