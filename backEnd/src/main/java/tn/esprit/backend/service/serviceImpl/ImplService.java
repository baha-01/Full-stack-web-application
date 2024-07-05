package tn.esprit.backend.service.serviceImpl;

import org.springframework.stereotype.Service;
import tn.esprit.backend.entity.Reclamation;
import tn.esprit.backend.entity.ReclamationType;
import tn.esprit.backend.repository.ReclamationRepository;
import tn.esprit.backend.service.serviceInterface.IService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ImplService implements IService {

ReclamationRepository reclamationRepository;


    @Override
    public List<Reclamation> retrieveAllReclamations() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return null;
    }

    @Override
    public Reclamation retrieveReclamation(Long numReclamation) {
        return null;
    }

    @Override
    public Reclamation getReclamationByType(ReclamationType type) {
        return null;
    }
}
