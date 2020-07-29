package com.projct.car.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", nullable = false)
	@NotNull(message = "Id can not be null")
	private int id;

	@Column(name = "customer_name")
	@NotNull(message = "Name can not be null")
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
	private String userName;

	@Column(name = "customer_password")
	@NotNull(message = "Password can not be null")
	@Length(min = 8, max = 12)
	private String password;

	@Email
	@Column(name = "customer_email")
	@NotNull(message = "Email can not be null")
	private String email;

	public Customer(
			@NotNull(message = "Name can not be null") @NotEmpty(message = "Name may not be empty") @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") String userName,
			@NotNull(message = "Password can not be null") @Length(min = 8, max = 12) String password,
			@Email @NotNull(message = "Email can not be null") String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}

}
