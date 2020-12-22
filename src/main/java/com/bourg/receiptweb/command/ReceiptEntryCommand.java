/**
 * 
 */
package com.bourg.receiptweb.command;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bourgamb
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class ReceiptEntryCommand {

	private Long id;
	private Long receiptId;
	private String description;
	private BigDecimal amount;
	private Integer quantity;
	
}
