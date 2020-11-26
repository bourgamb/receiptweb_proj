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
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

	@Synchronized
	@Nullable
	@Override
	public Category convert(CategoryCommand source) {

		if(source == null) {
			return null;
		}
		
		final Category category = new Category();
		category.setDescription(source.getDescription());
		category.setId(source.getId());
		
		return category;
	}
}