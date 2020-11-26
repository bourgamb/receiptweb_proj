/**
 * 
 */
package com.bourg.receiptweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bourg.receiptweb.command.ReceiptCommand;
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
	
	@RequestMapping("/receipt/{id}/show")
	public String showById(@PathVariable String id, Model model) {
		
		model.addAttribute("receipt", receiptService.findById(Long.valueOf(id)));
		
		return "receipt/show";
		
	}
	
	
	@RequestMapping("/receipt/new")
	public String showById(Model model) {
		
		model.addAttribute("receipt", new ReceiptCommand());
		
		return "receipt/receiptform";
		
	}
	
	@PostMapping("/receipt")
	public String saveOrUpdate(@ModelAttribute ReceiptCommand command) {
		
		ReceiptCommand savedCommand = receiptService.saveReceiptCommand(command);
		
		return "redirect:/receipt/" + savedCommand.getId() + "/show" ;
		
	}
	
	@GetMapping("/receipt/{id}/update")
	public String update(@ModelAttribute ReceiptCommand command, Model model) {
		
		ReceiptCommand updateCommand = receiptService.findCommandById(command);
		
		model.addAttribute("receipt", updateCommand);
		
		return "receipt/receiptform" ;
		
	}
	
	
}
