package com.smartcampus.repositories;


import java.time.LocalDate;
import java.util.List;

import com.smartcampus.models.PqrsfdRec;

public interface IPqrsfdRecRepository extends IEntityRepository<PqrsfdRec, Long> {
	
	public List<PqrsfdRec> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal);
		
}
