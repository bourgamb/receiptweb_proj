/**
 * 
 */
package com.bourg.receiptweb.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bourg.receiptweb.command.ReceiptCommand;
import com.bourg.receiptweb.converters.ReceiptCommandToReceipt;
import com.bourg.receiptweb.converters.ReceiptToReceiptCommand;
import com.bourg.receiptweb.domain.Receipt;
import com.bourg.receiptweb.repositories.ReceiptRepository;

/**
 * @author bourgamb
 *
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {

	private final ReceiptRepository receiptRepository;
	private final ReceiptToReceiptCommand receiptToReceiptCommand;
	private final ReceiptCommandToReceipt receiptCommandToReceipt;
	
	/**
	 * @param receiptRepository
	 */
	public ReceiptServiceImpl(ReceiptRepository receiptRepository, 
							  ReceiptToReceiptCommand receiptToReceiptCommand, 
							  ReceiptCommandToReceipt receiptCommandToReceipt) {
		this.receiptRepository = receiptRepository;
		this.receiptCommandToReceipt = receiptCommandToReceipt;
		this.receiptToReceiptCommand = receiptToReceiptCommand;
	}

	@Override
	public Set<Receipt> getReceipts() {

		Set<Receipt> receiptSet = new HashSet<>();
		Iterable<Receipt> result = receiptRepository.findAll();
		
		result.forEach(receiptSet::add);
		
		return receiptSet;
	}

	@Override
	public Receipt findById(Long id) {

		Optional<Receipt> receiptOptional = receiptRepository.findById(id);
		
		if(!receiptOptional.isPresent()) {
			throw new RuntimeException("Receipt not Found");
		}
		
		return receiptOptional.get();
		
	}
	
	@Override
	@Transactional
	public ReceiptCommand saveReceiptCommand(ReceiptCommand command) {
		
		Receipt receipt = receiptCommandToReceipt.convert(command);
		Receipt savedReceipt = receiptRepository.save(receipt);
		
		return receiptToReceiptCommand.convert(savedReceipt);
	}
	
	@Override
	@Transactional
	public ReceiptCommand findCommandById(Long id) {
		
		return receiptToReceiptCommand.convert(findById(id));
	}

	@Override
	@Transactional
	public void deleteByid(Long id) {
		
		this.receiptRepository.deleteById(id);
	}
}