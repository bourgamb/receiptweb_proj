/**
 * 
 */
package com.bourg.receiptweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bourg.receiptweb.services.ReceiptService;

/**
 * @author bourgamb
 *
 */
@Controller
public class ReceiptEntryController {

	private final ReceiptService receiptService;

	/**
	 * @param receiptService
	 */
	public ReceiptEntryController(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}
	
	@GetMapping("/receipt/{id}/receiptentry")
	public String listReceiptEntries(@PathVariable String id, Model model) {
		
		model.addAttribute("receipt", receiptService.findCommandById(Long.valueOf(id)));
		
		return "receipt/entry/list";
		
	}
	
}