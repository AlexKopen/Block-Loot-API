package blockloot.blockloot.repository;

import blockloot.blockloot.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class PriceRepositoryImpl implements PriceRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Price> getBySmbolAndDateRange(List<String> symbols, String startDate, String endDate) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("symbols", symbols);
        parameters.addValue("startdate", startDate);
        parameters.addValue("enddate", endDate);

        return jdbcTemplate.query("SELECT * FROM prices WHERE symbol IN (:symbols) AND date between " +
                        ":startdate and :enddate ORDER BY date DESC",
                parameters, (resultSet, i) -> {
                    return toPrice(resultSet);
                });

    }

    private Price toPrice(ResultSet resultSet) throws SQLException {
        Price price = new Price();
        price.setId(resultSet.getLong("id"));
        price.setDate(resultSet.getString("date"));
        price.setSymbol(resultSet.getString("symbol"));
        price.setValue(resultSet.getDouble("value"));

        return price;
    }
}
