package com.glinboy.jcart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.BaseEntity;
import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.service.GenericService;
import com.glinboy.jcart.service.dto.BaseDTO;
import com.glinboy.jcart.service.mapper.EntityMapper;

import jakarta.transaction.Transactional;
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
		return repository.findAll(pageable).map(mapper::toDto);
	}

	@Override
	public List<T> findAll() {
		return mapper.toDto(repository.findAll());
	}

	@Override
	@Transactional
	public void deleteSingleById(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteSingleByReference(T t) {
		this.deleteSingleById(t.getId());
	}

	@Override
	@Transactional
	public void deleteAll() {
		repository.deleteAll();
	}
}
