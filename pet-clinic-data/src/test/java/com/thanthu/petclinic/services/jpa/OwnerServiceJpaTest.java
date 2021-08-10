package com.thanthu.petclinic.services.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thanthu.petclinic.model.Owner;
import com.thanthu.petclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

	@Mock
	OwnerRepository ownerRepository;

	@InjectMocks
	OwnerServiceJpa ownerServiceJpa;

	final String LAST_NAME = "Bee";
	final Long OWNER_ID = 1L;
	Owner returnedOwner;

	@BeforeEach
	void setUp() throws Exception {
		returnedOwner = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindAll() {
		Set<Owner> returnedOwnerSet = new HashSet<Owner>();
		Owner owner2 = Owner.builder().id(2L).build();
		returnedOwnerSet.add(returnedOwner);
		returnedOwnerSet.add(owner2);

		when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);

		assertEquals(2, ownerServiceJpa.findAll().size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(OWNER_ID)).thenReturn(Optional.of(returnedOwner));
		assertEquals(OWNER_ID, ownerServiceJpa.findById(OWNER_ID).getId());
	}

	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		assertNull(ownerServiceJpa.findById(anyLong()));
	}

	@Test
	void testSave() {
		when(ownerRepository.save(returnedOwner)).thenReturn(returnedOwner);
		assertEquals(OWNER_ID, ownerServiceJpa.save(returnedOwner).getId());
	}

	@Test
	void testDelete() {
		ownerServiceJpa.delete(returnedOwner);
		verify(ownerRepository, times(1)).delete(returnedOwner);
	}

	@Test
	void testDeleteById() {
		ownerServiceJpa.deleteById(OWNER_ID);
		verify(ownerRepository, times(1)).deleteById(OWNER_ID);
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnedOwner);
		assertEquals(LAST_NAME, ownerServiceJpa.findByLastName("Bee").getLastName());
	}

}
