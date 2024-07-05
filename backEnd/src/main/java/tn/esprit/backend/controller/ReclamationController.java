package tn.esprit.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.entity.*;
import tn.esprit.backend.service.serviceInterface.IServiceReclamation;

import java.util.List;


@RestController
@RequestMapping("/GestionImmobiliere")
@AllArgsConstructor
public class ReclamationController {

    IServiceReclamation iServiceReclamation;

    @GetMapping("/reclamations")
    public List<Reclamation> retrieveAllReclamations() {
        return iServiceReclamation.retrieveAllReclamations();
    }

    @PostMapping("/AjouterReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return iServiceReclamation.addReclamation(reclamation);
    }

    @PutMapping("/mettreAjourReclamation")
    public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
        return iServiceReclamation.updateReclamation(reclamation);
    }

    @GetMapping("/RetrouverReclamationById/{numReclamation}")
    public Reclamation retrieveReclamation(@PathVariable("numReclamation") Long numReclamation) {
        return iServiceReclamation.retrieveReclamation(numReclamation);
    }

    @PostMapping("/getReclamationByType/{type}")
    public Reclamation getReclamationByType(@PathVariable("type") ReclamationType type) {
        return iServiceReclamation.getReclamationByType(type);
    }
}
