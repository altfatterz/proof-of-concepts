package com.infohubble.learning;

import javax.persistence.*;

/**
 * An item in an order
 */
@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String product;

	private double price;

	private int quantity;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

}
