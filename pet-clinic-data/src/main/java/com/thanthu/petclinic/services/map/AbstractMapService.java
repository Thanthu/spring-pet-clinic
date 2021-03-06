package com.thanthu.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.thanthu.petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<Long, T>();

	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	public T findById(ID id) {
		return map.get(id);
	}

	public T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object cannot be null");
		}
		return object;
	}

	public void deleteById(ID id) {
		map.remove(id);
	}

	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	private Long getNextId() {
		try {
			return Collections.max(map.keySet()) + 1;
		} catch (NoSuchElementException e) {
			return 1L;
		}
	}

}
