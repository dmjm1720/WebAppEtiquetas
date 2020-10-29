package com.etiquetas.qrsys.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

import com.etiquetas.qrsys.encrypt.Mask;
import com.etiquetas.qrsys.e.model.Usuario;
import com.etiquetas.qrsys.util.HibernateUtil;

public class UsuarioDaoImp implements UsuarioDao {

    @Override
    public Usuario obtenerDatos(Usuario usuario) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        String hql = "FROM Usuario WHERE nombre=:nombre";
        Query q = session.createQuery(hql);
        q.setParameter("nombre", usuario.getNombre());
        return (Usuario) q.uniqueResult();
        
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario user = this.obtenerDatos(usuario);
        if (user != null) {
            if (!user.getPassword().equals(Mask.algorithm(usuario.getPassword()))) {
                user = null;
            }
        }
        return user;
    }

    @Override
    public List<Usuario> listaUsuarios() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUsuario(Usuario usuario) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        // TODO Auto-generated method stub

    }

}
