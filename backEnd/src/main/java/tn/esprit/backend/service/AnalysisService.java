package tn.esprit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend.entity.Analysis;
import tn.esprit.backend.entity.Feedback;
import tn.esprit.backend.repository.AnalysisRepository;
import tn.esprit.backend.repository.FeedbackRepository;
import tn.esprit.backend.serviceInterface.AnalysisServiceInterface;
import tn.esprit.backend.serviceInterface.FeedbackServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class AnalysisService implements AnalysisServiceInterface {
    @Autowired
    private AnalysisRepository analysisRepository;

    public List<Analysis> getAllAnalysis() {
        return analysisRepository.findAll();
    }
    public Optional<Analysis> getAnalysisById(Integer id) {
        return analysisRepository.findById(id);
    }
    public Analysis saveAnalysis(Analysis analysis) {
        return analysisRepository.save(analysis);
    }
    public Analysis updateAnalysis(Analysis analysis) {
        return analysisRepository.save(analysis);
    }
    public void deleteAnalysis(Integer id) {
        analysisRepository.deleteById(id);
    }
}
