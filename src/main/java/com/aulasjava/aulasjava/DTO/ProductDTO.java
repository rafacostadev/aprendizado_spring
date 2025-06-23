package com.aulasjava.aulasjava.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;

}
