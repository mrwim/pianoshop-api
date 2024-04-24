package nl.inholland.pianoshopapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Brand {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;
    private String country;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Piano> pianos = new ArrayList<>();

    public Brand(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
