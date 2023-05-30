package com.smartcampus.repositories;

import java.util.List;

import com.smartcampus.models.DiasInhabiles;
import com.smartcampus.models.Requerimiento;



public interface IDiasInhabilesRepository extends IEntityRepository<DiasInhabiles, Long> {
		
	public List<DiasInhabiles> showByIdDiin(Long id);	
	
	public List<DiasInhabiles> showAllDiasInCons();
}
