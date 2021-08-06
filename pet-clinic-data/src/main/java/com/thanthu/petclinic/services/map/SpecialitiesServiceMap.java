package com.thanthu.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.thanthu.petclinic.model.Speciality;
import com.thanthu.petclinic.services.SpecialitiesService;

@Service
public class SpecialitiesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService {

}
