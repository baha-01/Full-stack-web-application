package tn.esprit.backend.service.serviceInterface;

import tn.esprit.backend.entity.Reclamation;
import tn.esprit.backend.entity.ReclamationType;


import java.util.List;

public interface IServiceReclamation {
    List<Reclamation> retrieveAllReclamations();
    Reclamation addReclamation (Reclamation reclamation );
    Reclamation updateReclamation (Reclamation reclamation);
    Reclamation retrieveReclamation (Long numReclamation);
    Reclamation getReclamationByType(ReclamationType type);

}
