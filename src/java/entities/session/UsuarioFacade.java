/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.session;

import entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import security.Encrypt;

/**
 *
 * @author BuRr0X
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "BomberAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario login(String userName, String password) {
        Usuario usuario = null;
        try {
            Query query = getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.usuName = :usuario AND u.usuPassword = :contrasena");
            query.setParameter("usuario", userName);
            query.setParameter("contrasena", Encrypt.getStringMessageDigest(password));
            usuario = (Usuario) query.getSingleResult();
        } catch (NoResultException nre) {
            System.out.println("\n======================= No se encontro el usuario ======================");
        }
        return usuario;
    }

}
