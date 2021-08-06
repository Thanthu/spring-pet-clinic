package com.thanthu.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.Owner;
import com.thanthu.petclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
