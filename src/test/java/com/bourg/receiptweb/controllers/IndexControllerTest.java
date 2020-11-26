/**
 * 
 */
package com.bourg.receiptweb.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.bourg.receiptweb.domain.Receipt;
import com.bourg.receiptweb.services.ReceiptServiceImpl;

/**
 * @author bourgamb
 *
 */
class IndexControllerTest {

	private MockMvc mockMvc;
	private ReceiptServiceImpl receiptServiceImpl; 
	private IndexController indexController;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		
		
		this.receiptServiceImpl = Mockito.mock(ReceiptServiceImpl.class);
		
		this.indexController = new IndexController(this.receiptServiceImpl);
	
		this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		
	}
	
	@Test
	public void testMockMVC() throws Exception {
		
		this.mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"))
				;
	}

	@Test
	public void getIndexPage() {

		Set<Receipt> receiptSet = new HashSet<>();
		Receipt rec = new Receipt();
		rec.setId(1L);
		receiptSet.add(rec);
		
		ArgumentCaptor<Set<Receipt>> argCaptorReceiptSet = ArgumentCaptor.forClass(Set.class);
		when(this.receiptServiceImpl.getReceipts()).thenReturn(receiptSet);
		
		Model model = Mockito.mock(Model.class);
		String indexPage = this.indexController.getIndexPage(model);
		
		assertThat("index").isEqualTo(indexPage);
		verify(receiptServiceImpl, times(1)).getReceipts();
		verify(model, times(1)).addAttribute(eq("receipts"), argCaptorReceiptSet.capture());
		
		Set<Receipt> setInController = argCaptorReceiptSet.getValue();
		
		assertThat(setInController).hasSize(1);
	}
	
	

}
