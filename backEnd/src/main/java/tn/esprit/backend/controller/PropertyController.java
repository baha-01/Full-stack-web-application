package tn.esprit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.entity.Property;
import tn.esprit.backend.serviceInterface.PropertyServiceInterface;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    PropertyServiceInterface propertyServiceInterface;

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyServiceInterface.getAllProperties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Integer id) {
        Optional<Property> property = propertyServiceInterface.getPropertyById(id);
        return property.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Property createProperty(@RequestBody Property property) {
        return propertyServiceInterface.saveProperty(property);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Integer id, @RequestBody Property propertyDetails) {
        Optional<Property> propertyOptional = propertyServiceInterface.getPropertyById(id);
        if (propertyOptional.isPresent()) {
            Property property = propertyOptional.get();
            property.setTitle(propertyDetails.getTitle());
            property.setDescription(propertyDetails.getDescription());
            property.setPrice(propertyDetails.getPrice());
            property.setLocation(propertyDetails.getLocation());
            property.setType(propertyDetails.getType());
            property.setStatus(propertyDetails.getStatus());
            property.setPostedDate(propertyDetails.getPostedDate());
            property.setImage(propertyDetails.getImage());
            //property.setUser(propertyDetails.getUser());
            property.setFeedbacks(propertyDetails.getFeedbacks());
            Property updatedProperty = propertyServiceInterface.updateProperty(property);
            return ResponseEntity.ok(updatedProperty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Integer id) {
        Optional<Property> propertyOptional = propertyServiceInterface.getPropertyById(id);
        if (propertyOptional.isPresent()) {
            propertyServiceInterface.deleteProperty(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
