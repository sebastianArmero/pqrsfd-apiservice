package com.smartcampus.services;

import java.util.List;

import com.smartcampus.models.Adjunto;




public interface IAdjuntoService extends IEntityService<Adjunto, Long> {
	public void createAdjunto (List<Adjunto> adjunto);
	public List<Adjunto> showByIdRequ(Long id);	
	
}
