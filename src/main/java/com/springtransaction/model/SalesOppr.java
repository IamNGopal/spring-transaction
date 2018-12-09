package com.springtransaction.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the _sales_oppr database table.
 * 
 */
@Entity
@Table(name="sales_oppr")
@NamedQuery(name="SalesOppr.findAll", query="SELECT a FROM SalesOppr a")
public class SalesOppr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oppr_id", unique=true, nullable=false)
	private int opprId;

	@Column(name="oppr_contact_id", nullable=false)
	private int opprContactId;

	@Column(name="oppr_customer_id", nullable=false)
	private int opprCustomerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="oppr_date")
	private Date opprDate;

	@Column(name="oppr_desc")
	private String opprDesc;

	@Column(name="oppr_no")
	private int opprNo;

	@Column(name="oppr_title", length=255)
	private String opprTitle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private Customer Customer;
	
	@Transient
	private String customerName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
	private CustomerContact CustomerContact;
	
	@Transient
	private String contactFname;
	
	@Transient
	private String contactLname;
	
	public SalesOppr() {
	}

	public int getOpprId() {
		return this.opprId;
	}

	public void setOpprId(int opprId) {
		this.opprId = opprId;
	}

	public int getOpprContactId() {
		return this.opprContactId;
	}

	public void setOpprContactId(int opprContactId) {
		this.opprContactId = opprContactId;
	}

	public int getOpprCustomerId() {
		return this.opprCustomerId;
	}

	public void setOpprCustomerId(int opprCustomerId) {
		this.opprCustomerId = opprCustomerId;
	}

	public Date getOpprDate() {
		return this.opprDate;
	}

	public void setOpprDate(Date opprDate) {
		this.opprDate = opprDate;
	}

	public String getOpprDesc() {
		return this.opprDesc;
	}

	public void setOpprDesc(String opprDesc) {
		this.opprDesc = opprDesc;
	}

	public int getOpprNo() {
		return this.opprNo;
	}

	public void setOpprNo(int opprNo) {
		this.opprNo = opprNo;
	}

	public String getOpprTitle() {
		return this.opprTitle;
	}

	public void setOpprTitle(String opprTitle) {
		this.opprTitle = opprTitle;
	}

	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer Customer) {
		this.Customer = Customer;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public CustomerContact getCustomerContact() {
		return CustomerContact;
	}

	public void setCustomerContact(CustomerContact CustomerContact) {
		this.CustomerContact = CustomerContact;
	}

	public String getContactFname() {
		return contactFname;
	}

	public void setContactFname(String contactFname) {
		this.contactFname = contactFname;
	}

	public String getContactLname() {
		return contactLname;
	}

	public void setContactLname(String contactLname) {
		this.contactLname = contactLname;
	}

}