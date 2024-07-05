package tn.esprit.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.entity.*;
import tn.esprit.backend.service.serviceInterface.IService;

import java.util.List;


@RestController
@RequestMapping("/GestionImmobiliere")
@AllArgsConstructor
public class Controller {

    IService iService;

    @GetMapping("/reclamations")
    public List<Reclamation> retrieveAllReclamations() {
        return iService.retrieveAllReclamations();
    }

    @PostMapping("/AjouterReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return iService.addReclamation(reclamation);
    }

    @PutMapping("/mettreAjourReclamation")
    public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
        return iService.updateReclamation(reclamation);
    }

    @GetMapping("/RetrouverReclamationById/{numReclamation}")
    public Reclamation retrieveReclamation(@PathVariable("numReclamation") Long numReclamation) {
        return iService.retrieveReclamation(numReclamation);
    }

    @PostMapping("/getReclamationByType/{type}")
    public Reclamation getReclamationByType(@PathVariable("type") ReclamationType type) {
        return iService.getReclamationByType(type);
    }
}
