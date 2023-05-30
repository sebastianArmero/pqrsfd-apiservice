package com.smartcampus.services;

import java.time.LocalDate;
import java.util.List;

import com.smartcampus.models.PqrsfdCan;
import com.smartcampus.models.PqrsfdProm;




public interface IPqrsfdPromService extends IEntityService<PqrsfdProm, Long> {
	public List<PqrsfdProm> showByAnio(LocalDate fechaInicio, LocalDate fechaFinal);
}
