/**
 * 
 */
package com.bourg.receiptweb.command;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.bourg.receiptweb.enums.Approval;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bourgamb
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReceiptCommand {

	private Long id;
	private String description;
	private String type;
	private BigDecimal totalAmount;
	private String currency;
	private String url;
	private Approval approval;
	private NotesCommand notes;
	private Set<ReceiptEntryCommand> receiptEntry = new HashSet<>();
	private Set<CategoryCommand> category = new HashSet<>();

	
}
