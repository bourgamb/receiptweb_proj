/**
 * 
 */
package com.bourg.receiptweb.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bourg.receiptweb.command.ReceiptCommand;
import com.bourg.receiptweb.domain.Receipt;
import com.bourg.receiptweb.services.ReceiptServiceImpl;

/**
 * @author bourgamb
 *
 */
class ReceiptControllerTest {
	
	private ReceiptServiceImpl receiptServiceImpl; 
	private ReceiptController receiptController;
	private MockMvc mockMvc;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		
		this.receiptServiceImpl = Mockito.mock(ReceiptServiceImpl.class);
		
		this.receiptController = new ReceiptController(this.receiptServiceImpl);
	
		this.mockMvc = MockMvcBuilders.standaloneSetup(receiptController).build();
	}
	
	@Test
	public void testMockMVC() throws Exception {
		
		Receipt receipt = new Receipt();
		receipt.setId(1L);
		
		when(receiptServiceImpl.findById(anyLong())).thenReturn(receipt);
		
		mockMvc.perform(get("/receipt/1/show"))
				.andExpect(status().isOk())
				.andExpect(view().name("receipt/show"))
				;
	}
	
	@Test
	public void testPostNewReceiptForm() throws Exception {

		ReceiptCommand receiptCommand = new ReceiptCommand();
		receiptCommand.setId(1L);
		
		when(receiptServiceImpl.saveReceiptCommand(any())).thenReturn(receiptCommand);
		
		mockMvc.perform(post("/receipt")
					   .contentType(MediaType.APPLICATION_FORM_URLENCODED)
					   .param("id", "")
					   .param("description", "some str"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/receipt/1/show"));
		
	}
	
	@Test
	public void testGetUpdateView() throws Exception {
		
		ReceiptCommand receiptCommand = new ReceiptCommand();
		receiptCommand.setId(1L);
		
		when(receiptServiceImpl.findCommandById(any())).thenReturn(receiptCommand);
	
		this.mockMvc.perform(get("/receipt/1/update"))
					.andExpect(status().isOk())
					.andExpect(view().name("receipt/receiptform"))
					.andExpect(model().attributeExists("receipt"))
					;
		
	}

	@Test
	public void testDeleteAction() throws Exception {
		
		this.mockMvc.perform(get("/receipt/1/delete"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/index"))
		;

	}
	
}
