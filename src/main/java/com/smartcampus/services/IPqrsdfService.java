package com.smartcampus.services;

import java.util.List;

import com.smartcampus.models.PegeIdDTO;
import com.smartcampus.models.TermCond;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.models.Pqrsdf;

public interface IPqrsdfService extends IEntityService<Pqrsdf, Long> {

	public List<Pqrsdf> findByPegeId(PegeIdDTO pegeid);

	public List<Pqrsdf> findByIdentificacion(UserIdentificacionDTO identificacion);

	public TermCond findTermCondByIdentificacion(UserIdentificacionDTO userIdentificacionDTO);

	public void aceptarTermCond(UserIdentificacionDTO userIdentificacion);


}
