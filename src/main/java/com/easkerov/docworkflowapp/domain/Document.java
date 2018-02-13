package com.easkerov.docworkflowapp.domain;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "DOCUMENTS")
public class Document {
	
	@Id
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_ID")
	private Integer id;
	
	@Column(name = "DOC_DATE")
	private Date date;
	
	@Column(name = "DOC_AMOUNT")
	private BigDecimal 	amount;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Document{" +
				"id=" + id +
				", date=" + date +
				", amount=" + amount +
				'}';
	}
}
