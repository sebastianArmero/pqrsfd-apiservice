package com.smartcampus.services;

import java.time.LocalDate;
import java.util.List;


import com.smartcampus.models.PqrsfdEst;





public interface IPqrsfdEstService extends IEntityService<PqrsfdEst, Long> {
	public List<PqrsfdEst> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal);
}
