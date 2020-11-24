/**
 * 
 */
package com.bourg.receiptweb.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bourg.receiptweb.domain.Receipt;
import com.bourg.receiptweb.services.ReceiptServiceImpl;

/**
 * @author bourgamb
 *
 */
class ReceiptControllerTest {
	
	private ReceiptServiceImpl receiptServiceImpl; 
	private ReceiptController receiptController;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		
		this.receiptServiceImpl = Mockito.mock(ReceiptServiceImpl.class);
		
		this.receiptController = new ReceiptController(this.receiptServiceImpl);
	
	}
	
	@Test
	public void testMockMVC() throws Exception {
		
		Receipt receipt = new Receipt();
		receipt.setId(1L);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(receiptController).build();
		
		when(receiptServiceImpl.findById(anyLong())).thenReturn(receipt);
		
		mockMvc.perform(get("/receipt/show/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("receipt/show"))
				;
	}

}
