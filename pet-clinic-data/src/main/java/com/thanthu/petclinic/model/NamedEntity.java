package com.thanthu.petclinic.model;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class NamedEntity extends BaseEntity {

	private String name;

	public NamedEntity(Long id, String name) {
		super(id);
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
