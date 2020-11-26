/**
 * 
 */
package com.bourg.receiptweb.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.bourg.receiptweb.command.NotesCommand;
import com.bourg.receiptweb.domain.Notes;

import lombok.Synchronized;

/**
 * @author bourgamb
 *
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes>{

	@Synchronized
	@Nullable
	@Override
	public Notes convert(NotesCommand source) {

		if(source == null) {
			return null;
		}

		final Notes notes = new Notes();
		notes.setId(source.getId());
		notes.setReceiptNotes(source.getReceiptNotes());
		
		return notes;
	
	}

}
