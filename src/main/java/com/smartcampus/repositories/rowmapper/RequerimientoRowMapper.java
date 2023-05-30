package com.smartcampus.repositories.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartcampus.models.Requerimiento;
import com.smartcampus.models.TipoTipologia;


public class RequerimientoRowMapper implements RowMapper<Requerimiento> {

	@Override
	public Requerimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		// stpq_pegeid_funcionario, stpq_tipo_estado_id, stpq_estado, stpq_pqrsdf_id
		return Requerimiento.builder().requId(rs.getInt("requ_id"))
				.asunId(rs.getInt("asun_id"))
				.ciudadId(rs.getInt("ciudad_id"))
				.ciudadNombre(rs.getString("ciudad_nombre"))
				.tireId(rs.getInt("tire_id"))
				.pegeId(rs.getInt("pege_id"))
				.titiNombre(rs.getString("titi_nombre"))
				.titiVencimiento(rs.getInt("titi_vencimiento"))
				.mediId(rs.getInt("medi_id"))
				.mediNombre(rs.getString("medi_nombre"))
				.requOtraciudad(rs.getString("requ_otraciudad"))
				.requRadicado(rs.getString("requ_radicado"))
				.requDescripcion(rs.getString("requ_descripcion"))
				.requFechaterminorespuesta(rs.getDate("requ_fechaterminorespuesta"))
				.requFechacambio(rs.getDate("requ_fechacambio"))
				.requRegistradopor(rs.getString("requ_registradopor"))
				.requProcesoauditoria(rs.getString("requ_procesoauditoria"))
				.requEstado(rs.getString("requ_estado"))
				.requFecharadicado(rs.getDate("requ_fecharadicado"))
				.unidIdterritorial(rs.getInt("unid_idterritorial"))
				.procId(rs.getInt("proc_id"))
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
				.requConsecutivoId(rs.getString("requ_consecutivo_id"))
				.reclasiTireId(rs.getInt("reclasi_tire_id"))
				.nombrereclasi(rs.getString("nombrereclasi"))
				
				.build();

	}

}
