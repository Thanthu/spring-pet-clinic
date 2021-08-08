package com.thanthu.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "pet_types")
public class PetType extends NamedEntity {

	@Builder
	public PetType(Long id, String name) {
		super(id, name);
	}

}
