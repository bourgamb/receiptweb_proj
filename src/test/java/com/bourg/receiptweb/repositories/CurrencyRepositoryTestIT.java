/**
 * 
 */
package com.bourg.receiptweb.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bourg.receiptweb.domain.Currency;

/**
 * @author bourgamb
 *
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class CurrencyRepositoryTestIT {

	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired 
	private DataSource dataSource;
	  
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private EntityManager entityManager;
	
	@BeforeEach
	public void setup() {
		
	}
	
	@Test
	void testFindByCurrency() {

		Optional<Currency> usdCurrency = this.currencyRepository.findByCurrency("USD");
		
		Currency currency = this.entityManager.find(Currency.class, 1L);
		
		assertThat("USD").isEqualTo(usdCurrency.get().getCurrency());
		
	}

}
