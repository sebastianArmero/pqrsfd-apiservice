package com.smartcampus.services;

import java.util.List;

import com.smartcampus.models.Asignar;



public interface IAsignarService extends IEntityService<Asignar, Long> {
	public List<Asignar> showByIdFunc(Long id);
	public List<Asignar> showByIdRequ(Long id);	
	public List<Asignar> showByIdFuncHistory(Long idHist);	
	public void update (Asignar id, String requeEstado);
}
