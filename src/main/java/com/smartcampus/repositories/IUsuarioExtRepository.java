package com.smartcampus.repositories;

import java.util.List;

import com.smartcampus.models.CrearUserExtDTO;
import com.smartcampus.models.UsuarioExt;

public interface IUsuarioExtRepository extends IEntityRepository<UsuarioExt, Long> {

	public UsuarioExt findByLogin(String username);
	
	public UsuarioExt findByLoginAndPassword(String username, String password);
	
	public UsuarioExt findByIdentificacion(String identificacion);
	
	public void createUserExt(CrearUserExtDTO crearusuarioext);

	public boolean validateByIdentificacion(String identificacion);

	public boolean validateByIdentificacionUserExt(int identificacion);

	
}
