package com.smartcampus.services;

import com.smartcampus.models.CrearUserExtDTO;
import com.smartcampus.models.UsuarioExt;
import com.smartcampus.dto.SimpleObjectResponse;

public interface ILoginUserExtService extends IEntityService<UsuarioExt, Long> {

	SimpleObjectResponse authenticateUser(String usuario, String clave);



	SimpleObjectResponse authenticateUserRemember(String usuario, String clave, boolean rememberSession);

	SimpleObjectResponse olvideclave(String usuario);

	SimpleObjectResponse validateUser(String usuario);

	SimpleObjectResponse validateIdentificacion(String identificacion);

	SimpleObjectResponse authenticateToken(String token);

	SimpleObjectResponse refreshTokenUser(String usuario, String token, boolean rememberSession);
	
	public void create(CrearUserExtDTO userDto);

}
