package nl.inholland.pianoshopapi.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String password;

    @ElementCollection(fetch = jakarta.persistence.FetchType.EAGER)
    private List<Role> roles;
}
