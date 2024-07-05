package tn.esprit.backend.serviceInterface;

import tn.esprit.backend.entity.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyServiceInterface {
    public List<Property> getAllProperties();
    public Optional<Property> getPropertyById(Integer id);
    public Property saveProperty(Property property);
    public Property updateProperty(Property property);
    public void deleteProperty(Integer id);
}
