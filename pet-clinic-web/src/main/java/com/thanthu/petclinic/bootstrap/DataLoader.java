package com.thanthu.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thanthu.petclinic.model.Owner;
import com.thanthu.petclinic.model.Pet;
import com.thanthu.petclinic.model.PetType;
import com.thanthu.petclinic.model.Speciality;
import com.thanthu.petclinic.model.Vet;
import com.thanthu.petclinic.services.OwnerService;
import com.thanthu.petclinic.services.PetTypeService;
import com.thanthu.petclinic.services.SpecialityService;
import com.thanthu.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {

		if (petTypeService.findAll().isEmpty())
			loadData();
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		dog = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		cat = petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		specialityService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		specialityService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");
		specialityService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setFirstName("Naruto");
		owner1.setLastName("Uzumaki");
		owner1.setAddress("123 House");
		owner1.setCity("Hidden Leaf");
		owner1.setTelephone("1234567890");

		Pet narutosPet = new Pet();
		narutosPet.setName("Kurama");
		narutosPet.setPetType(dog);
		narutosPet.setOwner(owner1);
		narutosPet.setBirthDate(LocalDate.of(2000, 1, 1));
		owner1.getPets().add(narutosPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Killer");
		owner2.setLastName("Bee");
		owner1.setAddress("234 House");
		owner1.setCity("Hidden Cloud");
		owner1.setTelephone("9876543210");

		Pet beesPet = new Pet();
		beesPet.setName("Eight Tails");
		beesPet.setPetType(cat);
		beesPet.setOwner(owner2);
		beesPet.setBirthDate(LocalDate.of(1970, 1, 1));
		owner2.getPets().add(beesPet);

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(radiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(surgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
