package com.smartcampus.repositories;


import java.time.LocalDate;
import java.util.List;

import com.smartcampus.models.PqrsfdAsun;




public interface IPqrsfdAsunRepository extends IEntityRepository<PqrsfdAsun, Long> {
	
	public List<PqrsfdAsun> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal);
		
}
