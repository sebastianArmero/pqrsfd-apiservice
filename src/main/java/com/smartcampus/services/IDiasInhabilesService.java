package com.smartcampus.services;


import java.util.List;
import com.smartcampus.models.DiasInhabiles;


public interface IDiasInhabilesService extends IEntityService<DiasInhabiles, Long> {

	public List<DiasInhabiles> showByIdDiin(Long id);	
	public void createDias (List<DiasInhabiles> diasInhabil);
	public List<DiasInhabiles> showAllDiasInCons();
	
}
