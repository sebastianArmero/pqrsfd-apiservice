package com.smartcampus.services;

import java.time.LocalDate;
import java.util.List;

import com.smartcampus.models.PqrsfdRec;



public interface IPqrsfdRecService extends IEntityService<PqrsfdRec, Long> {
	public List<PqrsfdRec> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal);
}
