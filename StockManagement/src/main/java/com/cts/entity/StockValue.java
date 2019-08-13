package com.cts.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "StockValue")
@DynamicUpdate
public class StockValue {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "companyId", length = 50)
	String companyId;
	@NotEmpty

	@Column(name = "stockExchange", length = 50)
	String stockExchange;
	@NotEmpty

	@Column(name = "currentPrice", length = 50)
	Double currentPrice;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Past
	@Column(name = "date", length = 80)
	Date date;
	@NotEmpty

	@Column(name = "time", length = 50)
	Time time;

	private StockExchange stock_exchange;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "stockExchange")
	public StockExchange getStock_exchange() {
		return stock_exchange;
	}

	public void setStock_exchange(StockExchange stock_exchange) {
		this.stock_exchange = stock_exchange;
	}

	public StockValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
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

	public StockValue(int id, String companyId, String stockExchange, Double currentPrice, Date date, Time time) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockValue [id=" + id + ", companyId=" + companyId + ", stockExchange=" + stockExchange
				+ ", currentPrice=" + currentPrice + ", date=" + date + ", time=" + time + "]";
	}

}