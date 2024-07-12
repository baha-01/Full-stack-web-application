package tn.esprit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend.entity.Property;

public interface PropertyRepository extends JpaRepository<Property,Long> {
}
