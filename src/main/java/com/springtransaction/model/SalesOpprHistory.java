package com.springtransaction.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the axela_sales_oppr_history database table.
 * 
 */
@Entity
@Table(name="sales_oppr_history")
@NamedQuery(name="SalesOpprHistory.findAll", query="SELECT a FROM SalesOpprHistory a")
public class SalesOpprHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="history_id", unique=true, nullable=false)
	private String historyId;

	@Column(name="history_actiontype", nullable=false, length=255)
	private String historyActiontype;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="history_datetime")
	private Date historyDatetime;

	@Lob
	@Column(name="history_newvalue")
	private String historyNewvalue;

	@Lob
	@Column(name="history_oldvalue")
	private String historyOldvalue;

	@Column(name="history_oppr_id", nullable=false)
	private BigInteger historyOpprId;

	public SalesOpprHistory() {
	}

	public String getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public String getHistoryActiontype() {
		return this.historyActiontype;
	}

	public void setHistoryActiontype(String historyActiontype) {
		this.historyActiontype = historyActiontype;
	}

	public Date getHistoryDatetime() {
		return this.historyDatetime;
	}

	public void setHistoryDatetime(Date historyDatetime) {
		this.historyDatetime = historyDatetime;
	}

	public String getHistoryNewvalue() {
		return this.historyNewvalue;
	}

	public void setHistoryNewvalue(String historyNewvalue) {
		this.historyNewvalue = historyNewvalue;
	}

	public String getHistoryOldvalue() {
		return this.historyOldvalue;
	}

	public void setHistoryOldvalue(String historyOldvalue) {
		this.historyOldvalue = historyOldvalue;
	}

	public BigInteger getHistoryOpprId() {
		return this.historyOpprId;
	}

	public void setHistoryOpprId(BigInteger historyOpprId) {
		this.historyOpprId = historyOpprId;
	}

}