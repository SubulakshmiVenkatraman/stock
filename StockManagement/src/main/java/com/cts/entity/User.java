package com.cts.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

@Entity
@Table(name = "User",uniqueConstraints = {
@UniqueConstraint(columnNames = "id")})
@DynamicUpdate
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "username", length = 50)
	String username;
	
	@Column(name = "password", length = 50)
	String password;
	
	@Column(name = "userType", length = 50)
	String userType;

	@Column(name = "e_Mail", length = 80)
	String e_Mail;
	@NotEmpty

	@Column(name = "mobileNumber", length = 50)
	String mobileNumber;

	@Column(name = "confirmed", length = 20)
	String confirmed;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password, String userType, String e_Mail, String mobileNumber,
			String confirmed) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.e_Mail = e_Mail;
		this.mobileNumber = mobileNumber;
		this.confirmed = confirmed;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getE_Mail() {
		return e_Mail;
	}

	public void setE_Mail(String e_Mail) {
		this.e_Mail = e_Mail;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ ", e_Mail=" + e_Mail + ", mobileNumber=" + mobileNumber + ", confirmed=" + confirmed + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
