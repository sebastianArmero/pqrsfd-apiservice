package com.smartcampus.services;

import java.time.LocalDate;
import java.util.List;

import com.smartcampus.models.PqrsfdCan;




public interface IPqrsfdCanService extends IEntityService<PqrsfdCan, Long> {
	public List<PqrsfdCan> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal);
}
