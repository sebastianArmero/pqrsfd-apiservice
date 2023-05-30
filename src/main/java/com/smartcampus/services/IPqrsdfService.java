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

	/*
	 * SimpleObjectResponse registrarUserExt(UsuarioExt usuarioExt);
	 * 
	 * SimpleObjectResponse authenticateUserRemember(String usuario, String clave,
	 * boolean rememberSession);
	 * 
	 * SimpleObjectResponse olvideclave(String usuario);
	 * 
	 * SimpleObjectResponse validateUser(String usuario);
	 * 
	 * SimpleObjectResponse validateIdentificacion(String identificacion);
	 * 
	 * SimpleObjectResponse authenticateToken(String token);
	 * 
	 * SimpleObjectResponse refreshTokenUser(String usuario, String token, boolean
	 * rememberSession);
	 */
}
