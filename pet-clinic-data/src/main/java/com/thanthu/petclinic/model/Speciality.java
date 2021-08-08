package com.thanthu.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sepcialities")
public class Speciality extends BaseEntity {
	
	private String description;

	@Builder
	public Speciality(Long id, String description) {
		super(id);
		this.description = description;
	}

	
}
