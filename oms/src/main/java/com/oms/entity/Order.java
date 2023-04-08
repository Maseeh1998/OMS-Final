package com.oms.entity;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Order {
	@NotNull
	@NotBlank
	private String item;
	@NotNull
	private float price;
	@Id
	private String id;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		if(price<0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
