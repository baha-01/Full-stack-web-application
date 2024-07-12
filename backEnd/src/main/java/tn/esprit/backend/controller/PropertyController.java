package tn.esprit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.entity.Feedback;
import tn.esprit.backend.entity.Property;
import tn.esprit.backend.entity.PropertyDTO;
import tn.esprit.backend.entity.ResourceNotFoundException;
import tn.esprit.backend.serviceInterface.FeedbackServiceInterface;
import tn.esprit.backend.serviceInterface.PropertyServiceInterface;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/property")
public class PropertyController {
    @Autowired
    PropertyServiceInterface propertyServiceInterface;

    @Autowired
    FeedbackServiceInterface feedbackServiceInterface;
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        try {
            List<Property> properties = propertyServiceInterface.getAllProperties();
            return ResponseEntity.ok(properties);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        try {
            Property property = propertyServiceInterface.getPropertyById(id);
            if (property != null) {
                List<Feedback> feedbacks = feedbackServiceInterface.getFeedbacksByPropertyId(id);
                property.setFeedbacks(feedbacks);
            }
            return ResponseEntity.ok(property);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody PropertyDTO propertyDTO) {
        try {
            Property property = new Property();
            property.setTitle(propertyDTO.getTitle());
            property.setDescription(propertyDTO.getDescription());
            property.setPrice(propertyDTO.getPrice());
            property.setLocation(propertyDTO.getLocation());
            property.setType(propertyDTO.getType());
            property.setStatus(propertyDTO.getStatus());
            property.setPostedDate(propertyDTO.getPostedDate());
            property.setImage(Base64.getDecoder().decode(propertyDTO.getImage()));

            Property savedProperty = propertyServiceInterface.saveProperty(property);
            return ResponseEntity.ok(savedProperty);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
        try {
            Property existingProperty = propertyServiceInterface.getPropertyById(id);

            existingProperty.setTitle(propertyDTO.getTitle());
            existingProperty.setDescription(propertyDTO.getDescription());
            existingProperty.setPrice(propertyDTO.getPrice());
            existingProperty.setLocation(propertyDTO.getLocation());
            existingProperty.setType(propertyDTO.getType());
            existingProperty.setStatus(propertyDTO.getStatus());
            existingProperty.setPostedDate(propertyDTO.getPostedDate());

            if (propertyDTO.getImage() != null && !propertyDTO.getImage().isEmpty()) {
                existingProperty.setImage(Base64.getDecoder().decode(propertyDTO.getImage()));
            }

            Property updatedProperty = propertyServiceInterface.saveProperty(existingProperty);
            return ResponseEntity.ok(updatedProperty);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyServiceInterface.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
