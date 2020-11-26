/**
 * 
 */
package com.bourg.receiptweb.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.bourg.receiptweb.command.CategoryCommand;
import com.bourg.receiptweb.domain.Category;

import lombok.Synchronized;

/**
 * @author bourgamb
 *
 */
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

	@Synchronized
	@Nullable
	@Override
	public CategoryCommand convert(Category source) {

		if(source == null) {
			return null;
		}
	
		CategoryCommand categoryCommand = new CategoryCommand();
		categoryCommand.setDescription(source.getDescription());
		categoryCommand.setId(source.getId());
		
		return categoryCommand;
		
	}

	
	
}
