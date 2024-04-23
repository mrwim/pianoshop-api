package nl.inholland.pianoshopapi.service;

import jakarta.persistence.EntityNotFoundException;
import nl.inholland.pianoshopapi.model.Brand;
import nl.inholland.pianoshopapi.model.BrandDTO;
import nl.inholland.pianoshopapi.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand save(BrandDTO dto) {
        Brand brand = new Brand(dto.name(), dto.description());
        return brandRepository.save(brand);
    }

    public Brand findById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No such brand"));
    }

    public Brand findByName(String name) {
        return Optional.ofNullable(brandRepository.findByName(name)).orElseThrow(() -> new EntityNotFoundException("No such brand"));
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
