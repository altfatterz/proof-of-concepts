package com.infohubble.learning;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * An order.
 */
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String customer;

    /**
     * JPA 2.0 unidirectional OneToMany relationship
     * @JoinColumn can be used on OneToMany to define a foreign key
     *
     * The main issue with an unidirectional OneToMany is that the
     * foreign key is owned by the target object's table, so if the target object has no
     * knowledge of this foreign key, inserting and updating the value is difficult.
     * In a unidirectional OneToMany the source object take ownership of the foreign key field,
     * and is responsible for updating its value.
     *
     */

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<Item> items = new ArrayList<Item>();

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

}
