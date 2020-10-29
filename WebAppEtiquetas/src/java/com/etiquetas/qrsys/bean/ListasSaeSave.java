package com.etiquetas.qrsys.bean;

import com.etiquetas.qrsys.dao.Conexion;
import com.etiquetas.qrsys.dao.FacturaDao;
import com.etiquetas.qrsys.dao.FacturaDaoImp;
import com.etiquetas.qrsys.dao.SerieDao;
import com.etiquetas.qrsys.dao.SerieDaoImp;
import com.etiquetas.qrsys.e.model.Factura;
import com.etiquetas.qrsys.e.model.Serie;
import com.etiquetas.qrsys.e.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.context.FacesContext;

public class ListasSaeSave extends Conexion {

    private Factura fact;
    private Factura factura;
    private Serie serie;

    public ListasSaeSave() {
        fact = new Factura();
        factura = new Factura();
        serie = new Serie();
    }

    public Factura getFact() {
        return fact;
    }

    public void setFact(Factura fact) {
        this.fact = fact;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    //**LISTAR FACTURAS VENTAS**//
    public void listarVentas(String f1, String f2, int almacen) {
        ResultSet rs;
        ResultSet rset;
        ResultSet rsetSer;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT F.CVE_DOC, F.RFC, F.FECHA_DOC, C.NOMBRE FROM FACTF01 AS F, CLIE01 AS C WHERE F.RFC=C.RFC AND "
                    + " F.FECHA_DOC>='" + f1 + "' AND F.FECHA_DOC<='" + f2 + "' AND F.NUM_ALMA='" + almacen + "'");
            rs = st.executeQuery();
            while (rs.next()) {
                this.ConectarQr();
                PreparedStatement ps = this.getCnqr().prepareCall("SELECT NOFACTURA FROM FACTURA WHERE NOFACTURA='" + rs.getString("CVE_DOC") + "'");
                rset = ps.executeQuery();
                if (!rset.isBeforeFirst()) {
                    factura.setNofactura(rs.getString("CVE_DOC"));
                    factura.setFecha(rs.getDate("FECHA_DOC"));
                    factura.setProveedor(rs.getString("NOMBRE"));
                    factura.setIdalmacen(almacen);
                    factura.setTipo("Venta");
                    factura.setSubtipo("Salida");
                    factura.setIdusuario(user.getIdusuario());
                    FacturaDao fDao = new FacturaDaoImp();
                    fDao.saveFactura(factura);
                    PreparedStatement psSerie = this.getCn().prepareCall("SELECT dbo.PAR_FACTF01.CVE_DOC AS CVE_DOC,\n"
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
                            + "PAR_FACTF01.CVE_DOC ='" + rs.getString("CVE_DOC") + "'");
                    rsetSer = psSerie.executeQuery();
                    while (rsetSer.next()) {

                        serie.setSerie(rsetSer.getString("SERIES"));
                        serie.setArticulo(rsetSer.getString("CVE_ART"));
                        serie.setDescripcion(rsetSer.getString("DESCR"));
                        FacturaDao factDao = new FacturaDaoImp();
                        fact = factDao.returnIdFactura(factura);
                        //Falta ligar el id de la factura
                        serie.setFactura(fact);
                        serie.setUsuario(user);
                        serie.setAduana(rsetSer.getString("ADUANA"));
                        serie.setPedimento(rsetSer.getString("PEDIMENTO"));
                        serie.setFechapedimento(rsetSer.getDate("FECHA_ADUANA"));
                        serie.setImpreso(0);
                        SerieDao sDao = new SerieDaoImp();
                        sDao.saveSerie(serie);

                    }
                }
            }
            this.Cerrar();
            this.CerrarQr();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        serie = new Serie();
        fact = new Factura();
        factura = new Factura();
    }

