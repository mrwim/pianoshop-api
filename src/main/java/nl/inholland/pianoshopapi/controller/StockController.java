package nl.inholland.pianoshopapi.controller;

import nl.inholland.pianoshopapi.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stocks")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllStocks() {
        return ResponseEntity.status(200).body(stockService.getAllStocks());
    }

    @GetMapping(params = "quantity")
    public ResponseEntity<Object> getStockByLowerThan10(@RequestParam int quantity) {
        return ResponseEntity.status(200).body(stockService.getStockLowerThan10(quantity));
    }
}


