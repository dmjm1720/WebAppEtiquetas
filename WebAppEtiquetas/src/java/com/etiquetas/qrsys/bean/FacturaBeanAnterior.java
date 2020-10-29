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
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;

@Named(value = "facturaBeanAnterior")
@ViewScoped
public class FacturaBeanAnterior implements Serializable {

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
    Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    public FacturaBeanAnterior() {
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
            SelectItem tcambio = new SelectItem(moned01.getTcambio());
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
        //**OBTENEMOS EL MÁXIMO VALOR DE LA TABLA OBS_DOCC01**//
        Obsdocc01Dao obsDao = new Obsdocc01DaoImp();

        //**GUARDAMOS LA INFORMACION DEL CAMPO OBSERVACION EN LA TABLA OBS_DOCC01**//
        Obsdocc01Dao oDao = new Obsdocc01DaoImp();
        String dato = obsDao.obtenerMaximoValor().toString().replace("[", "");
        dato = dato.replace("]", "");
        obsdoc.setCveObs(new Integer(dato));
        //obsdoc.setStrObs(this.facturaObservacion.getObservacion());
        obsdoc.setStrObs(factura.getObservacion());
        oDao.saveObservacion(obsdoc);

        //**ACTUALIZAMOS LA TABLA TBLCONTROL01 CAMPO ULT_CVE ID_TABLE=57 CON EL DATO DEL MAXIMO VALOR DE LA TABLA OBS_DOCC01**//
        Tblcontrol01Dao tDao = new Tblcontrol01DaoImpl();
        tDao.updateTblControl(Integer.parseInt(dato));

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
        factura.setCveobs(Integer.parseInt(dato));
        Compc01Dao comDao = new Compc01DaoImp();
        String folio = comDao.obtenerMaximoValor().toString().replace("[", "");
        folio = folio.replace("]", "");
        String x = "";
        for (int i = 0; i < (20 - folio.length()); i++) {
            x = x + " ";
        }
        factura.setCvedoc(x.concat(folio));
        fDao.updateFactura(factura);
        
        //**OBTENEMOS LA INFORMACION DEL CAMPO OBSERVACION DE LA TABLA FACTURA**//
        facturaRegistro = new Factura();
        FacturaDao facRegDao = new FacturaDaoImp();
        this.facturaRegistro = facRegDao.returnIdFactura(factura);

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
        compc.setNumAlma(Integer.parseInt(codAlm[1]));
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
        folDao.updateFolio(Integer.parseInt(folio), this.facturaObservacion.getFecha());

        //**GUARDAMOS EL ÚLTIMO DOCUMENTO EN LA TABLA COMPC_CLIB01**//
        compcclib01.setClaveDoc(x.concat(folio));
        CompcClib01Dao compcClibDao = new CompcClib01DaoImp();
        compcClibDao.saveCompcClib(compcclib01);

        factura = new Factura();
        compc = new Compc01();
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

    public void procesar() {
        if (serieEditar.getAduana().isEmpty() && serieEditar.getPedimento().isEmpty() && serieEditar.getLote().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "Campos requeridos"));
        }
        SerieDao sDao = new SerieDaoImp();
        listaHNSer = new ArrayList<>();
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
                listaHNSer.add(listarSeries.get(i).getSerie());
                listaHNSer.add(listarSeries.get(i).getArticulo());
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
                parcompc.setRegSerie(Integer.parseInt(maxRegHnumser)+i);
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
                minve.setRegSerie(Integer.parseInt(maxRegHnumser)+i);
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
            ParCompc01Dao parDao = new ParCompc01Imp();
            //String miReg=parDao.obtenerMaximoValor(facturaObservacion.getCvedoc(),lHN[b].trim()).toString().replace("[", "").replace("]", "");
            //miReg = miReg.substring(0, 10);
            Hnumser01Dao hnumserDao = new Hnumser01DaoImp();
            hnumser.setCveArt(lHN[b].trim());
            hnumser.setNumSer(lHN[a].trim());
            hnumser.setTipMov(1);
            hnumser.setTipDoc("M");
            hnumser.setCveDoc(facturaObservacion.getCvedoc());
            hnumser.setAlmacen(facturaObservacion.getIdalmacen());
            //hnumser.setRegSerie(numreg);
           // hnumser.setRegSerie(Integer.parseInt(miReg));
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

}
