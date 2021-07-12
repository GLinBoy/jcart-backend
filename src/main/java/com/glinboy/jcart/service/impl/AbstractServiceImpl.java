package com.glinboy.jcart.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.BaseEntity;
import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.service.GenericService;
import com.glinboy.jcart.service.dto.BaseDTO;
import com.glinboy.jcart.service.mapper.EntityMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public abstract class AbstractServiceImpl<T extends BaseDTO, E extends BaseEntity,
	M extends EntityMapper<T, E>, S extends JpaRepository<E, Long>>
		implements GenericService<T> {

	protected final S repository;
	
	protected final M mapper;

	@Override
	@Transactional
	public T save(T t) {
		E e = this.mapper.toEntity(t);
		e = repository.save(e);
		return this.mapper.toDto(e);
	}

	@Override
	@Transactional
	@Deprecated
	public T update(T t) {
		return this.save(t);
	}

	@Override
	public T getSingleById(Long id) {
		return this.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found id = " + id));
	}
	
	@Override
	public Optional<T> findById(Long id) {
		return this.repository.findById(id).map(mapper::toDto);
	}

	@Override
	public Page<T> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Page<T> findAll() {
		// TODO apply search
		return null;
	}

	@Override
	@Transactional
	public void deleteSingleById(Long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found id = " + id));
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteSingleByReference(T t) {
		repository.findById(t.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with id = " + t.getId()));
		repository.delete(t);
	}

	@Override
	@Transactional
	public void deleteAll() {
		repository.deleteAll();
	}
}
