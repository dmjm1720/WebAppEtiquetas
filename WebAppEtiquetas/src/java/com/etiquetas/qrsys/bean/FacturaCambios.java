package com.etiquetas.qrsys.bean;

import com.etiquetas.qrsys.dao.*;
import com.etiquetas.qrsys.s.model.*;
import com.etiquetas.qrsys.e.model.*;
import com.etiquetas.qrsys.jasper.QrPreview;
import java.io.IOException;
import java.io.Serializable;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

@Named(value = "facturaBean")
@ViewScoped
public class FacturaCambios implements Serializable {

    private Factura factura;
    private List<Factura> listarFactura;
    private List<Factura> listarFacturaAlmancen;
    private Prov01 proveedor;
    private List<SelectItem> listaProveedores;
    private Impu01 impuesto;
    private List<SelectItem> listaImpuestos;
    private Moned01 moneda;
    private List<SelectItem> listaMonedas;
    private List<SelectItem> listaTipoCambio;
    private Almacenes01 almacen;
    private List<SelectItem> listaAlmacenes;
    private Serie series;
    private List<Serie> listarSeries;
    private Serie serieEditar;
    private Factura fact;
    private Factura invoice;
    private List<Serie> listaSeriesIngresadas;
    private Serie serie;
    private List<Serie> listaSeriesImpresion;
    private int contador;
    private EtiquetaBean etiqueta;
    private String noFacturaImpresion;
    private Factura facturaObservacion;
    private Factura facturaRegistro;
    private ObsDocc01 obsdoc;
    private Compc01 compc;
    private int valorMoneda = 0;
    private CompcClib01 compcclib01;
    private Ltpd01 lp;
    private List<String> listaSeriesSaeReg;
    private EnlaceLtpd01 enlace;
    private ParCompc01 parcompc;
    private ParCompcClib01 clib01;
    private Minve01 minve;
    private Hnumser01 hnumser;
    private Numser01 numser;
    private List<String> listaHNSer;
    private int numreg;
    private List<String> listaSeriesEstado1;
    private String pathReporte = "";
    private List<ParCompc01> itemsReg;
    private List<String> nuevaReg;
    Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    public FacturaCambios() {
        factura = new Factura();
        proveedor = new Prov01();
        impuesto = new Impu01();
        moneda = new Moned01();
        almacen = new Almacenes01();
        series = new Serie();
        serieEditar = new Serie();
        fact = new Factura();
        invoice = new Factura();
        serie = new Serie();
        etiqueta = new EtiquetaBean();
        facturaObservacion = new Factura();
        facturaRegistro = new Factura();
        obsdoc = new ObsDocc01();
        compc = new Compc01();
        compcclib01 = new CompcClib01();
        lp = new Ltpd01();
        enlace = new EnlaceLtpd01();
        parcompc = new ParCompc01();
        clib01 = new ParCompcClib01();
        minve = new Minve01();
        hnumser = new Hnumser01();
        numser = new Numser01();
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getListarFactura() {
        FacturaDao fDao = new FacturaDaoImp();
        listarFactura = fDao.listaFactura();
        return listarFactura;
    }

    public List<Factura> getListarFacturaAlmancen() {
        FacturaDao fDao = new FacturaDaoImp();
        listarFacturaAlmancen = fDao.listaFacturaPorAlmacen();
        return listarFacturaAlmancen;
    }

    public void setListarFacturaAlmancen(List<Factura> listarFacturaAlmancen) {
        this.listarFacturaAlmancen = listarFacturaAlmancen;
    }

    public Prov01 getProveedor() {
        return proveedor;
    }

    public void setProveedor(Prov01 proveedor) {
        this.proveedor = proveedor;
    }

    public Impu01 getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impu01 impuesto) {
        this.impuesto = impuesto;
    }

    public Moned01 getMoneda() {
        return moneda;
    }

    public void setMoneda(Moned01 moneda) {
        this.moneda = moneda;
    }

