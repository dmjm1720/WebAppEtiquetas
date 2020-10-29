package com.etiquetas.qrsys.bean;

import com.etiquetas.qrsys.dao.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidasReg extends Conexion {

    public List<String> listarPartidas(String cvedoc) {
        List<String> lista = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = this.getCn().prepareCall("SELECT dbo.PAR_COMPC01.CVE_ART, dbo.PAR_COMPC01.REG_SERIE, dbo.LTPD01.PEDIMENTO\n"
                    + "FROM dbo.LTPD01 INNER JOIN dbo.ENLACE_LTPD01 ON dbo.LTPD01.REG_LTPD = dbo.ENLACE_LTPD01.REG_LTPD INNER JOIN\n"
                    + "dbo.PAR_COMPC01 ON dbo.ENLACE_LTPD01.E_LTPD = dbo.PAR_COMPC01.E_LTPD WHERE  dbo.PAR_COMPC01.CVE_DOC='" + cvedoc + "'");
            //PreparedStatement ps = this.getCn().prepareCall("SELECT CVE_ART, CANT, REG_SERIE, ENLACE_LTPD01 FROM PAR_COMPC01 WHERE CVE_DOC='" + cvedoc + "'");
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                String par;
                par = rs.getString("CVE_ART");
                lista.add(par);
                par = rs.getString("REG_SERIE");
                lista.add(par);
                par = rs.getString("PEDIMENTO");
                lista.add(par);
            }
            this.Cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<String> listarXSerie(String cvedoc, String art, String pedimento) {
        List<String> lista = null;
        ResultSet rs;
        try {
            this.ConectarQr();
            PreparedStatement ps = this.getCnqr().prepareCall("SELECT dbo.SERIE.SERIE FROM dbo.FACTURA INNER JOIN "
                    + "dbo.SERIE ON dbo.FACTURA.IDFACTURA = dbo.SERIE.IDFACTURA "
                    + "WHERE dbo.FACTURA.CVEDOC='" + cvedoc + "' AND dbo.SERIE.PEDIMENTO='" + pedimento + "' AND dbo.SERIE.ARTICULO='" + art + "'");
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                String par;
                par = rs.getString("SERIE");
                lista.add(par);
            }
            this.CerrarQr();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
