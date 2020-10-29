package com.etiquetas.qrsys.dao;

import java.util.List;

import com.etiquetas.qrsys.e.model.Usuario;

public interface UsuarioDao {

    public Usuario obtenerDatos(Usuario usuario);

    public Usuario login(Usuario usuario);

    public List<Usuario> listaUsuarios();

    public void saveUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);

    public void deleteUsuario(Usuario usuario);

}
