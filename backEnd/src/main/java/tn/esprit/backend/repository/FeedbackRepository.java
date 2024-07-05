package tn.esprit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}
