package com.smartcampus.repositories;

import java.util.List;

import com.smartcampus.models.Adjunto;


public interface IAdjuntoRepository extends IEntityRepository<Adjunto, Long> {
	public List<Adjunto> showByIdRequ(Long id);	
}
