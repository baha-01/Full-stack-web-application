package tn.esprit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.backend.serviceInterface.PropertyServiceInterface;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    PropertyServiceInterface propertyServiceInterface;
}
