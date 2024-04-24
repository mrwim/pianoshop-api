package nl.inholland.pianoshopapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@SequenceGenerator(name = "PIANO_SEQ", initialValue = 100001, allocationSize = 10)
public class Piano {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    private Brand brand;
    private String model;
    private int year;

    public Piano(Brand brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

}
