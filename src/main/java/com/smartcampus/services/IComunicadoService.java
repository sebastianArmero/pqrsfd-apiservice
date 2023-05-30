package com.smartcampus.services;


import java.util.List;

import com.smartcampus.models.Comunicado;



public interface IComunicadoService extends IEntityService<Comunicado, Long> {
	public List<Comunicado> showByIdRequ(Long id);
}
