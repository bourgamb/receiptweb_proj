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
public class ReceiptEntryCommandToReceiptEntry implements Converter<ReceiptEntryCommand, ReceiptEntry>{

	@Synchronized
	@Nullable
	@Override
	public ReceiptEntry convert(ReceiptEntryCommand source) {

		ReceiptEntry receiptEntry = new ReceiptEntry();
		receiptEntry.setId(source.getId());
		receiptEntry.setDescription(source.getDescription());		
		receiptEntry.setAmount(source.getAmount());
		receiptEntry.setQuantity(source.getQuantity());
		
		return receiptEntry;
	}


	
}
