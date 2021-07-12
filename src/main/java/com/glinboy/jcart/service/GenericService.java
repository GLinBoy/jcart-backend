package com.glinboy.jcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.service.dto.BaseDTO;

public interface GenericService<T extends BaseDTO> {
	T save(T t);

	T update(T t);

	T getSingleById(Long id);

	Optional<T> findById(Long id);

	Page<T> getAll(Pageable pageable);

	List<T> findAll();

	void deleteSingleById(Long id);

	void deleteSingleByReference(T t);

	void deleteAll();
}
