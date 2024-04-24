package nl.inholland.pianoshopapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Piano {

    @Id
    @GeneratedValue
    private long id;
    private String model;
    private int year;
    @ManyToOne
    private Brand brand;

    public Piano(Brand brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}
