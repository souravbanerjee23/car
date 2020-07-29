package com.projct.car.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "car_id", nullable = false)
	@NotNull(message = "Id can not be null")
	private int id;

	@Column(name = "car_name")
	@NotNull(message = "Name can not be null")
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
	private String name;

	@Column(name = "car_seat")
	@NotNull(message = "Seat can not be null")
	private int seat;

	@Column(name = "availability")
	@NotNull
	private String availability;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Car(@NotNull(message = "Id can not be null") int id,
			@NotNull(message = "Name can not be null") @NotEmpty(message = "Name may not be empty") @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") String name,
			@NotNull(message = "Seat can not be null") int seat, @NotNull String availability) {
		super();
		this.id = id;
		this.name = name;
		this.seat = seat;
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", seat=" + seat + ", availability=" + availability + "]";
	}

	public Car() {
		super();
	}
	

}