package com.etiquetas.qrsys.jasper;

import com.etiquetas.qrsys.dao.Conexion;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class QrPreview extends Conexion {

    @SuppressWarnings("null")
    public void getReporte(String ruta, int estado) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        this.ConectarQr();
        Map parameter = new HashMap();
        parameter.put("estado", estado);
        try {
            File file = new File(ruta);
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.setDateHeader("Expires", 0);
            httpServletResponse.setContentType("application/PDF");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, this.getCnqr());
            @SuppressWarnings("UnusedAssignment")
            JRExporter jrExporter = null;
            jrExporter = new JRPdfExporter();
            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

            if (jrExporter != null) {
                try {
                    jrExporter.exportReport();
                } catch (JRException e) {
                }
            }

        } catch (JRException | IOException e) {
        } finally {
            if (this.getCnqr()!= null) {
                try {
                    this.CerrarQr();
                } catch (SQLException e) {
                }
            }
        }
    }
}
