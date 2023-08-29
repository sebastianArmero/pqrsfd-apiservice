package com.smartcampus.repositories;

import java.util.List;

import com.smartcampus.models.Requerimiento;



public interface IRequerimientoRepository extends IEntityRepository<Requerimiento, Long> {
	public List<Requerimiento> showByIdentificacionAll(Long identificacion);
	public List<Requerimiento> showByIdentificacionHistory(Long identificacion);	
	public List<Requerimiento> showByIdRequ(Long id);	
	public List<Requerimiento> showAllHist();
	public List<Requerimiento> showAllAnonimo();
	public List<Requerimiento> showAllAnonimoHist();

	public String createRequ(Requerimiento r);
	public void updateEstado(Long id, Requerimiento r);


	
}
