/**
 * 
 */
package com.bourg.receiptweb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 * @author bourgamb
 *
 */
@Entity
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Receipt receipt;
	
	@Lob
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
	 * @return the receipt
	 */
	public Receipt getReceipt() {
		return receipt;
	}
	/**
	 * @param receipt the receipt to set
	 */
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + ((receiptNotes == null) ? 0 : receiptNotes.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notes other = (Notes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (receiptNotes == null) {
			if (other.receiptNotes != null)
				return false;
		} else if (!receiptNotes.equals(other.receiptNotes))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Notes [id=" + id + ", receipt=" + receipt + ", receiptNotes=" + receiptNotes + "]";
	}
	
	
	
	
}
