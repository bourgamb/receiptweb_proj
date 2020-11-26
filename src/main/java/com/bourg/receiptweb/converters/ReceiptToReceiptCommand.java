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
public class ReceiptToReceiptCommand implements Converter<Receipt, ReceiptCommand> {

	private final ReceiptEntryToReceiptEntryCommand receiptCoverter;
	private final CategoryToCategoryCommand categoryConverter;
	private final NotesToNotesCommand notesConverter;
	
	public ReceiptToReceiptCommand(ReceiptEntryToReceiptEntryCommand receiptCoverter, 
								  CategoryToCategoryCommand categoryConverter,
								  NotesToNotesCommand notesConverter) {

		this.receiptCoverter = receiptCoverter;
		this.categoryConverter = categoryConverter;
		this.notesConverter = notesConverter;
	
	}
	
	@Synchronized
	@Nullable
	@Override
	public ReceiptCommand convert(Receipt source) {

		if(source == null) {
			return null;
		}
		
		final ReceiptCommand receiptCommand = new ReceiptCommand();
		receiptCommand.setCurrency(source.getCurrency());
		receiptCommand.setDescription(source.getDescription());
		receiptCommand.setId(source.getId());
		receiptCommand.setNotes(notesConverter.convert(source.getNotes()));
		receiptCommand.setTotalAmount(source.getTotalAmount());
		receiptCommand.setType(source.getType());
		receiptCommand.setUrl(source.getUrl());
		
		if(source.getCategories() !=null && source.getCategories().size() > 0) {
			
			source.getCategories().forEach( x -> receiptCommand.getCategory().add(categoryConverter.convert(x)));
			
		}
		
		if(source.getReceiptEntry() !=null && source.getReceiptEntry().size() > 0) {
			
			source.getReceiptEntry().forEach( x -> receiptCommand.getReceiptEntry().add(receiptCoverter.convert(x)));
			
		}
		
		return receiptCommand;
	}
}