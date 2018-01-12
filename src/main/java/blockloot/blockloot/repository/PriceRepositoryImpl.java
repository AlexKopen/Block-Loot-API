package blockloot.blockloot.repository;

import blockloot.blockloot.model.Price;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PriceRepositoryImpl implements PriceRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Price> getBySmbolAndDateRange(String symbol, String startDate, String endDate) {
        startDate = startDate.isEmpty() ? "2000-01-01" : startDate;
        endDate = endDate.isEmpty() ? "2100-01-01" : endDate;

        Query query = entityManager.createNativeQuery("SELECT * FROM prices WHERE symbol = ? AND date between ? and ? ORDER BY date DESC", Price.class);
        query.setParameter(1, symbol);
        query.setParameter(2, startDate + " 00:00:00");
        query.setParameter(3, endDate + " 23:59:59");

        return query.getResultList();
    }
}
