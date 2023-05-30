package com.smartcampus.services;

import java.time.LocalDate;
import java.util.List;

import com.smartcampus.models.PqrsfdAsun;





public interface IPqrsfdAsunService extends IEntityService<PqrsfdAsun, Long> {
	public List<PqrsfdAsun> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal);
}
