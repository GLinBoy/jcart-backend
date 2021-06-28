package com.glinboy.jcart.service.mapper;

import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.glinboy.jcart.model.BaseEntity;
import com.glinboy.jcart.service.dto.BaseDTO;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */

public interface EntityMapper<D extends BaseDTO, E extends BaseEntity> {
	E toEntity(D dto);

	D toDto(E entity);

	List<E> toEntity(List<D> dtoList);

	List<D> toDto(List<E> entityList);

	@Named("partialUpdate")
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void partialUpdate(@MappingTarget E entity, D dto);
}
