package tn.esprit.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    Integer propertyId;

    String title;

    String description;

    Double price;

    String location;

    @Enumerated(EnumType.STRING)
    PropertyType type;

    @Enumerated(EnumType.STRING)
    PropertyStatus status;

    @Temporal(TemporalType.DATE)
    Date postedDate;

    @Lob
    private byte[] image;

    // @ManyToOne
    // @ToString.Exclude
    // @JsonIgnore
    // User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "property_id")
    @ToString.Exclude
    List<Feedback> feedbacks;
}
