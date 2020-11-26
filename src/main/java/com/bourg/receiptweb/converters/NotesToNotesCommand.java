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
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

	@Synchronized
	@Nullable
	@Override
	public NotesCommand convert(Notes source) {

		if(source ==null) {
			return null;
		}
		
		final NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(source.getId());
		notesCommand.setReceiptNotes(source.getReceiptNotes());
		
		return notesCommand;
	}

}
