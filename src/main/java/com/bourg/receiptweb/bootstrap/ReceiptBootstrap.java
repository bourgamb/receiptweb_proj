/**
 * 
 */
package com.bourg.receiptweb.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		this.receiptRepository.saveAll(getReceipts());

	}

	private List<Receipt> getReceipts(){

		Set<Category> categorySet = new HashSet<>();
		Set<ReceiptEntry> receiptEntrySet = new HashSet<>();
		
		Optional<Category> categoryAmerican = categoryRepository.findByDescription("American");
		
		categorySet.add(categoryAmerican.get());
		
		List<Receipt> receipts = new ArrayList<>(2);
		
		Receipt rec1 = new Receipt();
		rec1.setApproval(Approval.Approved);
		rec1.setDescription("Test Receipt");
		rec1.setType("Travel");
		rec1.setTotalAmount(BigDecimal.TEN);
		rec1.setCurrency("USD");
		rec1.setUrl("http://test.com");
		
		Notes note = new Notes();
		note.setReceipt(rec1);
		note.setReceiptNotes("Receipt notes");
		
		Currency curr = new Currency();
		curr.setCurrency("EUR");
		
		currencyRepository.save(curr);
		
		ReceiptEntry receiptEntry = new ReceiptEntry();
		receiptEntry.setAmount(BigDecimal.TEN);
		receiptEntry.setCurrency(curr);
		receiptEntry.setDescription("Receipt entry 1");
		receiptEntry.setQuantity(1);
		receiptEntry.setReceipt(rec1);
		
		receiptEntrySet.add(receiptEntry);
		
		rec1.setNotes(note);
		rec1.setCurrency("USD");
		rec1.setReceiptEntry(receiptEntrySet);
		
		receipts.add(rec1);
		
		return receipts;
	}
}