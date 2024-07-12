package tn.esprit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend.entity.Feedback;
import tn.esprit.backend.entity.Property;
import tn.esprit.backend.repository.PropertyRepository;
import tn.esprit.backend.serviceInterface.FeedbackServiceInterface;
import tn.esprit.backend.serviceInterface.PropertyServiceInterface;

import java.util.List;

@Service
public class PropertyService implements PropertyServiceInterface {
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    FeedbackServiceInterface feedbackServiceInterface;

    @Override
    public List<Property> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        properties.forEach(property -> {
            List<Feedback> feedbacks = feedbackServiceInterface.getFeedbacksByPropertyId(property.getPropertyId());
            property.setFeedbacks(feedbacks);
            calculateAndSetAverageRating(property);
        });
        return properties;
    }

    @Override
    public Property getPropertyById(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            List<Feedback> feedbacks = feedbackServiceInterface.getFeedbacksByPropertyId(id);
            property.setFeedbacks(feedbacks);
            calculateAndSetAverageRating(property);
        }
        return property;
    }

    @Override
    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property updateProperty(Long id, Property propertyDetails) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property!=null) {
            property.setTitle(propertyDetails.getTitle());
            property.setDescription(propertyDetails.getDescription());
            property.setPrice(propertyDetails.getPrice());
            property.setLocation(propertyDetails.getLocation());
            property.setType(propertyDetails.getType());
            property.setStatus(propertyDetails.getStatus());
            property.setPostedDate(propertyDetails.getPostedDate());
            property.setImage(propertyDetails.getImage());
            return propertyRepository.save(property);
        } else {
            return null;
        }
    }

    private void calculateAndSetAverageRating(Property property) {
        List<Feedback> feedbacks = property.getFeedbacks();
        double averageRating = feedbacks.stream()
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0.0);
        property.setAverageRating(averageRating);
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
