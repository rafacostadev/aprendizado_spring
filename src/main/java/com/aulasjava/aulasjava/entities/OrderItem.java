package com.aulasjava.aulasjava.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem {
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	private Integer quantity;
	private Double price;

	public OrderItem(Product product, Order order, Integer quantity, Double price) {
		this.id.setProduct(product);
		this.id.setOrder(order);
		this.quantity = quantity;
		this.price = price;
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}
}
