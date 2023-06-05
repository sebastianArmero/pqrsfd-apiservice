package com.smartcampus.repositories;

import com.smartcampus.models.TermCond;
import com.smartcampus.models.UserIdentificacionDTO;

public interface ITermCondRepository extends IEntityRepository<TermCond, Long> {
	
	public TermCond findTermCondByIdentificacion(String identificacion);
	
	public void createTermCond(UserIdentificacionDTO identificacion);
	
}
