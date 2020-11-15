package com.bourg.receiptweb.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.bourg.receiptweb.enums.Approval;

/**
 * @author bourgamb
 *
 */
@Entity
public class Receipt {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String type;
	private BigDecimal totalAmount;
	private String currency;
	private String url;
	
	@Lob
	private Byte[] image;
	
	@Enumerated(value = EnumType.STRING)
	private Approval approval;
	
	@OneToOne(cascade= CascadeType.ALL)
	private Notes notes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="receipt")
	private Set<ReceiptEntry> receiptEntry;

	@ManyToMany
	private Set<Category> category;
	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the image
	 */
	public Byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Byte[] image) {
		this.image = image;
	}

	/**
	 * @return the notes
	 */
	public Notes getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	/**
	 * @return the approval
	 */
	public Approval getApproval() {
		return approval;
	}

	/**
	 * @param approval the approval to set
	 */
	public void setApproval(Approval approval) {
		this.approval = approval;
	}

	/**
	 * @return the receiptEntry
	 */
	public Set<ReceiptEntry> getReceiptEntry() {
		return receiptEntry;
	}

	/**
	 * @param receiptEntry the receiptEntry to set
	 */
	public void setReceiptEntry(Set<ReceiptEntry> receiptEntry) {
		this.receiptEntry = receiptEntry;
	}

	/**
	 * @return the category
	 */
	public Set<Category> getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Set<Category> category) {
		this.category = category;
	}


	
	
	
	
	
}
