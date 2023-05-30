package com.smartcampus.repositories;

import java.util.List;


import com.smartcampus.models.Asignar;



public interface IAsignarRepository extends IEntityRepository<Asignar, Long> {
	public List<Asignar> showByIdFunc(Long id);	
	public List<Asignar> showByIdRequ(Long id);	
	public List<Asignar> showByIdFuncHistory(Long idHist);	
	public void update (Asignar id, String requeEstado);


	
}