    public Almacenes01 getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacenes01 almacen) {
        this.almacen = almacen;
    }

    public Serie getSeries() {
        return series;
    }

    public void setSeries(Serie series) {
        this.series = series;
    }

    public Serie getSerieEditar() {
        return serieEditar;
    }

    public void setSerieEditar(Serie serieEditar) {
        this.serieEditar = serieEditar;
    }

    public Factura getFact() {
        return fact;
    }

    public void setFact(Factura fact) {
        this.fact = fact;
    }

    public Factura getInvoice() {
        return invoice;
    }

    public void setInvoice(Factura invoice) {
        this.invoice = invoice;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public EtiquetaBean getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(EtiquetaBean etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getNoFacturaImpresion() {
        return noFacturaImpresion;
    }

    public void setNoFacturaImpresion(String noFacturaImpresion) {
        this.noFacturaImpresion = noFacturaImpresion;
    }

    public Factura getFacturaObservacion() {
        return facturaObservacion;
    }

    public void setFacturaObservacion(Factura facturaObservacion) {
        this.facturaObservacion = facturaObservacion;
    }

    public Factura getFacturaRegistro() {
        return facturaRegistro;
    }

    public void setFacturaRegistro(Factura facturaRegistro) {
        this.facturaRegistro = facturaRegistro;
    }

    public ObsDocc01 getObsdoc() {
        return obsdoc;
    }

    public void setObsdoc(ObsDocc01 obsdoc) {
        this.obsdoc = obsdoc;
    }

    public Compc01 getCompc() {
        return compc;
    }

    public void setCompc(Compc01 compc) {
        this.compc = compc;
    }

    public int getValorMoneda() {
        return valorMoneda;
    }

    public void setValorMoneda(int valorMoneda) {
        this.valorMoneda = valorMoneda;
    }

    public CompcClib01 getCompcclib01() {
        return compcclib01;
    }

    public void setCompcclib01(CompcClib01 compcclib01) {
        this.compcclib01 = compcclib01;
    }

    public Ltpd01 getLp() {
        return lp;
    }

    public void setLp(Ltpd01 lp) {
        this.lp = lp;
    }

    public EnlaceLtpd01 getEnlace() {
        return enlace;
    }

    public void setEnlace(EnlaceLtpd01 enlace) {
        this.enlace = enlace;
    }

    public ParCompc01 getParcompc() {
        return parcompc;
    }

    public void setParcompc(ParCompc01 parcompc) {
        this.parcompc = parcompc;
    }

    public ParCompcClib01 getClib01() {
        return clib01;
    }

    public void setClib01(ParCompcClib01 clib01) {
        this.clib01 = clib01;
    }

    public Minve01 getMinve() {
        return minve;
    }

    public void setMinve(Minve01 minve) {
        this.minve = minve;
    }

    public List<String> getListaSeriesSaeReg() {
        return listaSeriesSaeReg;
    }

    public List<String> getListaHNSer() {
        return listaHNSer;
    }

    public void setListaHNSer(List<String> listaHNSer) {
        this.listaHNSer = listaHNSer;
    }

    public Hnumser01 getHnumser() {
        return hnumser;
    }

    public void setHnumser(Hnumser01 hnumser) {
        this.hnumser = hnumser;
    }

    public Numser01 getNumser() {
        return numser;
    }

    public void setNumser(Numser01 numser) {
        this.numser = numser;
    }

    public int getNumreg() {
        return numreg;
    }

    public void setNumreg(int numreg) {
        this.numreg = numreg;
    }

    public List<String> getListaSeriesEstado1() {
        return listaSeriesEstado1;
    }

    public void setListaSeriesEstado1(List<String> listaSeriesEstado1) {
        this.listaSeriesEstado1 = listaSeriesEstado1;
    }

    public String getPathReporte() {
        return pathReporte;
    }

    public void setPathReporte(String pathReporte) {
        this.pathReporte = pathReporte;
    }

    public List<SelectItem> getListaProveedores() {
        listaProveedores = new ArrayList<>();
        Prov01Dao pDao = new Prov01DaoImp();
        List<Prov01> prov = pDao.listaProveedores();
        listaProveedores.clear();

        for (Prov01 nombrePro : prov) {
            SelectItem nombreProv = new SelectItem(nombrePro.getNombre() + "-" + nombrePro.getClave());
            listaProveedores.add(nombreProv);
        }
        return listaProveedores;
    }

    public List<SelectItem> getListaImpuestos() {
        listaImpuestos = new ArrayList<>();
        Impu01Dao iDao = new ImpuDaoImp();
        List<Impu01> impu = iDao.listarImpuestos();
        listaImpuestos.clear();
        for (Impu01 impu01 : impu) {
            SelectItem imp = new SelectItem(impu01.getDescripesq());
            listaImpuestos.add(imp);
        }
        return listaImpuestos;
    }

    public List<SelectItem> getListaMonedas() {
        listaMonedas = new ArrayList<>();
        Moned01Dao mDao = new MonedaDaoImp();
        List<Moned01> mon = mDao.listarMonedas();
        listaMonedas.clear();
        for (Moned01 moned01 : mon) {
            SelectItem tmon = new SelectItem(moned01.getDescr());
            listaMonedas.add(tmon);
        }
        return listaMonedas;
    }

    public List<SelectItem> getListaTipoCambio() {
        listaTipoCambio = new ArrayList<>();
        Moned01Dao mDao = new MonedaDaoImp();
        List<Moned01> tcam = mDao.listarTipoCambio(factura);
        listaTipoCambio.clear();
        for (Moned01 moned01 : tcam) {
            SelectItem tcambio = new SelectItem((moned01.getTcambio()));
            listaTipoCambio.add(tcambio);
        }
        return listaTipoCambio;
    }
//    public List<SelectItem> getListaTipoCambio() {
//        listaTipoCambio = new ArrayList<>();
//        Moned01Dao mDao = new MonedaDaoImp();
//        List<Moned01> tcam = mDao.listarMonedas();
//        listaTipoCambio.clear();
//        for (Moned01 moned01 : tcam) {
//            SelectItem tcambio = new SelectItem(moned01.getTcambio());
//            listaTipoCambio.add(tcambio);
//        }
//        return listaTipoCambio;
//    }

    public List<SelectItem> getListaAlmacenes() {
        listaAlmacenes = new ArrayList<>();
        Almacenes01Dao aDao = new Almacenes01DaoImp();
        List<Almacenes01> alm = aDao.listaAlmacenes();
        listaAlmacenes.clear();
        for (Almacenes01 almacenes01 : alm) {
            SelectItem almac = new SelectItem(almacenes01.getDescr() + "-" + almacenes01.getCveAlm());
            listaAlmacenes.add(almac);
        }
        return listaAlmacenes;
    }

    public void actualizarFactura() {
        FacturaDao fDao = new FacturaDaoImp();
        String valorCodProv = factura.getProveedor();
        String[] codprov = valorCodProv.split("-");
        String valorCodAlm = factura.getAlmacen();
        String[] codAlm = valorCodAlm.split("-");
        factura.setIdusuario(user.getIdusuario());
        factura.setTipo("Compra");
        factura.setSubtipo("Entrada");
        factura.setAlmacen(codAlm[0]);
        factura.setIdalmacen(Integer.parseInt(codAlm[1]));
        factura.setProveedor(codprov[0]);
        factura.setIdproveedor(codprov[1]);
        fDao.updateFactura(factura);
        factura = new Factura();
    }

    public List<Serie> getListarSeries() {
        return listarSeries;
    }

    public List<Serie> getListaSeriesIngresadas() {
        return listaSeriesIngresadas;
    }

    public List<Serie> getListaSeriesImpresion() {
        return listaSeriesImpresion;
    }

    public void listaSeriesCargadas(String nofactura) {
        if (!nofactura.isEmpty()) {
            SerieDao sDao = new SerieDaoImp();
            listaSeriesIngresadas = sDao.listaDeSeries(nofactura);
        }
    }

    public void listaSerie(String nofactura) {
        if (!nofactura.isEmpty()) {
            SerieDao sDao = new SerieDaoImp();
            //listarSeries = sDao.listaSeriesPorFactura(nofactura);
            listarSeries = sDao.listaSeriesConInformacion(nofactura);
        }
    }

    public List<ParCompc01> getItemsReg() {
        return itemsReg;
    }

    public List<String> getNuevaReg() {
        return nuevaReg;
    }

    public void setNuevaReg(List<String> nuevaReg) {
        this.nuevaReg = nuevaReg;
    }

    public void procesar() {
        if (serieEditar.getAduana().isEmpty() && serieEditar.getPedimento().isEmpty() && serieEditar.getLote().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "Campos requeridos"));
        }
        SerieDao sDao = new SerieDaoImp();
        //listaHNSer = new ArrayList<>();
        for (int i = 0; i < listarSeries.size(); i++) {
            if (listarSeries.get(i).getSeleccionar().equals(TRUE)) {
                FacturaDao facDao = new FacturaDaoImp();
                invoice.setNofactura(listarSeries.get(i).getFactura().getNofactura());
                this.fact = facDao.returnIdFactura(invoice);
                series.setFactura(fact);
                series.setUsuario(user);
                series.setIdserie(listarSeries.get(i).getIdserie());
                series.setSerie(listarSeries.get(i).getSerie());
                series.setArticulo(listarSeries.get(i).getArticulo());
                series.setDescripcion(listarSeries.get(i).getDescripcion());
                series.setAduana(serieEditar.getAduana());
                series.setPedimento(serieEditar.getPedimento());
                series.setFechapedimento(serieEditar.getFechapedimento());
                series.setLote(serieEditar.getLote());
                series.setImpreso(0);
                series.setSeleccionar(FALSE);
                series.setSae(FALSE);
                //**AGREGAMOS LOS DATOS A LA LISTA HNUMSER Y NUMSER**//
                //listaHNSer.add(listarSeries.get(i).getSerie());
                //listaHNSer.add(listarSeries.get(i).getArticulo());
                //**ACTUALIZAMOS LOS DATOS ADUANA, PEDIMENTO, FECHA Y LOTE EN LA TABLA SERIE**//
                sDao.updateSerie(series);

            }
        }

        //**OBTENEMOS LA INFORMACION DEL CAMPO OBSERVACION DE LA TABLA FACTURA**//
        facturaObservacion = new Factura();
        FacturaDao facDao = new FacturaDaoImp();
        this.facturaObservacion = facDao.returnIdFactura(invoice);

        //**OBTENEMOS LA LISTA DE LAS SERIES ACTUALIZADAS**//
        SerieDao serRegDao = new SerieDaoImp();
        listaSeriesSaeReg = serRegDao.listarSeriesSaeRegistro(user.getIdusuario(), serieEditar.getPedimento());
        for (int i = 0; i < listaSeriesSaeReg.size(); i++) {

            //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA LTPD01 DEL CAMPO REG_LTPD**//
            Ltpd01Dao lDao = new Ltpd01DaoImp();
            String maxVal = lDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");

            //**OBTENEMOS EL TOTAL DE LAS SERIES**//
            String miArt = listaSeriesSaeReg.toString().replace("[", "").replace("]", "");
            String[] art = miArt.split(",");

            //**GUARDAMOS EL TOTAL DE LAS SERIES EN LA TABLA LTPD01**//
            SerieDao serieDao = new SerieDaoImp();
            String conteo = serieDao.listarSeriesSae(user.getIdusuario(), serieEditar.getPedimento(), art[i].trim()).toString().replace("[", "").replace("]", "");
            lp.setCveArt(art[i].trim());
            lp.setLote(serieEditar.getLote());
            lp.setPedimento(serieEditar.getPedimento());
            lp.setCveAlm(this.facturaObservacion.getIdalmacen());
            lp.setFchaduana(serieEditar.getFechapedimento());
            lp.setFchultmov(serieEditar.getFechapedimento());
            lp.setNomAduan(serieEditar.getAduana());
            lp.setCantidad(new Double(conteo));
            lp.setRegLtpd(Integer.parseInt(maxVal));
            lp.setCveObs(this.facturaObservacion.getCveobs());
            lp.setCiudad("");
            lp.setFrontera("");
            lp.setStatus("A");
            lp.setPedimentosat(serieEditar.getPedimento());
            //lp.setPedimentosat(serieEditar.getPedimento());
            Ltpd01Dao lpDao = new Ltpd01DaoImp();
            lpDao.saveLtp01(lp);

            //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA LTPD01 DEL CAMPO REG_LTPD**//
            Ltpd01Dao regDao = new Ltpd01DaoImp();
            String maxReg = regDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");

            //**ACTUALIZAMOS LA TABLA TBLCONTROL01 CAMPO ULT_CVE='maxVal'-ID_TABLE=48**//
            Tblcontrol01Dao tablaDao = new Tblcontrol01DaoImpl();
            tablaDao.updateTablaControl(Integer.parseInt(maxReg));

            //**OBTENEMOS EL VALOR MAXIMO DE LA TABLA ENLACE_LTPD01**//
            EnlaceLtpd01Dao eDao = new EnlaceLtpd01DaoImp();
            String maxRegEnlace = eDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");

            //**GUARDAMOS EN LA TABLA ENLACE_LTPD01 LOS VALORES EN LOS CAMPOS E_LTPD,REG_LTPD,CANTIDAD,PXRS**//
            EnlaceLtpd01Dao enDao = new EnlaceLtpd01DaoImp();
            enlace.seteLtpd(Integer.parseInt(maxRegEnlace));
            enlace.setRegLtpd(Integer.parseInt(maxReg) - 1);////*******VALOR QUE DEBE LLEVAR
            enlace.setCantidad(Double.parseDouble(conteo));
            enlace.setPxrs(Double.parseDouble(conteo));
            enDao.saveEnlaceLtpd01(enlace);

            //**ACTUALIZAMOS LA TABLA TBLCONTROL01 SET ULT_CVE = 'MAX(E_LTPD)' WHERE ID_TABLA=67**//
            Tblcontrol01Dao taDao = new Tblcontrol01DaoImpl();
            taDao.updateTbl67Control(Integer.parseInt(maxRegEnlace));

            //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA HNUMSER01**//
            Hnumser01Dao hDao = new Hnumser01DaoImp();
            String maxRegHnumser = hDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");

            //**GUARDAMOS EN LA TABLA PAR_COMPC01**//
            ParCompc01Dao parDao = new ParCompc01Imp();
            parcompc.setCveDoc(facturaObservacion.getCvedoc());
            ParCompc01Dao itemDao = new ParCompc01Imp();
            String item = itemDao.obtenerMaximoValor(facturaObservacion.getCvedoc()).toString().replace("[", "").replace("]", "");
            if (item.contains("null")) {
                item = "1";
            }
            parcompc.setNumPar(Integer.parseInt(item));//buscar el número de partida en la tabla PAR_COMPC01
            parcompc.setCveArt(art[i].trim());
            parcompc.setCant(Double.parseDouble(conteo));
            parcompc.setPxr(Double.parseDouble(conteo));
            parcompc.setPrec(0.0);
            parcompc.setCost(0.0);
            parcompc.setImpu1(0.0);
            parcompc.setImpu2(0.0);
            parcompc.setImpu3(0.0);
            parcompc.setImpu4(0.0);
            parcompc.setImp1apla(Short.parseShort("0"));
            parcompc.setImp2apla(Short.parseShort("0"));
            parcompc.setImp3apla(Short.parseShort("0"));
            parcompc.setImp4apla(Short.parseShort("0"));
            parcompc.setTotimp1(0.0);
            parcompc.setTotimp2(0.0);
            parcompc.setTotimp3(0.0);
            parcompc.setTotimp4(0.0);
            parcompc.setDescu(0.0);
            parcompc.setActInv("S");
            parcompc.setTipCam(facturaObservacion.getTipocambio());
            parcompc.setUniVenta("PZ");
            parcompc.setTipoElem("N");
            parcompc.setTipoProd("P");
            parcompc.setCveObs(0);

            if (i > 0) {
                parcompc.setRegSerie(Integer.parseInt(maxRegHnumser) + i);
            } else {
                parcompc.setRegSerie(Integer.parseInt(maxRegHnumser));
            }

            parcompc.setELtpd(Integer.parseInt(maxRegEnlace));
            parcompc.setFactconv(1.0);
            parcompc.setCostDev(0.0);
            parcompc.setNumAlm(facturaObservacion.getIdalmacen());
            parcompc.setMindirecto(0.0);
            //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA MINVE01 DEL CAMPO NUM_MOV**//
            Minve01Dao mDao = new Minve01DaoImp();
            String maxValMinve = mDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");
            parcompc.setNumMov(Integer.parseInt(maxValMinve));///Colocar el NUM_MOV
            parcompc.setTotPartida(0.0);
            parDao.saveParCompc01(parcompc);

            //**GUARDAMOS EN LA TABLA PAR_COMPC_CLIB01**//
            ParCompcClib01Dao clibDao = new ParCompcClib01DaoImp();
            clib01.setClaveDoc(facturaObservacion.getCvedoc());
            clib01.setNumPart(Integer.parseInt(item));//colocarl el número de partida
            clibDao.saveParCompcClib(clib01);
            //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA MULT01**//
            Mult01Dao mulDao = new Mult01DaoImp();
            String maxValMult = mulDao.obtenerMaximoValor(art[i].trim(), facturaObservacion.getIdalmacen()).toString().replace("[", "").replace("]", "");
            if (maxValMult.contains("null")) {
                maxValMult = "0.0";
            }
            //**ACTUALIZAMOS EL MAXIMO VALOR EN LA TABLA MULT01 CAMPO EXIST+LA CANTIDAD**//
            Mult01Dao mult01Dao = new Mult01DaoImp();
            mult01Dao.updateMult01(art[i].trim(), facturaObservacion.getIdalmacen(), (Double.parseDouble(conteo) + Double.parseDouble(maxValMult)));

            Minve01Dao minveDao = new Minve01DaoImp();
            minve.setCveArt(art[i].trim());
            minve.setAlmacen(facturaObservacion.getIdalmacen());
            minve.setNumMov(Integer.parseInt(maxValMinve));
            minve.setCveCpto(1);
            minve.setFechaDocu(facturaObservacion.getFecha());
            minve.setTipoDoc("C");
            minve.setRefer(facturaObservacion.getCvedoc());
            minve.setClaveClpv(facturaObservacion.getIdproveedor());
            //minve.setVend("");
            minve.setCant(Double.parseDouble(conteo));
            minve.setCantCost(1.0);
            minve.setPrecio(0.0);
            minve.setCosto(0.0);
            //minve.setAfecCoi("");
            minve.setCveObs(facturaObservacion.getCveobs());
            if (i > 0) {
                minve.setRegSerie(Integer.parseInt(maxRegHnumser) + i);
            } else {
                minve.setRegSerie(Integer.parseInt(maxRegHnumser));
            }

            minve.setUniVenta("PZ");
            minve.setELtpd(Integer.parseInt(maxRegEnlace));
            minve.setExistencia((Double.parseDouble(conteo) + Double.parseDouble(maxValMult)));
            minve.setTipoProd("P");
            minve.setFactorCon(1.0);
            minve.setFechaelab(facturaObservacion.getFecha());
            //minve.setCtlpol("");
            //minve.setCveFolio("");
            minve.setSigno(1);
            minve.setCosteado("S");
            minve.setCostoPromIni(0.0);
            minve.setCostoPromFin(0.0);
            //minve.setCostoPromGral(0.0);
            minve.setDesdeInve("N");
            minve.setMovEnlazado(0);
            minveDao.saveMinve01(minve);

            //**OBTENEMOS LA SUMA DE LA TABLA INVE01 CAMPO EXIST**//
            Inve01Dao sumaDao = new InveDaoImp();
            String sumaExist = sumaDao.obtenerMaximoValor(art[i].trim()).toString().replace("[", "").replace("]", "");

            //**ACTUALIZAMOS LA TABLA INVEV01**//
            Inve01Dao updateDao = new InveDaoImp();
            updateDao.updateInve01(Double.parseDouble(sumaExist) + (Double.parseDouble(conteo)), art[i].trim());
            //**GUARDAMOS EN LA TABLA HNUMSER**//

            conteo = "";
            maxVal = "";
            maxReg = "";
            maxRegEnlace = "";
            maxValMinve = "";
            maxRegHnumser = "";
        }
        //**GUARDAMOS EN LA TABLA NUMSER**//

        String listaHN = listaHNSer.toString().replace("[", "").replace("]", "");
        String[] lHN = listaHN.split(",");
        int a = 0;
        int b = 1;
        for (int i = 0; i < listaHNSer.size() / 2; i++) {
            Numser01Dao numserDao = new Numser01DaoImp();
            numser.setCveArt(lHN[b].trim());
            numser.setNumSer(lHN[a].trim());
            numser.setStatus("D");
            numser.setAlmacen(facturaObservacion.getIdalmacen());
            numser.setCosto(0.0);
            numser.setDoctoEnt("");
            numser.setFechaEnt(facturaObservacion.getFecha());
            numserDao.saveNumser01(numser);
//            ParCompc01Dao parDao = new ParCompc01Imp();
//            String miReg = parDao.obtenerMaximoValor(facturaObservacion.getCvedoc(), lHN[b].trim()).toString().replace("[", "").replace("]", "");
//            miReg = miReg.substring(0, 10);
            Hnumser01Dao hnumserDao = new Hnumser01DaoImp();
            hnumser.setCveArt(lHN[b].trim());
            hnumser.setNumSer(lHN[a].trim());
            hnumser.setTipMov(1);
            hnumser.setTipDoc("M");
            hnumser.setCveDoc(facturaObservacion.getCvedoc());
            hnumser.setAlmacen(facturaObservacion.getIdalmacen());
            //hnumser.setRegSerie(numreg);
            //hnumser.setRegSerie(Integer.parseInt(miReg));
            hnumser.setFecha(facturaObservacion.getFecha());
            hnumser.setStatus("D");
            hnumserDao.saveHmunser(hnumser);
            a = a + 2;
            b = b + 2;
        }
        //**GUARDAMOS EN LA TABLA HNUMSER**//

        //**ACTUALIZAMOS LA TABLA SERIES CAMPO SAE A 1**//
        SerieDao serDao = new SerieDaoImp();
        List<String> serieSae = null;
        serieSae = serDao.listarSeriesSaeEstado1(user.getIdusuario(), serieEditar.getPedimento());
        for (int j = 0; j < serieSae.size(); j++) {
            serDao.updateSerieSae1(serieSae.get(j).replace("[", "").replace("]", ""));
        }
        //**LIMPIAMOS LOS OBJETOS**//
        compcclib01 = new CompcClib01();
        obsdoc = new ObsDocc01();
        lp = new Ltpd01();
        parcompc = new ParCompc01();
        clib01 = new ParCompcClib01();
        minve = new Minve01();
        listaHNSer.clear();
        numreg = 0;
        numser = new Numser01();
        hnumser = new Hnumser01();

        //**LIMPIAMOS LOS OBJETOS**//
        //**LISTAMOS LA INFORMACION DE LAS SERIES SIN INFORMACIÓN CORRESPONDIENTES A LA FACTURA SELECCIONADA**//
        listaSerie(invoice.getNofactura());
        serieEditar = new Serie();
        this.valorMoneda = 0;
        RequestContext.getCurrentInstance().update("frmVerSeries:tblSeries");
        RequestContext.getCurrentInstance().update("frmVerSeries:mensajes");

    }

    public void eliminarFactura() {
        FacturaDao fDao = new FacturaDaoImp();
        fDao.deleteFactura(factura);
        factura = new Factura();
    }

    public void eliminarSerie() {
        SerieDao sDao = new SerieDaoImp();
        sDao.deleteSerie(serie);
        listaSeriesCargadas(serie.getFactura().getNofactura());
        serie = new Serie();
    }

    public void listarSeriesImpresion(String nofactura) {
        if (!nofactura.isEmpty()) {
            SerieDao sDao = new SerieDaoImp();
            listaSeriesImpresion = sDao.listaSeriesImprimir(nofactura);
        }
    }

    public void imprimirEtiquetas() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        this.contador = 0;
        this.noFacturaImpresion = null;
        this.listaSeriesEstado1 = new ArrayList<>();//para  actualizar el estado seleccionar a 0
        int ordenar = 0;
        for (int i = 0; i < listaSeriesImpresion.size(); i++) {
            if (listaSeriesImpresion.get(i).getSeleccionar().equals(TRUE)) {
//                this.etiqueta.generarQR(listaSeriesImpresion.get(i).getSerie(), listaSeriesImpresion.get(i).getFactura().getNofactura(),
//                        listaSeriesImpresion.get(i).getArticulo(), listaSeriesImpresion.get(i).getDescripcion(), listaSeriesImpresion.get(i).getSerie(),
//                        listaSeriesImpresion.get(i).getFactura().getProveedor(), listaSeriesImpresion.get(i).getPedimento(), listaSeriesImpresion.get(i).getAduana(),
//                        listaSeriesImpresion.get(i).getFechapedimento().toString());
                SerieDao sDao = new SerieDaoImp();
                ordenar++;
                sDao.updateNoImpresion(listaSeriesImpresion.get(i).getSerie(), ordenar);
                listaSeriesEstado1.add(listaSeriesImpresion.get(i).getSerie());
                this.noFacturaImpresion = listaSeriesImpresion.get(i).getFactura().getNofactura();

//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE ETIQUETAS", "Etiqueta procesada con serie no: ".concat(listaSeriesImpresion.get(i).getSerie())));
            } else {
                this.contador++;
            }
        }

        //INICIA MÉTODO PARA BUSCAR SERIES PENDIENTES DE IMPRESIÓN Y COLOCAR A TRUE FACTURA PARA QUE NO SE VISUALICE
        FacturaDao fDao = new FacturaDaoImp();
        int consulta = fDao.buscarSeriesPendientes(noFacturaImpresion).size();
        FacturaDao Dao = new FacturaDaoImp();
        int consulta2 = Dao.buscarSeriesEstado2(noFacturaImpresion).size();
        if (consulta == consulta2) {
            FacturaDao actualizar = new FacturaDaoImp();
            actualizar.updateEstadoFactura(noFacturaImpresion);
            //getListarFacturaAlmancen();
        }
        //FIN MÉTODO PARA BUSCAR SERIES PENDIENTES DE IMPRESIÓN Y COLOCAR A TRUE FACTURA PARA QUE NO SE VISUALICE
        listarSeriesImpresion(noFacturaImpresion);
        //**ABRIMOS EL DIALOGO PARA IMPRIMIR**//

        RequestContext.getCurrentInstance().execute("PF('dlgImpresion').show()");
        if (this.contador == listaSeriesImpresion.size()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "Selecciona etiquetas"));
        }
    }

    public void regresarEstadoFalse() {
        String dato = listaSeriesEstado1.toString().replace("[", "").replace("]", "");
        String[] info = dato.split(",");
        for (int i = 0; i < listaSeriesEstado1.size(); i++) {
            SerieDao sDao = new SerieDaoImp();
            sDao.updateSerieEstadoCero(info[i].trim());
        }
        listarSeriesImpresion(noFacturaImpresion);
    }

    public void imprimirQR() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //this.pathReporte="/Report/QRreport.jasper";
        QrPreview reporte = new QrPreview();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Report/QR.jasper");
        reporte.getReporte(ruta, 1);
        FacesContext.getCurrentInstance().responseComplete();
        regresarEstadoFalse();
    }

    //**INICIA GUARDADO DE LAS PARTIDAS-VARIAS TABLAS**//
    public void guardarPartidas() throws MessagingException {
        if (serieEditar.getAduana().isEmpty() && serieEditar.getPedimento().isEmpty() && serieEditar.getLote().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "Campos requeridos"));
        }
        SerieDao sDao = new SerieDaoImp();
        for (int i = 0; i < listarSeries.size(); i++) {
            if (listarSeries.get(i).getSeleccionar().equals(TRUE)) {
                FacturaDao facDao = new FacturaDaoImp();
                invoice.setNofactura(listarSeries.get(i).getFactura().getNofactura());
                this.fact = facDao.returnIdFactura(invoice);
                series.setFactura(fact);
                series.setUsuario(user);
                series.setIdserie(listarSeries.get(i).getIdserie());
                series.setSerie(listarSeries.get(i).getSerie());
                series.setArticulo(listarSeries.get(i).getArticulo());
                series.setDescripcion(listarSeries.get(i).getDescripcion());
                series.setAduana(serieEditar.getAduana());
                series.setPedimento(serieEditar.getPedimento());
                series.setFechapedimento(serieEditar.getFechapedimento());
                series.setLote(serieEditar.getLote());
                series.setImpreso(0);
                series.setSeleccionar(FALSE);
                series.setSae(FALSE);
                //**ACTUALIZAMOS LOS DATOS ADUANA, PEDIMENTO, FECHA Y LOTE EN LA TABLA SERIE**//
                sDao.updateSerie(series);
            }
        }
        //**METODO PARA BUSCAR SERIES PENDIENTES**//
        FacturaDao fDao = new FacturaDaoImp();
        int resultado = fDao.buscarSeriesPendientes(invoice.getNofactura()).size();
        FacturaDao Dao = new FacturaDaoImp();
        int resultado2 = Dao.buscarSeriesInformacionCompleta(invoice.getNofactura()).size();

        if (resultado == resultado2) {
            listaHNSer = new ArrayList<>();
            List<Serie> listado = new ArrayList<>();
            FacturaDao Ldao = new FacturaDaoImp();
            listado = Ldao.buscarSeriesInformacionCompleta(invoice.getNofactura());
            for (int i = 0; i < listado.size(); i++) {
                //**AGREGAMOS LOS DATOS A LA LISTA HNUMSER Y NUMSER**//
                listaHNSer.add(listado.get(i).getSerie());
                listaHNSer.add(listado.get(i).getArticulo());
            }
            //**OBTENEMOS EL MÁXIMO VALOR DE LA TABLA OBS_DOCC01**//
            Obsdocc01Dao obsDao = new Obsdocc01DaoImp();

            //**GUARDAMOS LA INFORMACION DEL CAMPO OBSERVACION EN LA TABLA OBS_DOCC01**//
            Obsdocc01Dao oDao = new Obsdocc01DaoImp();
            String dato = obsDao.obtenerMaximoValor().toString().replace("[", "");
            dato = dato.replace("]", "");
            obsdoc.setCveObs(new Integer(dato));
            obsdoc.setStrObs(fact.getObservacion());
            oDao.saveObservacion(obsdoc);

            //**ACTUALIZAMOS LA TABLA TBLCONTROL01 CAMPO ULT_CVE ID_TABLE=57 CON EL DATO DEL MAXIMO VALOR DE LA TABLA OBS_DOCC01**//
            Tblcontrol01Dao tDao = new Tblcontrol01DaoImpl();
            tDao.updateTblControl(Integer.parseInt(dato));

            Compc01Dao comDao = new Compc01DaoImp();
            String folio = comDao.obtenerMaximoValor().toString().replace("[", "");
            folio = folio.replace("]", "");
            String x = "";
            for (int i = 0; i < (20 - folio.length()); i++) {
                x = x + " ";
            }
            fact.setCvedoc(x.concat(folio));
            fact.setMoneda(factura.getMoneda());
            fact.setTipocambio(factura.getTipocambio());
            fact.setCveobs(obsdoc.getCveObs());
            fDao.updateFactura(fact);

            //**OBTENEMOS LA INFORMACION DEL CAMPO OBSERVACION DE LA TABLA FACTURA**//
            facturaRegistro = new Factura();
            FacturaDao facRegDao = new FacturaDaoImp();
            this.facturaRegistro = facRegDao.returnIdFactura(fact);

            //**GUARDAMOS EN LA TABLA COMPC01**//
            Compc01Dao cDao = new Compc01DaoImp();
            compc.setTipDoc("c");
            compc.setCveClpv(this.facturaRegistro.getIdproveedor());
            compc.setStatus("O");
            compc.setSuRefer(this.facturaRegistro.getNofactura());
            compc.setCveDoc(x.concat(folio));
            compc.setFechaDoc(facturaRegistro.getFecha());
            compc.setFechaRec(facturaRegistro.getFecha());
            compc.setFechaPag(facturaRegistro.getFecha());
            compc.setCanTot(0.0);
            compc.setImpTot1(0.0);
            compc.setImpTot2(0.0);
            compc.setImpTot3(0.0);
            compc.setImpTot4(0.0);
            compc.setDesTot(0.0);
            compc.setDesFin(0.0);
            compc.setTotInd(0.0);
            compc.setObsCond(null);
            compc.setCveObs(this.facturaRegistro.getCveobs());
            compc.setNumAlma(fact.getIdalmacen());
            compc.setActCxp("S");
            compc.setActCoi("N");
            compc.setEnlazado("O");
            compc.setTipDocE("O");
            switch (this.factura.getMoneda()) {
                case "PESOS":
                    valorMoneda = 1;
                    break;
                case "USD":
                    valorMoneda = 2;
                    break;
                case "LIBRAS":
                    valorMoneda = 3;
                    break;
                case "EUROS":
                    valorMoneda = 4;
                    break;
                default:
                    valorMoneda = 5;
                    break;
            }
            compc.setNumMoned(valorMoneda);
            compc.setTipcamb(this.facturaRegistro.getTipocambio());
            compc.setNumPagos(1);
            compc.setFechaelab(this.facturaRegistro.getFecha());
            compc.setSerie("");
            compc.setFolio(Integer.parseInt(folio));
            compc.setCtlpol(0);
            compc.setEscfd("N");
            compc.setContado("N");
            compc.setBloq("N");
            compc.setDesFinPorc(0.0);
            compc.setDesTotPorc(0.0);
            compc.setDesTotPorc(0.0);
            compc.setImporte(0.0);
            cDao.saveComc01(compc);

            //**ACTUALIZAMOS LA TABLA FOLIOSC01 CON ULT_DOC Y FECH_ULT_DOC**//
            Foliosc01Dao folDao = new Foliosc01DaoImp();
            folDao.updateFolio(Integer.parseInt(folio), this.fact.getFecha());

            //**GUARDAMOS EL ÚLTIMO DOCUMENTO EN LA TABLA COMPC_CLIB01**//
            compcclib01.setClaveDoc(x.concat(folio));
            CompcClib01Dao compcClibDao = new CompcClib01DaoImp();
            compcClibDao.saveCompcClib(compcclib01);

            //********************************************//
            //**OBTENEMOS LOS PEDIMENTOS DE LAS SERIES**//
            SerieDao pDao = new SerieDaoImp();
            List<String> listarPedimentos = new ArrayList<>();
            listarPedimentos = pDao.listaPedimentoSerie(user.getIdusuario(), fact.getIdfactura());
            String pedimento = pDao.listaPedimentoSerie(user.getIdusuario(), fact.getIdfactura()).toString().replace("[", "").replace("]", "");
            String[] ped = pedimento.split(",");
            int contarReg = 0;
            for (int h = 0; h < listarPedimentos.size(); h++) {

                //**OBTENEMOS LA LISTA DE LAS SERIES ACTUALIZADAS**//
                SerieDao serRegDao = new SerieDaoImp();
                listaSeriesSaeReg = serRegDao.listarSeriesSaeRegistro(fact.getIdfactura(), ped[h].trim());

                int maximoReg = 0;
                for (int i = 0; i < listaSeriesSaeReg.size(); i++) {
                    //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA LTPD01 DEL CAMPO REG_LTPD**//
                    Ltpd01Dao lDao = new Ltpd01DaoImp();
                    String maxVal = lDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");

                    //**OBTENEMOS EL TOTAL DE LAS SERIES**//
                    String miArt = listaSeriesSaeReg.toString().replace("[", "").replace("]", "");
                    String[] art = miArt.split(",");

                    //**GUARDAMOS EL TOTAL DE LAS SERIES EN LA TABLA LTPD01**//
                    SerieDao serieDao = new SerieDaoImp();
                    String conteo = serieDao.listarSeriesSae(user.getIdusuario(), ped[h].trim(), art[i].trim()).toString().replace("[", "").replace("]", "");
                    lp.setCveArt(art[i].trim());
                    SerieDao loteDao = new SerieDaoImp();
                    lp.setLote(loteDao.listaLote(fact.getIdfactura(), ped[h].trim(), user.getIdusuario(), art[i].trim()).toString().replace("[", "").replace("]", ""));//revisar
                    // lp.setLote(serieEditar.getLote());//revisar
                    lp.setPedimento(ped[h].trim());
                    lp.setCveAlm(this.fact.getIdalmacen());
                    // SerieDao feDao = new SerieDaoImp();
                    lp.setFchaduana(serieEditar.getFechapedimento());//revisar     
                    lp.setFchultmov(serieEditar.getFechapedimento());//revisar

                    SerieDao AdDao = new SerieDaoImp();
                    lp.setNomAduan(AdDao.listaAduana(fact.getIdfactura(), ped[h].trim(), user.getIdusuario(), art[i].trim()).toString().replace("[", "").replace("]", ""));//revisar
                    lp.setCantidad(new Double(conteo));
                    lp.setRegLtpd(Integer.parseInt(maxVal));
                    lp.setCveObs(this.fact.getCveobs());
                    lp.setCiudad("");
                    lp.setFrontera("");
                    lp.setStatus("A");
                    lp.setPedimentosat(ped[h].trim());
                    //lp.setPedimentosat(serieEditar.getPedimento());
                    Ltpd01Dao lpDao = new Ltpd01DaoImp();
                    lpDao.saveLtp01(lp);

                    //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA LTPD01 DEL CAMPO REG_LTPD**//
                    Ltpd01Dao regDao = new Ltpd01DaoImp();
                    String maxReg = regDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");

                    //**ACTUALIZAMOS LA TABLA TBLCONTROL01 CAMPO ULT_CVE='maxVal'-ID_TABLE=48**//
                    Tblcontrol01Dao tablaDao = new Tblcontrol01DaoImpl();
                    tablaDao.updateTablaControl(Integer.parseInt(maxReg));

                    //**OBTENEMOS EL VALOR MAXIMO DE LA TABLA ENLACE_LTPD01**//
                    EnlaceLtpd01Dao eDao = new EnlaceLtpd01DaoImp();
                    String maxRegEnlace = eDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");

                    //**GUARDAMOS EN LA TABLA ENLACE_LTPD01 LOS VALORES EN LOS CAMPOS E_LTPD,REG_LTPD,CANTIDAD,PXRS**//
                    EnlaceLtpd01Dao enDao = new EnlaceLtpd01DaoImp();
                    enlace.seteLtpd(Integer.parseInt(maxRegEnlace));
                    enlace.setRegLtpd(Integer.parseInt(maxReg) - 1);////*******VALOR QUE DEBE LLEVAR
                    enlace.setCantidad(Double.parseDouble(conteo));
                    enlace.setPxrs(Double.parseDouble(conteo));
                    enDao.saveEnlaceLtpd01(enlace);

                    //**ACTUALIZAMOS LA TABLA TBLCONTROL01 SET ULT_CVE = 'MAX(E_LTPD)' WHERE ID_TABLA=67**//
                    Tblcontrol01Dao taDao = new Tblcontrol01DaoImpl();
                    taDao.updateTbl67Control(Integer.parseInt(maxRegEnlace));

                    //**VALIDAMOS EL CONTADOR PARA SUMAR UNO**//
                    if (contarReg > 0) {
                        //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA HNUMSER01**//
                        Hnumser01Dao hDao = new Hnumser01DaoImp();
                        String maxRegHnumser = hDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");
                        maximoReg = Integer.parseInt(maxRegHnumser) + contarReg;
                    } else {
                        //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA HNUMSER01**//
                        Hnumser01Dao hDao = new Hnumser01DaoImp();
                        String maxRegHnumser = hDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");
                        maximoReg = Integer.parseInt(maxRegHnumser);
                    }

                    //**GUARDAMOS EN LA TABLA PAR_COMPC01**//
                    ParCompc01Dao parDao = new ParCompc01Imp();
                    parcompc.setCveDoc(fact.getCvedoc());
                    ParCompc01Dao itemDao = new ParCompc01Imp();
                    String item = itemDao.obtenerMaximoValor(fact.getCvedoc()).toString().replace("[", "").replace("]", "");
                    if (item.contains("null")) {
                        item = "1";
                    }
                    parcompc.setNumPar(Integer.parseInt(item));//buscar el número de partida en la tabla PAR_COMPC01
                    parcompc.setCveArt(art[i].trim());
                    parcompc.setCant(Double.parseDouble(conteo));
                    parcompc.setPxr(Double.parseDouble(conteo));
                    parcompc.setPrec(0.0);
                    parcompc.setCost(0.0);
                    parcompc.setImpu1(0.0);
                    parcompc.setImpu2(0.0);
                    parcompc.setImpu3(0.0);
                    parcompc.setImpu4(0.0);
                    parcompc.setImp1apla(Short.parseShort("0"));
                    parcompc.setImp2apla(Short.parseShort("0"));
                    parcompc.setImp3apla(Short.parseShort("0"));
                    parcompc.setImp4apla(Short.parseShort("0"));
                    parcompc.setTotimp1(0.0);
                    parcompc.setTotimp2(0.0);
                    parcompc.setTotimp3(0.0);
                    parcompc.setTotimp4(0.0);
                    parcompc.setDescu(0.0);
                    parcompc.setActInv("S");
                    parcompc.setTipCam(fact.getTipocambio());
                    parcompc.setUniVenta("PZ");
                    parcompc.setTipoElem("N");
                    parcompc.setTipoProd("P");
                    parcompc.setCveObs(0);
                    parcompc.setRegSerie(maximoReg);////
                    parcompc.setELtpd(Integer.parseInt(maxRegEnlace));
                    parcompc.setFactconv(1.0);
                    parcompc.setCostDev(0.0);
                    parcompc.setNumAlm(fact.getIdalmacen());
                    parcompc.setMindirecto(0.0);
                    //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA MINVE01 DEL CAMPO NUM_MOV**//
                    Minve01Dao mDao = new Minve01DaoImp();
                    String maxValMinve = mDao.obtenerMaximoValor().toString().replace("[", "").replace("]", "");
                    parcompc.setNumMov(Integer.parseInt(maxValMinve));///Colocar el NUM_MOV
                    parcompc.setTotPartida(0.0);
                    parDao.saveParCompc01(parcompc);

                    //**GUARDAMOS EN LA TABLA PAR_COMPC_CLIB01**//
                    ParCompcClib01Dao clibDao = new ParCompcClib01DaoImp();
                    clib01.setClaveDoc(fact.getCvedoc());
                    clib01.setNumPart(Integer.parseInt(item));//colocarl el número de partida
                    clibDao.saveParCompcClib(clib01);
                    //**OBTENEMOS EL MAXIMO VALOR DE LA TABLA MULT01**//
                    Mult01Dao mulDao = new Mult01DaoImp();
                    String maxValMult = mulDao.obtenerMaximoValor(art[i].trim(), fact.getIdalmacen()).toString().replace("[", "").replace("]", "");
                    if (maxValMult.contains("null")) {
                        maxValMult = "0.0";
                    }
                    //**ACTUALIZAMOS EL MAXIMO VALOR EN LA TABLA MULT01 CAMPO EXIST+LA CANTIDAD**//
                    Mult01Dao mult01Dao = new Mult01DaoImp();
                    mult01Dao.updateMult01(art[i].trim(), fact.getIdalmacen(), (Double.parseDouble(conteo) + Double.parseDouble(maxValMult)));

                    Minve01Dao minveDao = new Minve01DaoImp();
                    minve.setCveArt(art[i].trim());
                    minve.setAlmacen(fact.getIdalmacen());
                    minve.setNumMov(Integer.parseInt(maxValMinve));
                    minve.setCveCpto(1);
                    minve.setFechaDocu(fact.getFecha());
                    minve.setTipoDoc("C");
                    minve.setRefer(fact.getCvedoc());
                    minve.setClaveClpv(fact.getIdproveedor());
                    //minve.setVend("");
                    minve.setCant(Double.parseDouble(conteo));
                    minve.setCantCost(1.0);
                    minve.setPrecio(0.0);
                    minve.setCosto(0.0);
                    //minve.setAfecCoi("");
                    minve.setCveObs(fact.getCveobs());
                    minve.setRegSerie(maximoReg);////
                    minve.setUniVenta("PZ");
                    minve.setELtpd(Integer.parseInt(maxRegEnlace));
                    minve.setExistencia((Double.parseDouble(conteo) + Double.parseDouble(maxValMult)));
                    minve.setTipoProd("P");
                    minve.setFactorCon(1.0);
                    minve.setFechaelab(fact.getFecha());
                    //minve.setCtlpol("");
                    //minve.setCveFolio("");
                    minve.setSigno(1);
                    minve.setCosteado("S");
                    minve.setCostoPromIni(0.0);
                    minve.setCostoPromFin(0.0);
                    //minve.setCostoPromGral(0.0);
                    minve.setDesdeInve("N");
                    minve.setMovEnlazado(0);
                    minveDao.saveMinve01(minve);

                    //**OBTENEMOS LA SUMA DE LA TABLA INVE01 CAMPO EXIST**//
                    Inve01Dao sumaDao = new InveDaoImp();
                    String sumaExist = sumaDao.obtenerMaximoValor(art[i].trim()).toString().replace("[", "").replace("]", "");

                    //**ACTUALIZAMOS LA TABLA INVEV01**//
                    Inve01Dao updateDao = new InveDaoImp();
                    updateDao.updateInve01(Double.parseDouble(sumaExist) + (Double.parseDouble(conteo)), art[i].trim());
                    //**GUARDAMOS EN LA TABLA HNUMSER**//

                    conteo = "";
                    maxVal = "";
                    maxReg = "";
                    maxRegEnlace = "";
                    maxValMinve = "";
                    contarReg++;
                }
                //contarReg = 0;
            }
            //**GUARDAMOS EN LA TABLA NUMSER**//

            String listaHN = listaHNSer.toString().replace("[", "").replace("]", "");
            String[] lHN = listaHN.split(",");
            int a = 0;
            int b = 1;
            for (int i = 0; i < listaHNSer.size() / 2; i++) {
                Numser01Dao numserDao = new Numser01DaoImp();
                numser.setCveArt(lHN[b].trim());
                numser.setNumSer(lHN[a].trim());
                numser.setStatus("D");
                numser.setAlmacen(fact.getIdalmacen());
                numser.setCosto(0.0);
                numser.setDoctoEnt("");
                numser.setFechaEnt(fact.getFecha());
                numserDao.saveNumser01(numser);
//                ParCompc01Dao parDao = new ParCompc01Imp();
//                String miReg = parDao.obtenerMaximoValor(fact.getCvedoc(), lHN[b].trim()).toString().replace("[", "").replace("]", "");
//                miReg = miReg.substring(0, 10);
                Hnumser01Dao hnumserDao = new Hnumser01DaoImp();
                hnumser.setCveArt(lHN[b].trim());
                hnumser.setNumSer(lHN[a].trim());
                hnumser.setTipMov(1);
                hnumser.setTipDoc("M");
                hnumser.setCveDoc(fact.getCvedoc());
                hnumser.setAlmacen(fact.getIdalmacen());
                //hnumser.setRegSerie(numreg);
                hnumser.setRegSerie(0);
                hnumser.setFecha(fact.getFecha());
                hnumser.setStatus("D");
                hnumserDao.saveHmunser(hnumser);
                a = a + 2;
                b = b + 2;
            }
            //**GUARDAMOS EN LA TABLA HNUMSER EL REG_SERIE**//

            //**ACTUALIZAMOS EL REG SERIE**//
            PartidasReg partDao = new PartidasReg();
            String misPartComc = partDao.listarPartidas(fact.getCvedoc()).toString().replace("[", "").replace("]", "");
            String[] varPar = misPartComc.split(",");
            int c0 = 0;
            int c1 = 1;
            int c2 = 2;

            PartidasReg seriesDato = new PartidasReg();
            String inv = fact.getCvedoc().replace("[", "").replace("]", "");

            for (int i = 0; i < varPar.length / 3; i++) {
                System.out.println(varPar[c0] + varPar[c1] + varPar[c2]);
                String miRegDatos = seriesDato.listarXSerie(inv, varPar[c0].trim(), varPar[c2].trim()).toString();
                String[] varSer = miRegDatos.split(",");
                int s = 0;
                for (int v = 0; v < varSer.length / 1; v++) {
                    ////////////////////////////////////////////////////////
                    Hnumser01Dao actualizarRegSerie = new Hnumser01DaoImp();
                    actualizarRegSerie.updateHnumserRegSerie(fact.getCvedoc(), varPar[c0].trim(), Integer.parseInt(varPar[c1].trim().replace(".0", "").replace("[", "").replace("]", "")), varSer[s].replace("[", "").replace("]", "").trim());
                    /////////////////////////////////////////////////////
                    s = s + 1;
                }
                c0 = c0 + 3;
                c1 = c1 + 3;
                c2 = c2 + 3;

            }

            //**VALIDAR LA NUEVA CUENTA DE CORREO**//
            //enviarAvisoCompraFinalizada(fact.getCvedoc(), fact.getAlmacen(), user.getCorreo());//ENVIAR CORREO
            //************************************//
            //**ACTUALIZAMOS LA TABLA SERIES CAMPO SAE A 1**//
            SerieDao serDao = new SerieDaoImp();
            List<String> serieSae = null;
            serieSae = serDao.listarSeriesSaeEstado1(user.getIdusuario(), serieEditar.getPedimento());
            for (int j = 0; j < serieSae.size(); j++) {
                serDao.updateSerieSae1(serieSae.get(j).replace("[", "").replace("]", ""));
            }
            //**LIMPIAMOS LOS OBJETOS**//
            compcclib01 = new CompcClib01();
            obsdoc = new ObsDocc01();
            lp = new Ltpd01();
            parcompc = new ParCompc01();
            clib01 = new ParCompcClib01();
            minve = new Minve01();
            listaHNSer.clear();
            numreg = 0;
            numser = new Numser01();
            hnumser = new Hnumser01();

            //********************************************//
            factura = new Factura();
            compc = new Compc01();

        }
        //**METODO PARA BUSCAR SERIES PENDIENTES**//

        listaSerie(invoice.getNofactura());
        serieEditar = new Serie();
        this.valorMoneda = 0;
        RequestContext.getCurrentInstance().update("frmVerSeries:tblSeries");
        RequestContext.getCurrentInstance().update("frmVerSeries:mensajes");

    }
    //**FINALIZA GUARDADO DE LAS PARTIDAS-VARIAS TABLAS**//

    //**INICIA ENVIO DE CORREO**//
    public void enviarAvisoCompraFinalizada(String factura, String almacen, String correo) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.grupocomercialtria.com.mx");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "alertas@grupocomercialtria.com.mx");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
        BodyPart texto = new MimeBodyPart();
        texto.setContent("<html><head><title></title></head>"
                + "<body>"
                + "<table width='678' height='315' border='0' bordercolor='#0000FF' bgcolor='#FFFFFF'>"
                + "<tr>"
                + "<td height='10' colspan='3' bordercolor='#FFFFFF'></td>"
                + "</tr>"
                + "<tr>"
                + "<td colspan='3' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><font color='#086A87'>"
                + "Se ha finalizado la captura de la compra en Sistema SAE: </b> </font><br><br>"
                + "<font color='#086A87'>Compra N°:<b> " + factura + " </b></font><br>"
                + "<font color='#086A87'>Almacén:<b> " + almacen + " </b></font><br>"
                + "<font color='#086A87'>Usuario:<b> " + correo + " </b></font><br>"
                + "</tr>"
                + "<tr>"
                + "<td width='425' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><br><font color='#17202a'>Sistema de Etiquetas | </font><font color='#E60013'>Marubeni M&eacute;xico, S.A. de C.V.</font><br>"
                + "<a href='http://etiquetas.marubeni.com.mx' target='_blank'><img src='cid:image' width='45%'/></a></td>"
                + "<td width='122' bordercolor='#FFFFFF'></td>"
                + "<td width='222' rowspan='2' bordercolor='#FFFFFF'></td>"
                + "</tr>"
                + "<tr>"
                + "<td colspan='2' bordercolor='#17202a'><br><br><p align='center' style='font-family:calibri; font-size:15px'><font color='#086A87'><br> Mensaje enviado desde el Sistema de Etiquetas.</font></p></td>"
                + "</tr>"
                + "</table>"
                + "</body></html>", "text/html");

        MimeMultipart multiParte = new MimeMultipart();
        BodyPart imagen = new MimeBodyPart();
        DataSource fds = new FileDataSource("C:\\img\\marubeni-logo.png");
        imagen.setDataHandler(new DataHandler(fds));
        imagen.setHeader("Content-ID", "<image>");

        multiParte.addBodyPart(texto);
        // multiParte.addBodyPart(adjunto);
        multiParte.addBodyPart(imagen);

        MimeMessage message = new MimeMessage(session);

// Se rellena el From
        message.setFrom(new InternetAddress("alertas@grupocomercialtria.com.mx"));

        message.addRecipients(Message.RecipientType.TO, "BARAJAS-T@marubeni.com");
        message.addRecipients(Message.RecipientType.BCC, "esteban.romero@grupocomercialtria.com.mx");
        message.addRecipients(Message.RecipientType.BCC, "alertas@grupocomercialtria.com.mx");

// Se rellena el subject
        message.setSubject("Sistema de Etiquetas-Compra finalizada");

// Se mete el texto y la foto adjunta.
        message.setContent(multiParte);

        Transport t = session.getTransport("smtp");
        t.connect("alertas@grupocomercialtria.com.mx", "QiVDZ90chqmp");
        t.sendMessage(message, message.getAllRecipients());
        t.close();

    }
    //**FINALIZA ENVIO DE CORREO**//

}
