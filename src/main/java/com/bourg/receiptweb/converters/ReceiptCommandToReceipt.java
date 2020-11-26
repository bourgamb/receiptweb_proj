/**
 * 
 */
package com.bourg.receiptweb.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.bourg.receiptweb.command.ReceiptCommand;
import com.bourg.receiptweb.domain.Receipt;

import lombok.Synchronized;

/**
 * @author bourgamb
 *
 */
@Component
public class ReceiptCommandToReceipt implements Converter<ReceiptCommand, Receipt> {

	private final ReceiptEntryCommandToReceiptEntry receiptCoverter;
	private final CategoryCommandToCategory categoryConverter;
	private final NotesCommandToNotes notesConverter;
	
	public ReceiptCommandToReceipt(ReceiptEntryCommandToReceiptEntry receiptCoverter, 
			CategoryCommandToCategory categoryConverter,
			NotesCommandToNotes notesConverter) {

		this.receiptCoverter = receiptCoverter;
		this.categoryConverter = categoryConverter;
		this.notesConverter = notesConverter;
	
	}
	
	@Synchronized
	@Nullable
	@Override
	public Receipt convert(ReceiptCommand source) {

		if(source == null) {
			return null;
		}
		
		final Receipt receipt = new Receipt();
		receipt.setCurrency(source.getCurrency());
		receipt.setDescription(source.getDescription());
		receipt.setId(source.getId());
		receipt.setNotes(notesConverter.convert(source.getNotes()));
		receipt.setTotalAmount(source.getTotalAmount());
		receipt.setType(source.getType());
		receipt.setUrl(source.getUrl());
		
		if(source.getCategory() !=null && source.getCategory().size() > 0) {
			
			source.getCategory().forEach( x -> receipt.getCategories().add(categoryConverter.convert(x)));
			
		}
		
		if(source.getReceiptEntry() !=null && source.getReceiptEntry().size() > 0) {
			
			source.getReceiptEntry().forEach( x -> receipt.getReceiptEntry().add(receiptCoverter.convert(x)));
			
		}
		
		return receipt;
	}
}