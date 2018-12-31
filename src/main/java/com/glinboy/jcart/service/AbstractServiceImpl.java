package com.glinboy.jcart.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.BaseEntity;
import com.glinboy.jcart.model.ResourceNotFoundException;

@Service
public abstract class AbstractServiceImpl<T extends BaseEntity, S extends JpaRepository<T, Long>>
        implements GenericService<T> {

    @Autowired
    protected S repository;

    @Override
    @Transactional
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    @Transactional
    public T update(T t) {
        final Long id = t.getId();
        t = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Resource not found with id = " + id));
        // FIXME Handle update;
        return repository.save(t);
    }

    @Override
    public T getSingleById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Resource not found id = " + id));
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
        repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Resource not found id = " + id));
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteSingleByReference(T t) {
        repository.findById(t.getId()).orElseThrow(() ->
                new ResourceNotFoundException ("Resource not found with id = " + t.getId()));
        repository.delete(t);
    }

    @Override
    @Transactional
    public void deleteAll() {
        repository.deleteAll();
    }
}
