package com.ojulari.inventory.model;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "category")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "category_discription")
	private String categoryDescription; 
	
	@Column(name = "date")
	private LocalDate creationdate =  LocalDate.now();
	
	@OneToMany(mappedBy = "category")
	private List<Product> product;
	
}
