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
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    // @ManyToOne
    // @ToString.Exclude
    // @JsonIgnore
    // User user;
}
