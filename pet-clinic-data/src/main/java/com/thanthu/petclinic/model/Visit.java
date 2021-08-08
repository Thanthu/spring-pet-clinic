package com.thanthu.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

	private LocalDate date;
	private String description;

	@ManyToOne
	private Pet pet;

	@Builder
	public Visit(Long id, LocalDate date, String description, Pet pet) {
		super(id);
		this.date = date;
		this.description = description;
		this.pet = pet;
	}

}
