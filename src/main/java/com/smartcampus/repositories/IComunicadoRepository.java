package com.smartcampus.repositories;


import java.util.List;

import com.smartcampus.models.Comunicado;

public interface IComunicadoRepository extends IEntityRepository<Comunicado, Long> {
	public List<Comunicado> showByIdRequ(Long id);	
}
