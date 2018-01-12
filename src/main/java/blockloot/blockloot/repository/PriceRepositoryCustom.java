package blockloot.blockloot.repository;

import blockloot.blockloot.model.Price;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepositoryCustom {
    List<Price> getBySmbolAndDateRange(String symbol, String startDate, String endDate);
}
