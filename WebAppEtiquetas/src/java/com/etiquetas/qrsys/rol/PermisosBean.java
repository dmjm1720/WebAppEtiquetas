package com.etiquetas.qrsys.rol;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.etiquetas.qrsys.e.model.Usuario;

@Named(value = "permisosBean")
@ViewScoped

public class PermisosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private MenuModel model;

    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    public PermisosBean() {

    }

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        // Inicia perfil administrador
        switch (us.getPerfil().getIdperfil()) {
            case 1: {
                //**PERFIL ADMINISTRADOR**//
                // Primer submenu
                DefaultSubMenu primerSubmenu = new DefaultSubMenu("INICIO");
                DefaultMenuItem item = new DefaultMenuItem("Inicio");
                item.setOutcome("/Views/Home.jsf");
                item.setIcon("ui-icon-home");
                primerSubmenu.addElement(item);
                model.addElement(primerSubmenu);
                // Segundo submenu
                DefaultSubMenu segundoSubmenu = new DefaultSubMenu("ARCHIVO");
                item = new DefaultMenuItem("Cargar Excel");
                item.setIcon("ui-icon-disk");
                item.setOutcome("/Views/Home.jsf");
                segundoSubmenu.addElement(item);
                model.addElement(segundoSubmenu);
                // Segundo submenu
                DefaultSubMenu septimoSubmenu = new DefaultSubMenu("REGISTRAR");
                item = new DefaultMenuItem("Registrar compra");
                item.setIcon("ui-icon-disk");
                item.setOutcome("/Views/Register.jsf");
                septimoSubmenu.addElement(item);
                model.addElement(septimoSubmenu);
                // Tercer submenu
                break;
            }
            case 2: {
                //**PERFIL USUARIO**//
                // Primer submenu
                DefaultSubMenu primerSubmenu = new DefaultSubMenu("INICIO");
                DefaultMenuItem item = new DefaultMenuItem("Inicio");
                item.setOutcome("/Views/Home.jsf");//////////////////////////////////
                item.setIcon("ui-icon-home");
                primerSubmenu.addElement(item);
                model.addElement(primerSubmenu);
                // Segundo submenu
                DefaultSubMenu septimoSubmenu = new DefaultSubMenu("REGISTRAR");
                item = new DefaultMenuItem("Registrar series");
                item.setIcon("ui-icon-disk");
                item.setOutcome("/Views/Sae.jsf");
                septimoSubmenu.addElement(item);
                model.addElement(septimoSubmenu);
                // Tercer submenu
                DefaultSubMenu tercerSubmenu = new DefaultSubMenu("IMPRIMIR ETIQUETAS");
                item = new DefaultMenuItem("Compras");
                item.setIcon("ui-icon-print");
                item.setOutcome("/Views/Compras.jsf");
                tercerSubmenu.addElement(item);
                item = new DefaultMenuItem("Movs-Entrada");
                item.setIcon("ui-icon-print");
                item.setOutcome("/Views/Entrada.jsf");
                tercerSubmenu.addElement(item);
                item = new DefaultMenuItem("Movs-Salida");
                item.setIcon("ui-icon-print");
                item.setOutcome("/Views/Salida.jsf");
                tercerSubmenu.addElement(item);
                item = new DefaultMenuItem("Ventas");
                item.setIcon("ui-icon-print");
                item.setOutcome("/Views/Ventas.jsf");
                tercerSubmenu.addElement(item);
                model.addElement(tercerSubmenu);

                break;
            }
            case 3: {
                // Primer submenu
                DefaultSubMenu primerSubmenu = new DefaultSubMenu("INICIO");
                DefaultMenuItem item = new DefaultMenuItem("Inicio");
                item.setOutcome("/Views/Home.jsf");
                item.setIcon("ui-icon-home");
                primerSubmenu.addElement(item);
                model.addElement(primerSubmenu);
                // Segundo submenu
                DefaultSubMenu segundoSubmenu = new DefaultSubMenu("ARCHIVO");
                item = new DefaultMenuItem("Cargar Excel");
                item.setIcon("ui-icon-disk");
                item.setOutcome("/Views/Home.jsf");
                segundoSubmenu.addElement(item);
                model.addElement(segundoSubmenu);
                // Segundo submenu
                DefaultSubMenu septimoSubmenu = new DefaultSubMenu("REGISTRAR");
                item = new DefaultMenuItem("Registrar series");
                item.setIcon("ui-icon-disk");
                item.setOutcome("/Views/Sae.jsf");
                septimoSubmenu.addElement(item);
                item = new DefaultMenuItem("Registrar compra");
                item.setIcon("ui-icon-disk");
                item.setOutcome("/Views/Register.jsf");
                septimoSubmenu.addElement(item);
                model.addElement(septimoSubmenu);
                // Tercer submenu
                DefaultSubMenu tercerSubmenu = new DefaultSubMenu("IMPRIMIR ETIQUETAS");
                item = new DefaultMenuItem("Compras");
                item.setIcon("ui-icon-print");
                item.setOutcome("/Views/Compras.jsf");
                tercerSubmenu.addElement(item);
                item = new DefaultMenuItem("Movs-Entrada");
                item.setIcon("ui-icon-print");
                item.setOutcome("/Views/Entrada.jsf");
                tercerSubmenu.addElement(item);
                item = new DefaultMenuItem("Movs-Salida");
                item.setIcon("ui-icon-print");
                item.setOutcome("/Views/Salida.jsf");
                tercerSubmenu.addElement(item);
                item = new DefaultMenuItem("Ventas");
                item.setIcon("ui-icon-print");
                item.setOutcome("/Views/Ventas.jsf");
                tercerSubmenu.addElement(item);
                model.addElement(tercerSubmenu);

                // Quinto submenu
                DefaultSubMenu sextoSubmenu = new DefaultSubMenu("USUARIOS");
                item = new DefaultMenuItem("Usuarios");
                item.setIcon("ui-icon-disk");
                item.setOutcome("/Views/Usuarios.jsf");
                sextoSubmenu.addElement(item);
                model.addElement(sextoSubmenu);
                // Finaliza perfil administrador
                break;
            }
            case 4: {
                // Quinto submenu
                DefaultSubMenu etiquetasMenu = new DefaultSubMenu("ADMIN");
                DefaultMenuItem item = new DefaultMenuItem("Etiquetas");
                item.setIcon("ui-icon-disk");
                item.setOutcome("/Views/adm.jsf");
                etiquetasMenu.addElement(item);
                model.addElement(etiquetasMenu);
                // Finaliza perfil administrador
                break;
            }
            default:
                break;
        }

    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
