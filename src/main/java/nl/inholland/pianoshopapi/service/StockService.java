package nl.inholland.pianoshopapi.service;

import nl.inholland.pianoshopapi.model.Stock;
import nl.inholland.pianoshopapi.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public List<Stock> getStockLowerThan10(int quantity) {
        return stockRepository.findByQuantityLessThan(quantity);
    }
}
