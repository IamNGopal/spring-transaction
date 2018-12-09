package com.springtransaction.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the _customer_contact database table.
 * 
 */
@Entity
@Table(name="customer_contact")
@NamedQuery(name="CustomerContact.findAll", query="SELECT a FROM CustomerContact a")
public class CustomerContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contact_id", unique=true, nullable=false)
	private int contactId;

	@Column(name="contact_customer_id", nullable=false)
	private int contactCustomerId;

	@Column(name="contact_fname", nullable=false, length=255)
	private String contactFname;

	@Column(name="contact_lname", nullable=false, length=255)
	private String contactLname;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private Customer Customer;
	
	@OneToMany(mappedBy = "CustomerContact")
	private List<SalesOppr> SalesOppr;
	
	public CustomerContact() {
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public int getContactCustomerId() {
		return this.contactCustomerId;
	}

	public void setContactCustomerId(int contactCustomerId) {
		this.contactCustomerId = contactCustomerId;
	}

	public String getContactFname() {
		return this.contactFname;
	}

	public void setContactFname(String contactFname) {
		this.contactFname = contactFname;
	}

	public String getContactLname() {
		return this.contactLname;
	}

	public void setContactLname(String contactLname) {
		this.contactLname = contactLname;
	}

	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer Customer) {
		this.Customer = Customer;
	}

	public List<SalesOppr> getSalesOppr() {
		return SalesOppr;
	}

	public void setSalesOppr(List<SalesOppr> SalesOppr) {
		this.SalesOppr = SalesOppr;
	}

}