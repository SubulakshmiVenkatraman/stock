package com.cts.entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "StockExchange")
@DynamicUpdate
public class StockExchange {

	@GeneratedValue
	@Id
	@Column(name = "id", unique=true)
	int Id;

	@Column(name = "stockExchange")
	String stockExchange;
	
	@Column(name = "brief")
	String brief;
	@Column(name = "address")
	String address;
	@Column(name = "remarks")
	String remarks;
	
	private List <Company> company;
	
	@OneToMany(targetEntity=Company.class, mappedBy="stockExchange", 
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public StockExchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockExchange(int id, String stockExchange, String brief, String address, String remarks) {
		super();
		Id = id;
		this.stockExchange = stockExchange;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "StockExchange [Id=" + Id + ", stockExchange=" + stockExchange + ", brief=" + brief + ", address="
				+ address + ", remarks=" + remarks + "]";
	}

}