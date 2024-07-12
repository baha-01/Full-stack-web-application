package tn.esprit.backend.serviceInterface;

import tn.esprit.backend.entity.Property;

import java.util.List;

public interface PropertyServiceInterface {
    List<Property> getAllProperties();
    Property getPropertyById(Long id);
    Property saveProperty(Property property);
    //Property updateProperty(Long id, Property property);
    void deleteProperty(Long id);
}
