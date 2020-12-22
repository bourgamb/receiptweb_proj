/**
 * 
 */
package com.bourg.receiptweb.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bourg.receiptweb.domain.Category;
import com.bourg.receiptweb.domain.Currency;
import com.bourg.receiptweb.repositories.CategoryRepository;
import com.bourg.receiptweb.repositories.CurrencyRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bourgamb
 *
 */
@Component
@Profile("dev")
@Slf4j
public class ReceiptBootstrapMySQL implements ApplicationListener<ContextRefreshedEvent>{

	private final CurrencyRepository currencyRepository;
	private final CategoryRepository categoryRepository;
	
	ReceiptBootstrapMySQL(CurrencyRepository currencyRepository,
					 CategoryRepository categoryRepository){
		
		this.currencyRepository = currencyRepository;
		this.categoryRepository = categoryRepository;
		
	}

	@Transactional
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if(categoryRepository.count()==0L) {
			log.debug("Loading Categories...");
			loadCategories();
		}
		
		if(currencyRepository.count()==0L) {
			log.debug("Loading Currencies...");
			loadCurrencies();
		}
	
	}

	/**
	 * 
	 */
	private void loadCurrencies() {
		
		Currency usd = new Currency();
		usd.setCurrency("USD");
		currencyRepository.save(usd);
		
		Currency gbp = new Currency();
		gbp.setCurrency("GBP");
		currencyRepository.save(gbp);
		
		Currency eur = new Currency();
		eur.setCurrency("EUR");
		currencyRepository.save(eur);
		
		Currency jpy = new Currency();
		jpy.setCurrency("JPY");
		currencyRepository.save(jpy);
		
		Currency mxn = new Currency();
		mxn.setCurrency("MXN");
		currencyRepository.save(mxn);
		
	}

	/**
	 * 
	 */
	private void loadCategories() {
		
		Category american = new Category();
		american.setDescription("American");
		categoryRepository.save(american);
		

		Category italian = new Category();
		italian.setDescription("Italian");
		categoryRepository.save(italian);
		

		Category mexican = new Category();
		mexican.setDescription("Mexican");
		categoryRepository.save(mexican);
		
		Category fastFood = new Category();
		fastFood.setDescription("Fast Food");
		categoryRepository.save(fastFood);
		
	}

	
}