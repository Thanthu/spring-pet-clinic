package com.thanthu.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.Vet;
import com.thanthu.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

}
