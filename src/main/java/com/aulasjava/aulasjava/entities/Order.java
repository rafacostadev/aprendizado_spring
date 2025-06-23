package com.aulasjava.aulasjava.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "tb_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	private OrderStatus status;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();

	public Set<OrderItem> getItems() {
		return items;
	}

	public List<Product> getProducts() {
		return items.stream().map(x -> x.getProduct()).toList();
	}
}
