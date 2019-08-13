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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Company")
public class Company {

	// @OneToOne(cascade=CascadeType.ALL)
//    @JoinTable(name="IPO", joinColumns={@JoinColumn(name="companyName")})
	@Column(name = "companyName")
	String companyName;
	@Column(name = "turnover")
	Double turnover;
	@Column(name = "ceo")
	String ceo;
	@Column(name = "boardOfDirectors")
	String boardOfDirectors;

	@Column(name = "listedInStockExchange")
	String listedInStockExchange;

	@Column(name = "sectors")
	String sectors;

	@Column(name = "briefWriteUp")
	String briefWriteup;
	@GeneratedValue
	@Id
	@Column(name = "stockCode")
	int stockCode;

	private IPOsPlanned iposPlanned;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "companyName")
	public IPOsPlanned getIpoDetails() {
		return iposPlanned;
	}

	public void setIpoDetails(IPOsPlanned iposPlanned) {
		this.iposPlanned = iposPlanned;
	}
	
	private StockExchange stockExchange;
	
	@ManyToOne
	@JoinColumn(name="listedInStockExchange")

	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(int i) {
		this.turnover = (double) i;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getListedInStockExchange() {
		return listedInStockExchange;
	}

	public void setListedInStockExchange(String listedInStockExchange) {
		this.listedInStockExchange = listedInStockExchange;
	}

	public String getSectors() {
		return sectors;
	}

	public void setSectors(String sectors) {
		this.sectors = sectors;
	}

	public String getBriefWriteup() {
		return briefWriteup;
	}

	public void setBriefWriteup(String briefWriteup) {
		this.briefWriteup = briefWriteup;
	}

	public int getStockCode() {
		return stockCode;
	}

	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}

	public Company(String companyName, Double turnover, String ceo, String boardOfDirectors,
			String listedInStockExchange, String sectors, String briefWriteup, int stockCode) {
		super();
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.listedInStockExchange = listedInStockExchange;
		this.sectors = sectors;
		this.briefWriteup = briefWriteup;
		this.stockCode = stockCode;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", turnover=" + turnover + ", ceo=" + ceo + ", boardOfDirectors="
				+ boardOfDirectors + ", listedInStockExchange=" + listedInStockExchange + ", sectors=" + sectors
				+ ", briefWriteup=" + briefWriteup + ", stockCode=" + stockCode + "]";
	}


}
