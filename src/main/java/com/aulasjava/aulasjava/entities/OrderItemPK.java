package com.aulasjava.aulasjava.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class OrderItemPK {
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
}
