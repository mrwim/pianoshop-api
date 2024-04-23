package nl.inholland.pianoshopapi.configuration;

import nl.inholland.pianoshopapi.model.Piano;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

@Configuration
public class BeanFactory {

    @Bean
    RandomGenerator randomGenerator() {
        return RandomGenerator.getDefault();
    }

    @Bean
    List<Piano> allPianos() {
        return new ArrayList<>(
                List.of(
                        new Piano(1, "Yamaha", "U1", 1990),
                        new Piano(2, "Steinway", "B", 2000)
                )
        );
    }
}
