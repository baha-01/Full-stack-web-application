package tn.esprit.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numReclamation;

    LocalDate date;

    @Enumerated(EnumType.STRING)
    ReclamationType type;

    String description;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    User user;

}
