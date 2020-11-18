/**
 * 
 */
package com.bourg.receiptweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bourg.receiptweb.domain.Receipt;

/**
 * @author bourgamb
 *
 */
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

}
