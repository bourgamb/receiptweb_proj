package com.bourg.receiptweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bourg.receiptweb.services.ReceiptServiceImpl;

@Controller
public class IndexController {

	private final ReceiptServiceImpl receiptServiceImpl;
	
	public IndexController(ReceiptServiceImpl receiptServiceImpl) {

		this.receiptServiceImpl = receiptServiceImpl;
	}
	
	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {

		model.addAttribute("receipts", receiptServiceImpl.getReceipts());
		
		return "index";
	}
	
}
