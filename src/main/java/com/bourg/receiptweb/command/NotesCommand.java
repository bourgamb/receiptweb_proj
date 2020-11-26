/**
 * 
 */
package com.bourg.receiptweb.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bourgamb
 *
 */
@NoArgsConstructor
public class NotesCommand {

	private Long id;
	private String receiptNotes;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the receiptNotes
	 */
	public String getReceiptNotes() {
		return receiptNotes;
	}
	/**
	 * @param receiptNotes the receiptNotes to set
	 */
	public void setReceiptNotes(String receiptNotes) {
		this.receiptNotes = receiptNotes;
	}
	
	
}
