package nl.inholland.pianoshopapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Brand {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private String description;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Piano> pianos = new ArrayList<>();

    public Brand(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
