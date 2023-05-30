package com.smartcampus.repositories;


import java.time.LocalDate;
import java.util.List;

import com.smartcampus.models.PqrsfdCan;


public interface IPqrsfdCanRepository extends IEntityRepository<PqrsfdCan, Long> {
	
	public List<PqrsfdCan> showByAnioshowByAnio(LocalDate fechaInicio, LocalDate fechaFinal);
		
}
