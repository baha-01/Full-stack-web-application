package tn.esprit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend.repository.PropertyRepository;
import tn.esprit.backend.serviceInterface.PropertyServiceInterface;

@Service
public class PropertyService implements PropertyServiceInterface {
    @Autowired
    PropertyRepository propertyRepository;
}
