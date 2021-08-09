package com.thanthu.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.thanthu.petclinic.model.Owner;

class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	final Long OWNER_ID = 1L;
	final String LAST_NAME = "Bee";

	@BeforeEach
	void setUp() throws Exception {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build());
	}

	@Test
	void testSaveWithId() {
		Long id = 2L;
		assertEquals(id, ownerServiceMap.save(Owner.builder().id(id).build()).getId());
	}

	@Test
	void testSaveWithoutId() {
		assertNotNull(ownerServiceMap.save(Owner.builder().build()).getId());
	}

	@Test
	void testFindByLastName() {
		assertEquals(LAST_NAME, ownerServiceMap.findByLastName(LAST_NAME).getLastName());
	}

	@Test
	void testFindByLastNameNotFound() {
		assertNull(ownerServiceMap.findByLastName("Foo"));
	}

	@Test
	void testFindAll() {
		assertEquals(1, ownerServiceMap.findAll().size());
	}

	@Test
	void testFindById() {
		assertEquals(OWNER_ID, ownerServiceMap.findById(OWNER_ID).getId());
	}

	@Test
	void testDeleteById() {
		ownerServiceMap.deleteById(OWNER_ID);
		assertNull(ownerServiceMap.findById(OWNER_ID));
	}

	@Test
	void testDelete() {
		ownerServiceMap.delete(ownerServiceMap.findById(OWNER_ID));
		assertNull(ownerServiceMap.findById(OWNER_ID));
	}

}
