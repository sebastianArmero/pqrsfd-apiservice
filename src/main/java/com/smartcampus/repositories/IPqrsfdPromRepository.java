package com.smartcampus.repositories;


import java.time.LocalDate;
import java.util.List;

import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdProm;


public interface IPqrsfdPromRepository extends IEntityRepository<PqrsfdProm, Long> {
	
	public List<PqrsfdProm> showByAnios(LocalDate fechaInicio, LocalDate fechaFinal);
		
}
