package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.RolExt;
import com.smartcampus.models.UsuarioExt;

public class UsuarioExtRowMapper implements RowMapper<UsuarioExt> {

	@Override
	public UsuarioExt mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		RolExt rol = new RolExt();
	    List<RolExt> roles = new ArrayList<RolExt>();
		
		rol.setVRolId(508);
		rol.setVRolNombre("Usuario Externo");
		rol.setVRolDescripcion("Usuario externo para la aplicacion PQRSDF");
		rol.setVRolTipo("PQRSDF_EXTERNO");
		rol.setVRolEstado("1");
		rol.setVRolPublico("0");
		roles.add(rol);
	
		return UsuarioExt.builder().idUsuario(rs.getInt("id_usuario")).login(rs.getString("login"))
				.password(rs.getString("password_new")).identificacion(rs.getString("identificacion"))
				.correoElectronico(rs.getString("correo_electronico")).pegeId(rs.getInt("pege_id"))
				.estado(rs.getString("estado")).tokenAcces(rs.getString("token_acces_new"))
				.usuafechacambio(rs.getString("usua_fechacambio")).documentoTipo(rs.getString("documento_tipo"))
				.primerNombre(rs.getString("primernombre")).segundoNombre(rs.getString("segundonombre"))
				.primerApellido(rs.getString("primerapellido")).segundoApellido(rs.getString("segundoapellido"))
				.telefono(rs.getString("telefono")).direccion(rs.getString("direccion")).ciudad(rs.getInt("ciudad"))
				.correoOpcional(rs.getString("correo_electronico_adicional")).celular(rs.getString("celular"))
				.roles(roles).build();

	}

}
