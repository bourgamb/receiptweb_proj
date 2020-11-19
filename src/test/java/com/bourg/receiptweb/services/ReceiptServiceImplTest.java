/**
 * 
 */
package com.bourg.receiptweb.services;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.bourg.receiptweb.domain.Receipt;
import com.bourg.receiptweb.repositories.ReceiptRepository;

/**
 * @author bourgamb
 *
 */
class ReceiptServiceImplTest {

	private ReceiptServiceImpl receiptServiceImpl;
	private ReceiptRepository receiptRepository;
	
	@BeforeEach
	public void setup() {
		
		this.receiptRepository = Mockito.mock(ReceiptRepository.class);
		
		this.receiptServiceImpl = new ReceiptServiceImpl(receiptRepository);
		
	}
	
	/**
	 * Test method for {@link com.bourg.receiptweb.services.ReceiptServiceImpl#getReceipts()}.
	 */
	@Test
	void testGetReceipts() {
		
		Receipt receipt = new Receipt();
		Set<Receipt> receiptData = new HashSet<>();
		
		receiptData.add(receipt);
		
		when(receiptRepository.findAll()).thenReturn(receiptData);
		
		Set<Receipt> receipts = this.receiptServiceImpl.getReceipts();
		
		assertThat(receipts).hasSize(1);
		
	}

}
