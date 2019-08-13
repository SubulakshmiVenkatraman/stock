package com.cts.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "IPOsPlanned")
@DynamicUpdate
public class IPOsPlanned {

	@GeneratedValue
	@Id
	@Column(name = "id")
	int Id;


	@Column(name = "companyName")
	String companyName;

	@Column(name = "stockExchange")
	String stockExchange;
	@Column(name = "pricePerShare ")
	Double pricePerShare;
	@Column(name = "totalNumberOfShare")
	int totalNumberOfShare;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Past
	@Column(name = "date")
	Date date;
	@Column(name = "time")
	Time time;
	@Column(name = "remarks")
	String remarks;

	private Company company;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "companyName")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	private String stock_exchange;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "stockExchange")
	public String getStock_exchange() {
		return stock_exchange;
	}

	public void setStock_exchange(String string) {
		this.stock_exchange = string;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double i) {
		this.pricePerShare = i;
	}

	public int getTotalNumberOfShare() {
		return totalNumberOfShare;
	}

	public void setTotalNumberOfShare(int totalNumberOfShare) {
		this.totalNumberOfShare = totalNumberOfShare;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public IPOsPlanned(int id, String companyName, String stockExchange, Double pricePerShare, int totalNumberOfShare,
			Date date, Time time, String remarks) {
		super();
		Id = id;
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.totalNumberOfShare = totalNumberOfShare;
		this.date = date;
		this.time = time;
		this.remarks = remarks;
	}

	public IPOsPlanned() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IPOsDeatail [Id=" + Id + ", companyName=" + companyName + ", stockExchange=" + stockExchange
				+ ", pricePerShare=" + pricePerShare + ", totalNumberOfShare=" + totalNumberOfShare + ", date=" + date
				+ ", time=" + time + ", remarks=" + remarks + "]";
	}

}
