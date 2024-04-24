package nl.inholland.pianoshopapi.repository;

import nl.inholland.pianoshopapi.model.Piano;
import nl.inholland.pianoshopapi.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findAllByPiano(Piano piano);

    // JPQL
    List<Stock> findByQuantityLessThan(int quantity);

    // This query does the exact same thing as the one above
    // but with a custom query
    @Query("select s from Stock s where s.quantity < :quantity")
    List<Stock> findByStockLowerThan(int quantity);
}