    //**LISTAR FACTURAS TRASPASOS ENTRADAS**//
    public void listarFacturasTraspasosEntrada(String f1, String f2, int almacen) {
        ResultSet rs;
        ResultSet rset;
        ResultSet rsetSer;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT dbo.MINVE01.REFER AS  REFER,  MAX(Cast(DESCR as varchar(max))) AS DESCR,  FECHA_DOCU AS FECHA_DOCU\n"
                    + "FROM dbo.MINVE01, dbo.ALMACENES01 WHERE dbo.MINVE01.ALMACEN = '" + almacen + "' AND  dbo.MINVE01.CVE_CPTO = '7' AND  dbo.MINVE01.E_LTPD != '' AND \n"
                    + "dbo.MINVE01.ALMACEN = dbo.ALMACENES01.CVE_ALM AND FECHA_DOCU >= '" + f1 + "' AND FECHA_DOCU <= '" + f2 + "' GROUP BY REFER, FECHA_DOCU");
            rs = st.executeQuery();
            while (rs.next()) {
                this.ConectarQr();
                PreparedStatement ps = this.getCnqr().prepareCall("SELECT NOFACTURA FROM FACTURA WHERE NOFACTURA='" + rs.getString("REFER") + "'");
                rset = ps.executeQuery();
                if (!rset.isBeforeFirst()) {
                    factura.setNofactura(rs.getString("REFER"));
                    factura.setFecha(rs.getDate("FECHA_DOCU"));
                    factura.setProveedor(rs.getString("DESCR"));
                    factura.setIdalmacen(almacen);
                    factura.setTipo("Traspaso");
                    factura.setSubtipo("Entrada");
                    factura.setIdusuario(user.getIdusuario());
                    FacturaDao fDao = new FacturaDaoImp();
                    fDao.saveFactura(factura);
                    PreparedStatement psSerie = this.getCn().prepareCall("SELECT dbo.HNUMSER01.CVE_DOC,\n"
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
                            + "dbo.HNUMSER01.CVE_DOC = '" + rs.getString("REFER") + "' AND\n"
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
                    rsetSer = psSerie.executeQuery();
                    while (rsetSer.next()) {
                        serie.setSerie(rsetSer.getString("SERIES"));
                        serie.setArticulo(rsetSer.getString("CVE_ART"));
                        serie.setDescripcion(rsetSer.getString("DESCR"));
                        FacturaDao factDao = new FacturaDaoImp();
                        fact = factDao.returnIdFactura(factura);
                        //Falta ligar el id de la factura
                        serie.setFactura(fact);
                        serie.setUsuario(user);
                        serie.setAduana(rsetSer.getString("ADUANA"));
                        serie.setPedimento(rsetSer.getString("PEDIMENTO"));
                        serie.setFechapedimento(rsetSer.getDate("FECHA_ADUANA"));
                        serie.setImpreso(0);
                        SerieDao sDao = new SerieDaoImp();
                        sDao.saveSerie(serie);

                    }
                }

            }
            this.Cerrar();
            this.CerrarQr();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        serie = new Serie();
        fact = new Factura();
        factura = new Factura();

    }

