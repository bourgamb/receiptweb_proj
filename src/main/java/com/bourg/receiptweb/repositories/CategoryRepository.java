/**
 * 
 */
package com.bourg.receiptweb.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bourg.receiptweb.domain.Category;

/**
 * @author bourgamb
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);
}
