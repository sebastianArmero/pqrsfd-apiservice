package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Asignar;
import com.smartcampus.models.TipoTipologia;


public class AsignarRowMapper implements RowMapper<Asignar> {

	@Override
	public Asignar mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		// stpq_pegeid_funcionario, stpq_tipo_estado_id, stpq_estado, stpq_pqrsdf_id
		return Asignar.builder().asigId(rs.getInt("asig_id"))
				.idUsuario(rs.getInt("id_usuario"))
				.requId(rs.getInt("requ_id"))
				.funcNombre(rs.getString("func_nombre"))
				.funcEmail(rs.getString("func_email"))
				.asigCreadoPor(rs.getString("asig_creadopor"))
				.asigFechaCreado(rs.getDate("asig_fechacreado"))
				.asigFechaModifica(rs.getDate("asig_fechamodifica"))
				.asigModificadoPor(rs.getString("asig_modificadopor"))
				.asigEstadoAsignacion(rs.getString("asig_estadoasignacion"))
				.asigObservacion(rs.getString("asig_observacion"))
				.asigEstado(rs.getBoolean("asig_estado"))				
				.ciudadId(rs.getInt("ciudad_id"))
				.ciudadNombre(rs.getString("ciudad_nombre"))
				.requRadicado(rs.getString("requ_radicado"))
				.requFecharadicado(rs.getDate("requ_fecharadicado"))
				.requFechaterminorespuesta(rs.getDate("requ_fechaterminorespuesta"))
				.requDescripcion(rs.getString("requ_descripcion"))
				.tireId(rs.getInt("tire_id"))
				.titiNombre(rs.getString("titi_nombre"))
				.requEstado(rs.getString("requ_estado"))
				.requNumDoc(rs.getInt("requ_numdoc"))
				.requPrimerNom(rs.getString("requ_primernom"))
				.requSeguNom(rs.getString("requ_segunom"))
				.requPrimerApe(rs.getString("requ_primerape"))
				.requSeguApe(rs.getString("requ_seguape"))
				.requDirec(rs.getString("requ_direc"))
				.requTel(rs.getString("requ_tel"))
				.requTelOp(rs.getString("requ_telop"))
				.requCorreo(rs.getString("requ_correo"))
				.requEmailop(rs.getString("requ_emailop"))
				.requUrl(rs.getString("requ_url"))
				.reclasiTireId(rs.getInt("reclasi_tire_id"))
				.nombrereclasi(rs.getString("nombrereclasi"))
				.build();

	}

}
