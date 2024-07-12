package tn.esprit.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private String title;
    private String description;
    private Double price;
    private String location;
    private PropertyType type;
    private PropertyStatus status;
    private Date postedDate;
    private String image; // Base64 encoded image

    // Getters and Setters
}
