package com.quadrosepaineisapi.model.release;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.quadrosepaineisapi.model.Product;

import lombok.Data;

@Data
@Entity(name = "financial_release")
public class FinancialRelease {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String description;
	
	private String obs;
	
	@NotNull
	private BigDecimal value;
	
	@Column(name = "due_date")
	private LocalDate dueDate;
	
	@Column(name = "register_date")
	private LocalDate registerDate;
	
	@Column(name = "pay_date")
	private LocalDate payDate;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private FinancialReleaseType type;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "id_category")
	private FinancialReleaseCategory category;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;
}
