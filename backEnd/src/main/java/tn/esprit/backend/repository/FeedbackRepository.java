package tn.esprit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend.entity.Feedback;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
    List<Feedback> findByPropertyPropertyId(Long propertyId);
}
