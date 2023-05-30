package com.smartcampus.repositories;

import java.util.List;

import com.smartcampus.models.TipoTipologia;


public interface ITipoTipologiaRepository extends IEntityRepository<TipoTipologia, Long> {
	public List<TipoTipologia> showByIdTiti(Long id);	
	
}
