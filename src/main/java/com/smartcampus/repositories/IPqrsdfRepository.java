package com.smartcampus.repositories;

import java.util.List;

import com.smartcampus.models.PegeIdDTO;
import com.smartcampus.models.Pqrsdf;
import com.smartcampus.models.UserIdentificacionDTO;

public interface IPqrsdfRepository extends IEntityRepository<Pqrsdf, Long> {

	public Pqrsdf showAllByLogin(String username);
	
	public Pqrsdf findById(Integer id);
	
	public Long createPqrsdf(Pqrsdf r);
	
	public List<Pqrsdf> findByPegeId(PegeIdDTO pegeid);
	
	public List<Pqrsdf> findByIdentificacion(UserIdentificacionDTO identificacion);
	
	
	
}
