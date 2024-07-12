package tn.esprit.backend.serviceInterface;

import tn.esprit.backend.entity.Analysis;
import tn.esprit.backend.entity.Feedback;

import java.util.List;
import java.util.Optional;

public interface AnalysisServiceInterface {
    public List<Analysis> getAllAnalysis();
    public Optional<Analysis> getAnalysisById(Integer id);
    public Analysis saveAnalysis(Analysis analysis);
    public Analysis updateAnalysis(Analysis analysis);
    public void deleteAnalysis(Integer id);
}
