package com.smartcampus.repositories;


import java.time.LocalDate;
import java.util.List;


import com.smartcampus.models.PqrsfdEst;



public interface IPqrsfdEstRepository extends IEntityRepository<PqrsfdEst, Long> {
	
	public List<PqrsfdEst> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal);
		
}
