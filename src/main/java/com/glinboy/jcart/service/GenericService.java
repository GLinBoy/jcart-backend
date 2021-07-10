package com.glinboy.jcart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.service.dto.BaseDTO;

public interface GenericService<T extends BaseDTO> {
	T save(T t);

	T update(T t);

	T getSingleById(Long id);

	Page<T> getAll(Pageable pageable);

	Page<T> findAll();

	void deleteSingleById(Long id);

	void deleteSingleByReference(T t);

	void deleteAll();
}
