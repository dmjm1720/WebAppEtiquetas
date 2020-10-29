package com.etiquetas.qrsys.dao;

import java.util.List;

import com.etiquetas.qrsys.e.model.Perfil;

public interface PerfilDao {

    public List<Perfil> listaPerfiles();

    public void savePerfil(Perfil perfil);

    public void updatePerfil(Perfil perfil);

    public void deletePerfil(Perfil perfil);
}
