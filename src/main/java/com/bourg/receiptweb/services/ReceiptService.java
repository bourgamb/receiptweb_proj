/**
 * 
 */
package com.bourg.receiptweb.services;

import java.util.Set;

import com.bourg.receiptweb.domain.Receipt;

/**
 * @author bourgamb
 *
 */
public interface ReceiptService {

	Set<Receipt> getReceipts();
	Receipt findById(Long id);
	
}
