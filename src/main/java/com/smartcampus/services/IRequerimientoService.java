package com.smartcampus.services;

import java.util.List;


import com.smartcampus.models.Requerimiento;


public interface IRequerimientoService extends IEntityService<Requerimiento, Long> {
	
	public List<Requerimiento> showByIdentificacionAll(Long identificacion);
	public List<Requerimiento> showByIdentificacionHistory(Long identificacion);	
	
	public List<Requerimiento> showByIdRequ(Long id);
	public List<Requerimiento> showAllHist();
	
	public String createRequ(Requerimiento r);
	
	public List<Requerimiento> showAllAnonimo();
	
	public void updateEstado(Long id, Requerimiento r);
	
	
	
	


}
