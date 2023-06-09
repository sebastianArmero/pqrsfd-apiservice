package com.smartcampus.repositories;

import com.smartcampus.models.EstadoPqrsdf;

public interface IEstadoPqrsdfRepository extends IEntityRepository<EstadoPqrsdf, Long> {

	public EstadoPqrsdf showAllByIdPqrsdf(Long id);
	
	public EstadoPqrsdf findByIdPqrsdf(Integer id);
	
}
