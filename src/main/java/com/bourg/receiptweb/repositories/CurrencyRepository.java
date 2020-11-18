/**
 * 
 */
package com.bourg.receiptweb.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bourg.receiptweb.domain.Currency;

/**
 * @author bourgamb
 *
 */
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

	Optional<Currency> findByCurrency(String currency);
	
}
