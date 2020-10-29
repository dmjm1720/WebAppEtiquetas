package com.etiquetas.qrsys.bean;

import com.etiquetas.qrsys.dao.FacturaDao;
import com.etiquetas.qrsys.dao.FacturaDaoImp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.etiquetas.qrsys.dao.Inve01Dao;
import com.etiquetas.qrsys.dao.InveDaoImp;
import com.etiquetas.qrsys.dao.SerieDao;
import com.etiquetas.qrsys.dao.SerieDaoImp;
import com.etiquetas.qrsys.e.model.Factura;
import com.etiquetas.qrsys.e.model.Serie;
import com.etiquetas.qrsys.e.model.Usuario;
import com.etiquetas.qrsys.s.model.Inve01;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

@Named(value = "serieBean")
@ViewScoped
public class SerieBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private UploadedFile nombre;
//    private final String path = "/home/danteac/Documents/ExcelFile/";
    private final String path = "C:\\ExcelFile\\";
    private List<Object> listar;
    private Serie serie;
    private List<String> listarDesc;
    private List<Serie> listaSeries;
    private List<Factura> listaBuscarFactura;
    private Factura factura;
    private Factura fact;
    private Serie serieId;
    private Serie recibirSerie;
    private Inve01 inveId;
    private Inve01 recibirInve;
    private int camposVaciosFactura = 0;
    private int camposVaciosArticulo = 0;
    private int camposVaciosSerie = 0;
    private List<String> listaSeriesDuplicadas;
    private List<String> listaArticulosInexistentes;
    private int registrosNuevos = 0;
    private String deleteFact;

    Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    public SerieBean() {
        serie = new Serie();
        factura = new Factura();
        fact = new Factura();
        serieId = new Serie();
        recibirSerie = new Serie();
        inveId = new Inve01();
        recibirInve = new Inve01();
    }

    public UploadedFile getNombre() {
        return nombre;
    }

    public void setNombre(UploadedFile nombre) {
        this.nombre = nombre;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<String> getListarDesc() {
        return listarDesc;
    }

    public List<Serie> getListaSeries() {
        SerieDao sDao = new SerieDaoImp();
        listaSeries = sDao.listaSeries();
        return listaSeries;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Factura getFact() {
        return fact;
    }

    public void setFact(Factura fact) {
        this.fact = fact;
    }

    public Serie getSerieId() {
        return serieId;
    }

    public void setSerieId(Serie serieId) {
        this.serieId = serieId;
    }

    public Serie getRecibirSerie() {
        return recibirSerie;
    }

    public void setRecibirSerie(Serie recibirSerie) {
        this.recibirSerie = recibirSerie;
    }

    public Inve01 getInveId() {
        return inveId;
    }

    public void setInveId(Inve01 inveId) {
        this.inveId = inveId;
    }

    public Inve01 getRecibirInve() {
        return recibirInve;
    }

    public void setRecibirInve(Inve01 recibirInve) {
        this.recibirInve = recibirInve;
    }

    public int getCamposVaciosFactura() {
        return camposVaciosFactura;
    }

    public void setCamposVaciosFactura(int camposVaciosFactura) {
        this.camposVaciosFactura = camposVaciosFactura;
    }

    public int getCamposVaciosArticulo() {
        return camposVaciosArticulo;
    }

    public void setCamposVaciosArticulo(int camposVaciosArticulo) {
        this.camposVaciosArticulo = camposVaciosArticulo;
    }

    public int getCamposVaciosSerie() {
        return camposVaciosSerie;
    }

    public void setCamposVaciosSerie(int camposVaciosSerie) {
        this.camposVaciosSerie = camposVaciosSerie;
    }

    public int getRegistrosNuevos() {
        return registrosNuevos;
    }

    public void setRegistrosNuevos(int registrosNuevos) {
        this.registrosNuevos = registrosNuevos;
    }

    public List<String> getListaSeriesDuplicadas() {
        return listaSeriesDuplicadas;
    }

    public List<String> getListaArticulosInexistentes() {
        return listaArticulosInexistentes;
    }

    public String getDeleteFact() {
        return deleteFact;
    }

    public void setDeleteFact(String deleteFact) {
        this.deleteFact = deleteFact;
    }

    public void obtener(List<List<XSSFCell>> cellDataList) throws SQLException {
        listar = new ArrayList<>();
        listaSeriesDuplicadas = new ArrayList<>();
        listaArticulosInexistentes = new ArrayList<>();
        this.camposVaciosArticulo = 0;
        this.camposVaciosFactura = 0;
        this.camposVaciosSerie = 0;
        this.registrosNuevos = 0;
//        this.listaArticulosInexistentes.clear();
//        this.listaSeriesDuplicadas.clear();
        for (int i = 0; i < cellDataList.size(); i++) {
            List<?> cellTempList = (List<?>) cellDataList.get(i);
            for (int j = 0; j < cellTempList.size(); j++) {
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                listar.add(hssfCell.toString());
            }
            String valores = listar.toString();
            String[] nuevos = valores.split(",");

            // Revisar si existe serie
            if (nuevos[2].replace("]", "").trim().length() > 0 && nuevos[1].trim().length() > 0 && nuevos[0].replace("[", "").trim().length() > 0) {
                recibirSerie = new Serie();
                recibirSerie.setSerie(nuevos[2].replace("]", "").trim());
                SerieDao sDao = new SerieDaoImp();
                this.serieId = sDao.returnSerieExistente(recibirSerie);
                //Revisar si existe articulo
                recibirInve = new Inve01();
                recibirInve.setCveArt(nuevos[1].trim());
                Inve01Dao iDao = new InveDaoImp();
                this.inveId = iDao.returnArticuloExistente(recibirInve);

                if (this.serieId == null && this.inveId != null) {
                    buscarArticulo(nuevos[1].trim(), nuevos[0].replace("[", "").trim(), nuevos[2].replace("]", "").trim());
                    this.registrosNuevos++;
                } else {
                    if (this.serieId != null) {
                        this.listaSeriesDuplicadas.add(this.serieId.getSerie());
                    }
                    if (this.inveId == null) {
                        this.listaArticulosInexistentes.add(nuevos[1].trim());
                    }
                }

            } else {
                if (nuevos[1].trim().isEmpty()) {
                    this.camposVaciosArticulo++;
                }
                if (nuevos[0].replace("[", "").trim().isEmpty()) {
                    this.camposVaciosFactura++;
                }
                if (nuevos[2].replace("]", "").trim().isEmpty()) {
                    this.camposVaciosSerie++;
                }

            }

            listar.clear();
            serieId = new Serie();
            recibirSerie = new Serie();
            inveId = new Inve01();
            recibirInve = new Inve01();

        }
        RequestContext.getCurrentInstance().update("frmEstatus");
        RequestContext.getCurrentInstance().execute("PF('dlgEstatus').show()");
    }

    public void LeerFichero(File filename) throws SQLException {
        List<List<XSSFCell>> cellData = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
            XSSFSheet hssfsheet = workBook.getSheetAt(0);
            Iterator<?> iteratorRow = hssfsheet.rowIterator();

            while (iteratorRow.hasNext()) {
                XSSFRow xssfRow = (XSSFRow) iteratorRow.next();
                Iterator<?> iterator = xssfRow.cellIterator();
                List<XSSFCell> cellTemp = new ArrayList<>();

                while (iterator.hasNext()) {
                    XSSFCell hssfCell = (XSSFCell) iterator.next();
                    cellTemp.add(hssfCell);
                }

                cellData.add(cellTemp);

            }

        } catch (IOException e) {
        }

        obtener(cellData);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE ETIQUETAS", "Archivo subido correctamente"));
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void upload(FileUploadEvent event) throws SQLException {
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copyFile(String fileName, InputStream input) {
        try {
            File unidadC = new File(this.path);
            if (!unidadC.exists()) {
                unidadC.mkdirs();
            }
            try (OutputStream dir = new FileOutputStream(new File(this.path + fileName))) {
                @SuppressWarnings("UnusedAssignment")
                int read = 0;
                byte[] bytes = new byte[5120];
                while ((read = input.read(bytes)) != -1) {
                    dir.write(bytes, 0, read);
                }
                input.close();
                dir.flush();
                dir.close();
            }
//            File f = new File("/home/danteac/Documents/ExcelFile/" + fileName);
            File f = new File("C:\\ExcelFile\\" + fileName);
            LeerFichero(f);
            File deleteFile = new File(this.path + fileName);
            deleteFile.delete();

        } catch (IOException | SQLException e) {

        }

    }

    public void buscarArticulo(String art, String fac, String ser) throws SQLException {
        this.deleteFact = fac;
        Inve01Dao iDao = new InveDaoImp();
        listarDesc = iDao.listaInve01(art);
        for (int i = 0; i < listarDesc.size(); i++) {
            SerieDao sDao = new SerieDaoImp();

            FacturaDao fDao = new FacturaDaoImp();
            listaBuscarFactura = fDao.listaBuscarFactura(fac);
            if (listaBuscarFactura.isEmpty()) {
                factura.setNofactura(fac);
//                java.util.Date fechaActual = new Date();
//                factura.setFecha(fechaActual);
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY, 0);
                c.set(Calendar.MINUTE, 0);
                c.set(Calendar.SECOND, 0);
                c.set(Calendar.MILLISECOND, 0);
                Date date = c.getTime();
                factura.setFecha(date);
                factura.setTipo("Compra");
                factura.setSubtipo("Entrada");
                fDao.saveFactura(factura);
                factura = new Factura();
                listaBuscarFactura.clear();
            }

            factura = new Factura();
            FacturaDao facDao = new FacturaDaoImp();
            factura.setNofactura(fac);
            this.fact = facDao.returnIdFactura(factura);
            serie.setUsuario(user);
            serie.setDescripcion(listarDesc.get(i));
            serie.setFactura(fact);
            serie.setSerie(ser);
            serie.setArticulo(art);
            serie.setSeleccionar(Boolean.FALSE);
            serie.setImpreso(0);
            sDao.saveSerie(serie);
            serie = new Serie();
            factura = new Factura();
            listaBuscarFactura.clear();
        }
    }

    public void borrarFactura() {
        FacturaDao fDao = new FacturaDaoImp();
        fDao.borrarFactura(this.deleteFact);
        this.deleteFact = null;
    }

}
