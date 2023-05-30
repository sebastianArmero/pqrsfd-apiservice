package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.smartcampus.models.Pqrsdf;

public class PqrsdfRowMapper implements RowMapper<Pqrsdf> {

	@Override
	public Pqrsdf mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Pqrsdf.builder().pqrsdfId(rs.getInt("pqrsdf_id")).pqrsDetalle(rs.getString("pqrs_detalle"))
				.pqrsdfFchradicado(rs.getDate("pqrsdf_fchradicado"))
				.pqrsdfReportareaId(rs.getInt("pqrsdf_reportarea_id"))
				.pqrsEstadoPqrsdfId(rs.getInt("pqrs_estado_pqrsdf_id"))
				.estadoNombre(rs.getString("esta_nombre"))
				.pqrsEstamsj(rs.getBoolean("pqrs_estamsj"))
				.pqrsFchmaxresp(rs.getTimestamp("pqrs_fchmaxresp"))
				.pqrsFchrespuesta(rs.getTimestamp("pqrs_fchrespuesta"))
				.pqrsPegeidreporta(rs.getInt("pqrs_pegeidreporta"))
				.pqrsReclasificacionId(rs.getInt("pqrs_reclasificacion_id"))
				.pqrsRespuesta(rs.getString("pqrs_respuesta"))
				.pqrsTipologiaId(rs.getInt("pqrs_tipologia_id"))
				.tipologiaNombre(rs.getString("tipo_nombre"))
				.pqrsTiporecepId(rs.getInt("pqrs_tiporecep_id"))
				.reclasificaNombre(rs.getString("nombre_reclasifica"))
				.pqrsPegeidUsuario(rs.getInt("pqrs_pegeid_usuario"))
				.pqrsIdentificacion(rs.getString("pqrs_identificacion"))
				.pqrsUsuarioExt(rs.getBoolean("pqrs_usuarioext"))
				.pqrsIdentificacion(rs.getString("pqrs_identificacion"))
				.build();
	}

}
