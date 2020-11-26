/**
 * 
 */
package com.bourg.receiptweb.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.bourg.receiptweb.command.ReceiptEntryCommand;
import com.bourg.receiptweb.domain.ReceiptEntry;

import lombok.Synchronized;

/**
 * @author bourgamb
 *
 */
@Component
public class ReceiptEntryToReceiptEntryCommand implements Converter<ReceiptEntry, ReceiptEntryCommand>{

	@Synchronized
	@Nullable
	@Override
	public ReceiptEntryCommand convert(ReceiptEntry source) {

		ReceiptEntryCommand receiptEntryCommand = new ReceiptEntryCommand();
		receiptEntryCommand.setId(source.getId());
		receiptEntryCommand.setDescription(source.getDescription());		
		receiptEntryCommand.setAmount(source.getAmount());
		receiptEntryCommand.setQuantity(source.getQuantity());
		
		return receiptEntryCommand;
	}


	
}
