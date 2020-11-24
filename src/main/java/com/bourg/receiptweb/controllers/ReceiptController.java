/**
 * 
 */
package com.bourg.receiptweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bourg.receiptweb.services.ReceiptService;

/**
 * @author bourgamb
 *
 */
@Controller
public class ReceiptController {

	private final ReceiptService receiptService;

	/**
	 * @param receiptService
	 */
	public ReceiptController(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}
	
	@RequestMapping("/receipt/show/{id}")
	public String showById(@PathVariable String id, Model model) {
		
		model.addAttribute("receipt", receiptService.findById(Long.valueOf(id)));
		
		return "receipt/show";
		
	}
	
	
}
