package com.smartcampus.services;

import java.util.List;

import com.smartcampus.dto.SimpleObjectResponse;
import com.smartcampus.models.UserIdentificacionDTO;
import com.smartcampus.models.UsuarioExt;

public interface IUsuarioExtService extends IEntityService<UsuarioExt, Long> {

	public UsuarioExt findByIdentificacion(UserIdentificacionDTO identificacion);

	SimpleObjectResponse validateByIdentificacion(UserIdentificacionDTO identificacion);

}
