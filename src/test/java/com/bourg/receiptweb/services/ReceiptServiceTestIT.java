/**
 * 
 */
package com.bourg.receiptweb.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.bourg.receiptweb.command.ReceiptCommand;
import com.bourg.receiptweb.converters.ReceiptCommandToReceipt;
import com.bourg.receiptweb.converters.ReceiptToReceiptCommand;
import com.bourg.receiptweb.domain.Receipt;
import com.bourg.receiptweb.repositories.ReceiptRepository;

/**
 * @author bourgamb
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReceiptServiceTestIT {

	@Autowired
	ReceiptService receiptService;
	
	@Autowired
	ReceiptCommandToReceipt receiptCommandToReceipt;
	
	@Autowired
	ReceiptToReceiptCommand receiptToReceiptCommand;
	
	@Autowired 
	ReceiptRepository receiptRepository;
	
	@Transactional
	@Test
	void testFindByCurrency() {

		//given
		Iterable<Receipt> receipts = receiptRepository.findAll();
		Receipt testReceipt = receipts.iterator().next();
		ReceiptCommand testReceiptCommand = receiptToReceiptCommand.convert(testReceipt);
		
		//when
		testReceiptCommand.setDescription("Ambrose");
		ReceiptCommand saveReceiptCommand = receiptService.saveReceiptCommand(testReceiptCommand);
		
		//then
		assertThat("Ambrose").isEqualTo(saveReceiptCommand.getDescription());
		assertThat(testReceiptCommand.getId()).isEqualTo(saveReceiptCommand.getId());
		assertThat(testReceiptCommand.getCategory().size()).isEqualTo(saveReceiptCommand.getCategory().size());
		assertThat(testReceiptCommand.getReceiptEntry().size()).isEqualTo(saveReceiptCommand.getReceiptEntry().size());
		
	}

}
