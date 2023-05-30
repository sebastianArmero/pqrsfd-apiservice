package com.smartcampus.repositories;


import java.util.List;


import com.smartcampus.models.Trazabilidad;

public interface ITrazabilidadRepository extends IEntityRepository<Trazabilidad, Long> {
	public List<Trazabilidad> showByIdRequ(Long id);	
}
