/**
 * 
 */
package com.bourg.receiptweb.bootstrap;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bourg.receiptweb.domain.Category;
import com.bourg.receiptweb.domain.Currency;
import com.bourg.receiptweb.domain.Notes;
import com.bourg.receiptweb.domain.Receipt;
import com.bourg.receiptweb.domain.ReceiptEntry;
import com.bourg.receiptweb.enums.Approval;
import com.bourg.receiptweb.repositories.CategoryRepository;
import com.bourg.receiptweb.repositories.CurrencyRepository;
import com.bourg.receiptweb.repositories.ReceiptRepository;

/**
 * @author bourgamb
 *
 */
@Component
@Profile("default")
public class ReceiptBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private final ReceiptRepository receiptRepository;
	private final CurrencyRepository currencyRepository;
	private final CategoryRepository categoryRepository;
	
	ReceiptBootstrap(ReceiptRepository receiptRepository,
					 CurrencyRepository currencyRepository,
					 CategoryRepository categoryRepository){
		
		this.receiptRepository = receiptRepository;
		this.currencyRepository = currencyRepository;
		this.categoryRepository = categoryRepository;
		
	}

	@Transactional
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		this.receiptRepository.saveAll(getReceipts());
		Iterable<Receipt> findAll = this.receiptRepository.findAll();
		System.out.println("");
	}

	private List<Receipt> getReceipts(){

		Optional<Category> categoryItalian = categoryRepository.findByDescription("Italian");
		Optional<Category> categoryAmerican = categoryRepository.findByDescription("American");
		
		Receipt rec1 = new Receipt();
		rec1.setApproval(Approval.Approved);
		rec1.setDescription("Test Receipt");
		rec1.setType("Travel");
		rec1.setTotalAmount(BigDecimal.TEN);
		rec1.setCurrency("USD");
		rec1.setUrl("http://www.test.com");
		
		Notes note = new Notes();
		note.setReceiptNotes("Receipt notes");
		rec1.addNote(note);
		
		Currency curr = new Currency();
		curr.setCurrency("EUR");
		
		currencyRepository.save(curr);
		
		ReceiptEntry receiptEntry = new ReceiptEntry();
		receiptEntry.setAmount(BigDecimal.TEN);
		receiptEntry.setCurrency(curr);
		receiptEntry.setDescription("Receipt entry 1");
		receiptEntry.setQuantity(1);
		
		rec1.addReceiptEntry(receiptEntry);
		
		rec1.setCurrency("USD");
		
		rec1.getCategories().add(categoryItalian.get());
		rec1.getCategories().add(categoryAmerican.get());
		
		
		Receipt rec2 = new Receipt();
		rec2.setApproval(Approval.Approved);
		rec2.setDescription("Another Receipt");
		rec2.setType("Travel");
		rec2.setTotalAmount(BigDecimal.TEN);
		rec2.setCurrency("USD");
		rec2.setUrl("http://www.test.com");
		
		Notes note2 = new Notes();
		note2.setReceiptNotes("Receipt notes");
		rec2.addNote(note2);
		
		Currency curr2 = new Currency();
		curr2.setCurrency("EUR");
		
		currencyRepository.save(curr2);
		
		ReceiptEntry receiptEntry2 = new ReceiptEntry();
		receiptEntry2.setAmount(BigDecimal.TEN);
		receiptEntry2.setCurrency(curr);
		receiptEntry2.setDescription("Receipt entry 1");
		receiptEntry2.setQuantity(1);
		
		rec2.addReceiptEntry(receiptEntry2);
		
		rec2.setCurrency("USD");
		
		rec2.getCategories().add(categoryItalian.get());
		rec2.getCategories().add(categoryAmerican.get());
		
		return Arrays.asList(rec1, rec2);
	}
}