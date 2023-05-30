package com.smartcampus.services;

import java.util.List;

import com.smartcampus.models.TipoTipologia;

public interface ITipoTipologiaService extends IEntityService<TipoTipologia, Long> {
	public List<TipoTipologia> showByIdTiti(Long id);
}
