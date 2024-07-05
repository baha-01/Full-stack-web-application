package tn.esprit.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    Integer feedbackId;

    String content;

    Integer rating;

    @Temporal(TemporalType.DATE)
    Date datePosted;

    // @ManyToOne
    // @ToString.Exclude
    // @JsonIgnore
    // User user;

    @ManyToOne
    @JoinColumn(name = "property_id")
    Property property;
}
