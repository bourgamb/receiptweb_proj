/**
 * 
 */
package com.bourg.receiptweb.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bourg.receiptweb.domain.Receipt;
import com.bourg.receiptweb.repositories.ReceiptRepository;

/**
 * @author bourgamb
 *
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {

	private final ReceiptRepository receiptRepository;
	
	/**
	 * @param receiptRepository
	 */
	public ReceiptServiceImpl(ReceiptRepository receiptRepository) {
		this.receiptRepository = receiptRepository;
	}

	@Override
	public Set<Receipt> getReceipts() {

		Set<Receipt> receiptSet = new HashSet<>();
		Iterable<Receipt> result = receiptRepository.findAll();
		
		result.forEach(receiptSet::add);
		
		return receiptSet;
	}

}
