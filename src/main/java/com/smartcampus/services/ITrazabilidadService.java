package com.smartcampus.services;


import java.util.List;

import com.smartcampus.models.Trazabilidad;



public interface ITrazabilidadService extends IEntityService<Trazabilidad, Long> {
	public List<Trazabilidad> showByIdRequ(Long id);	
}
