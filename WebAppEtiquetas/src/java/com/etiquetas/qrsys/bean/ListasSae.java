package com.etiquetas.qrsys.bean;

import com.etiquetas.qrsys.dao.Conexion;
import com.etiquetas.qrsys.e.model.Factura;
import com.etiquetas.qrsys.e.model.Series;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListasSae extends Conexion {

    //**LISTAR FACTURAS VENTAS**//
    public List<Factura> listarVentas(String f1, String f2, int almacen) {
        List<Factura> lista = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT F.CVE_DOC, F.RFC, F.FECHA_DOC, C.NOMBRE FROM FACTF01 AS F, CLIE01 AS C WHERE F.RFC=C.RFC AND "
                    + " F.FECHA_DOC>='" + f1 + "' AND F.FECHA_DOC<='" + f2 + "' AND F.NUM_ALMA='" + almacen + "'");
            rs = st.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Factura fVentas = new Factura();
                fVentas.setNofactura(rs.getString("CVE_DOC"));
                fVentas.setIdproveedor(rs.getString("RFC"));
                fVentas.setFecha(rs.getDate("FECHA_DOC"));
                fVentas.setProveedor(rs.getString("NOMBRE"));
                lista.add(fVentas);
            }
            this.Cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    //**LISTAR FACTURAS VENTAS**//

    //**LISTAR SERIES-FACTURAS VENTAS**//
    public List<Series> listarSeriesVentas(String factura) {
        List<Series> listar = null;
        ResultSet rs;
        try {
            this.Conectar();
            listar = new ArrayList<>();
            PreparedStatement st = this.getCn().prepareCall("SELECT dbo.PAR_FACTF01.CVE_DOC AS CVE_DOC,\n"
                    + "dbo.PAR_FACTF01.CVE_ART AS CVE_ART,\n"
                    + "dbo.INVE01.DESCR AS DESCR,\n"
                    + "dbo.HNUMSER01.NUM_SER AS SERIES,\n"
                    + "dbo.LTPD01.PEDIMENTO AS PEDIMENTO,\n"
                    + "dbo.LTPD01.NOM_ADUAN AS ADUANA,\n"
                    + "dbo.LTPD01.FCHADUANA AS FECHA_ADUANA,\n"
                    + "dbo.LTPD01.STATUS\n"
                    + "FROM dbo.PAR_FACTF01, dbo.ENLACE_LTPD01, dbo.LTPD01, dbo.HNUMSER01, dbo.INVE01\n"
                    + "WHERE   \n"
                    + "PAR_FACTF01.REG_SERIE=HNUMSER01.REG_SERIE AND\n"
                    + "dbo.PAR_FACTF01.CVE_ART = dbo.INVE01.CVE_ART AND \n"
                    + "dbo.PAR_FACTF01.E_LTPD = dbo.ENLACE_LTPD01.E_LTPD AND \n"
                    + "dbo.ENLACE_LTPD01.REG_LTPD = dbo.LTPD01.REG_LTPD AND \n"
                    + "dbo.HNUMSER01.STATUS='V'  AND\n"
                    + "PAR_FACTF01.CVE_DOC ='" + factura + "'");
            rs = st.executeQuery();
            while (rs.next()) {
                Series sVentas = new Series();
                sVentas.setFactura(rs.getString("CVE_DOC"));
                sVentas.setArticulo(rs.getString("CVE_ART"));
                sVentas.setDescripcion(rs.getString("DESCR"));
                sVentas.setSerie(rs.getString("SERIES"));
                sVentas.setPedimento(rs.getString("PEDIMENTO"));
                sVentas.setAduana(rs.getString("ADUANA"));
                sVentas.setFechapedimento(rs.getDate("FECHA_ADUANA"));
                sVentas.setSeleccionar(Boolean.FALSE);
                listar.add(sVentas);
            }
            this.Cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listar;
    }
    //**LISTAR SERIES-FACTURAS VENTAS**//

    //**LISTAR FACTURAS TRASPASOS ENTRADAS**//
    public List<Factura> listarFacturasTraspasosEntrada(String f1, String f2, int almacen) {
        List<Factura> lista = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT dbo.MINVE01.REFER AS  REFER,  MAX(Cast(DESCR as varchar(max))) AS DESCR,  FECHA_DOCU AS FECHA_DOCU\n"
                    + "FROM dbo.MINVE01, dbo.ALMACENES01 WHERE dbo.MINVE01.ALMACEN = '" + almacen + "' AND  dbo.MINVE01.CVE_CPTO = '7' AND  dbo.MINVE01.E_LTPD != '' AND \n"
                    + "dbo.MINVE01.ALMACEN = dbo.ALMACENES01.CVE_ALM AND FECHA_DOCU >= '" + f1 + "' AND FECHA_DOCU <= '" + f2 + "' GROUP BY REFER, FECHA_DOCU");
//            PreparedStatement st = this.getCn().prepareCall("SELECT dbo.MINVE01.REFER AS  REFER,  MAX(Cast(DESCR as varchar(max))) AS DESCR,  MAX(Cast(FECHA_DOCU as varchar(max))) AS FECHA_DOCU\n"
//                    + "FROM dbo.MINVE01, dbo.ALMACENES01 WHERE dbo.MINVE01.ALMACEN = '" + almacen + "' AND  dbo.MINVE01.CVE_CPTO = '7' AND  dbo.MINVE01.E_LTPD != '' AND \n"
//                    + "dbo.MINVE01.ALMACEN = dbo.ALMACENES01.CVE_ALM AND FECHA_DOCU >= '" + f1 + "' AND FECHA_DOCU <= '" + f2 + "' GROUP BY REFER");
            rs = st.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Factura fVentas = new Factura();
                fVentas.setNofactura(rs.getString("REFER"));
                fVentas.setFecha(rs.getDate("FECHA_DOCU"));
                fVentas.setProveedor(rs.getString("DESCR"));
                lista.add(fVentas);
            }
            this.Cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    //**LISTAR FACTURAS TRASPASOS ENTRADAS**//

    //**LISTAR SERIES-FACTURAS TRASPASOS ENTRADAS**//
    public List<Series> listarSeriesTraspasosEntrada(String factura) {
        List<Series> listar = null;
        ResultSet rs;
        try {
            this.Conectar();
            listar = new ArrayList<>();
            PreparedStatement st = this.getCn().prepareCall("SELECT dbo.HNUMSER01.CVE_DOC,\n"
                    + "dbo.HNUMSER01.CVE_ART,\n"
                    + "dbo.INVE01.DESCR, dbo.ALMACENES01.DESCR AS ALMACEN,\n"
                    + "dbo.HNUMSER01.NUM_SER AS SERIES,\n"
                    + "dbo.LTPD01.PEDIMENTO AS PEDIMENTO,\n"
                    + "dbo.LTPD01.NOM_ADUAN AS ADUANA,\n"
                    + "dbo.LTPD01.FCHADUANA AS FECHA_ADUANA\n"
                    + "FROM dbo.HNUMSER01,\n"
                    + "dbo.ALMACENES01,\n"
                    + "dbo.MINVE01,\n"
                    + "dbo.INVE01,\n"
                    + "dbo.ENLACE_LTPD01,\n"
                    + "dbo.LTPD01 \n"
                    + "WHERE\n"
                    + "dbo.HNUMSER01.CVE_DOC = '" + factura + "' AND\n"
                    + "dbo.HNUMSER01.TIP_MOV = 7 AND\n"
                    + "dbo.HNUMSER01.ALMACEN = dbo.ALMACENES01.CVE_ALM AND\n"
                    + "dbo.HNUMSER01.CVE_DOC = dbo.MINVE01.REFER AND\n"
                    + "dbo.HNUMSER01.CVE_ART = dbo.MINVE01.CVE_ART AND\n"
                    + "dbo.MINVE01.ALMACEN = dbo.HNUMSER01.ALMACEN AND\n"
                    + "dbo.MINVE01.ALMACEN = dbo.HNUMSER01.ALMACEN AND\n"
                    + "dbo.MINVE01.REG_SERIE = dbo.HNUMSER01.REG_SERIE AND\n"
                    + "dbo.HNUMSER01.CVE_ART =dbo.INVE01.CVE_ART   AND\n"
                    + "dbo.MINVE01.E_LTPD = dbo.ENLACE_LTPD01.E_LTPD AND\n"
                    + "dbo.ENLACE_LTPD01.REG_LTPD = dbo.LTPD01.REG_LTPD ");
            rs = st.executeQuery();
            while (rs.next()) {
                Series sVentas = new Series();
                sVentas.setFactura(rs.getString("CVE_DOC"));
                sVentas.setArticulo(rs.getString("CVE_ART"));
                sVentas.setDescripcion(rs.getString("DESCR"));
                sVentas.setSerie(rs.getString("SERIES"));
                sVentas.setPedimento(rs.getString("PEDIMENTO"));
                sVentas.setAduana(rs.getString("ADUANA"));
                sVentas.setFechapedimento(rs.getDate("FECHA_ADUANA"));
                sVentas.setSeleccionar(Boolean.FALSE);
                listar.add(sVentas);
            }
            this.Cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listar;
    }
    //**LISTAR SERIES-FACTURAS TRASPASOS ENTRADAS**//

    //**LISTAR FACTURAS TRASPASOS SALIDAS**//
    public List<Factura> listarFacturasTraspasosSalida(String f1, String f2, int almacen) {
        List<Factura> lista = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT dbo.MINVE01.REFER AS  REFER,  MAX(Cast(DESCR as varchar(max))) AS DESCR,  FECHA_DOCU AS FECHA_DOCU\n"
                    + "FROM dbo.MINVE01, dbo.ALMACENES01\n"
                    + "WHERE dbo.MINVE01.ALMACEN = '" + almacen + "' AND  dbo.MINVE01.CVE_CPTO = '58' AND dbo.MINVE01.E_LTPD != '' AND \n"
                    + "FECHA_DOCU >= '" + f1 + "' AND FECHA_DOCU <= '" + f2 + "' GROUP BY REFER, FECHA_DOCU");
            rs = st.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Factura fVentas = new Factura();
                fVentas.setNofactura(rs.getString("REFER"));
                fVentas.setFecha(rs.getDate("FECHA_DOCU"));
                fVentas.setProveedor(rs.getString("DESCR"));
                lista.add(fVentas);
            }
            this.Cerrar();
        } catch (SQLException e) {
        }
        return lista;
    }
    //**LISTAR FACTURAS TRASPASOS SALIDAS**//

    //**LISTAR SERIES-FACTURAS TRASPASOS SALIDAS**//
    public List<Series> listarSeriesTraspasosSalida(String factura) {
        List<Series> listar = null;
        ResultSet rs;
        try {
            this.Conectar();
            listar = new ArrayList<>();
            PreparedStatement st = this.getCn().prepareCall("SELECT dbo.HNUMSER01.CVE_DOC, dbo.HNUMSER01.CVE_ART,dbo.INVE01.DESCR,dbo.ALMACENES01.DESCR AS ALMACEN, \n"
                    + "dbo.HNUMSER01.NUM_SER AS SERIES, dbo.LTPD01.PEDIMENTO AS PEDIMENTO, dbo.LTPD01.NOM_ADUAN AS ADUANA, dbo.LTPD01.FCHADUANA AS FECHA_ADUANA\n"
                    + "FROM dbo.HNUMSER01,dbo.ALMACENES01,dbo.MINVE01,dbo.INVE01,dbo.ENLACE_LTPD01,dbo.LTPD01 \n"
                    + "WHERE dbo.HNUMSER01.CVE_DOC = '" + factura + "' AND dbo.HNUMSER01.TIP_MOV = 58 AND dbo.HNUMSER01.ALMACEN = dbo.ALMACENES01.CVE_ALM \n"
                    + "AND dbo.HNUMSER01.CVE_DOC = dbo.MINVE01.REFER AND dbo.HNUMSER01.CVE_ART = dbo.MINVE01.CVE_ART \n"
                    + "AND dbo.MINVE01.ALMACEN = dbo.HNUMSER01.ALMACEN AND dbo.MINVE01.ALMACEN = dbo.HNUMSER01.ALMACEN AND dbo.MINVE01.REG_SERIE = dbo.HNUMSER01.REG_SERIE \n"
                    + "AND dbo.HNUMSER01.CVE_ART =dbo.INVE01.CVE_ART AND dbo.MINVE01.E_LTPD = dbo.ENLACE_LTPD01.E_LTPD AND dbo.ENLACE_LTPD01.REG_LTPD = dbo.LTPD01.REG_LTPD ");
            rs = st.executeQuery();
            while (rs.next()) {
                Series sVentas = new Series();
                sVentas.setFactura(rs.getString("CVE_DOC"));
                sVentas.setArticulo(rs.getString("CVE_ART"));
                sVentas.setDescripcion(rs.getString("DESCR"));
                sVentas.setSerie(rs.getString("SERIES"));
                sVentas.setPedimento(rs.getString("PEDIMENTO"));
                sVentas.setAduana(rs.getString("ADUANA"));
                sVentas.setFechapedimento(rs.getDate("FECHA_ADUANA"));
                sVentas.setSeleccionar(Boolean.FALSE);
                listar.add(sVentas);
            }
            this.Cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listar;
    }
    //**LISTAR SERIES-FACTURAS TRASPASOS SALIDAS**//

}
