package tn.esprit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend.entity.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
}