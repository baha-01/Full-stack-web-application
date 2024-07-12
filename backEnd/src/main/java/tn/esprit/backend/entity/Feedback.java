package tn.esprit.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long feedbackId;

    private String content;

    private Integer rating;

    @Temporal(TemporalType.DATE)
    private Date datePosted;

    // @ManyToOne
    // @ToString.Exclude
    // @JsonIgnore
    // User user;

    @ManyToOne
    @JoinColumn(name="property_id")
    @JsonIgnore
    private Property property;
}