    //**LISTAR FACTURAS TRASPASOS SALIDAS**//
    public void listarFacturasTraspasosSalida(String f1, String f2, int almacen) {
        ResultSet rs;
        ResultSet rset;
        ResultSet rsetSer;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT dbo.MINVE01.REFER AS  REFER,  MAX(Cast(DESCR as varchar(max))) AS DESCR,  FECHA_DOCU AS FECHA_DOCU\n"
                    + "FROM dbo.MINVE01, dbo.ALMACENES01\n"
                    + "WHERE dbo.MINVE01.ALMACEN = '" + almacen + "' AND  dbo.MINVE01.CVE_CPTO = '58' AND dbo.MINVE01.E_LTPD != '' AND \n"
                    + "FECHA_DOCU >= '" + f1 + "' AND FECHA_DOCU <= '" + f2 + "' GROUP BY REFER, FECHA_DOCU");
            rs = st.executeQuery();
            while (rs.next()) {
                this.ConectarQr();
                PreparedStatement ps = this.getCnqr().prepareCall("SELECT NOFACTURA FROM FACTURA WHERE NOFACTURA='" + rs.getString("REFER") + "'");
                rset = ps.executeQuery();
                if (!rset.isBeforeFirst()) {
                    factura.setNofactura(rs.getString("REFER"));
                    factura.setFecha(rs.getDate("FECHA_DOCU"));
                    factura.setProveedor(rs.getString("DESCR"));
                    factura.setIdalmacen(almacen);
                    factura.setTipo("Traspaso");
                    factura.setSubtipo("Salida");
                    factura.setIdusuario(user.getIdusuario());
                    FacturaDao fDao = new FacturaDaoImp();
                    fDao.saveFactura(factura);
                    PreparedStatement psSerie = this.getCn().prepareCall("SELECT dbo.HNUMSER01.CVE_DOC, dbo.HNUMSER01.CVE_ART,dbo.INVE01.DESCR,dbo.ALMACENES01.DESCR AS ALMACEN, \n"
                            + "dbo.HNUMSER01.NUM_SER AS SERIES, dbo.LTPD01.PEDIMENTO AS PEDIMENTO, dbo.LTPD01.NOM_ADUAN AS ADUANA, dbo.LTPD01.FCHADUANA AS FECHA_ADUANA\n"
                            + "FROM dbo.HNUMSER01,dbo.ALMACENES01,dbo.MINVE01,dbo.INVE01,dbo.ENLACE_LTPD01,dbo.LTPD01 \n"
                            + "WHERE dbo.HNUMSER01.CVE_DOC = '" + rs.getString("REFER") + "' AND dbo.HNUMSER01.TIP_MOV = 58 AND dbo.HNUMSER01.ALMACEN = dbo.ALMACENES01.CVE_ALM \n"
                            + "AND dbo.HNUMSER01.CVE_DOC = dbo.MINVE01.REFER AND dbo.HNUMSER01.CVE_ART = dbo.MINVE01.CVE_ART \n"
                            + "AND dbo.MINVE01.ALMACEN = dbo.HNUMSER01.ALMACEN AND dbo.MINVE01.ALMACEN = dbo.HNUMSER01.ALMACEN AND dbo.MINVE01.REG_SERIE = dbo.HNUMSER01.REG_SERIE \n"
                            + "AND dbo.HNUMSER01.CVE_ART =dbo.INVE01.CVE_ART AND dbo.MINVE01.E_LTPD = dbo.ENLACE_LTPD01.E_LTPD AND dbo.ENLACE_LTPD01.REG_LTPD = dbo.LTPD01.REG_LTPD ");
                    rsetSer = psSerie.executeQuery();
                    while (rsetSer.next()) {
                        serie.setSerie(rsetSer.getString("SERIES"));
                        serie.setArticulo(rsetSer.getString("CVE_ART"));
                        serie.setDescripcion(rsetSer.getString("DESCR"));
                        FacturaDao factDao = new FacturaDaoImp();
                        fact = factDao.returnIdFactura(factura);
                        //Falta ligar el id de la factura
                        serie.setFactura(fact);
                        serie.setUsuario(user);
                        serie.setAduana(rsetSer.getString("ADUANA"));
                        serie.setPedimento(rsetSer.getString("PEDIMENTO"));
                        serie.setFechapedimento(rsetSer.getDate("FECHA_ADUANA"));
                        serie.setImpreso(0);
                        SerieDao sDao = new SerieDaoImp();
                        sDao.saveSerie(serie);
                    }
                }

            }
            this.Cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        serie = new Serie();
        fact = new Factura();
        factura = new Factura();

    }
    //**LISTAR FACTURAS TRASPASOS SALIDAS**//

}
