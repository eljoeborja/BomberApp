/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.session;

import entities.Departamento;
import entities.Municipio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author BuRr0X
 */
@Stateless
public class MunicipioFacade extends AbstractFacade<Municipio> {
    @PersistenceContext(unitName = "BomberAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }

    public List<Municipio> getMunicipiosByDepartamento(Departamento departamento){
        List<Municipio> municipios = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT m FROM Municipio m WHERE m.munDepCodigo.depCodigo= :dep");
            query.setParameter("dep", departamento.getDepCodigo());
            municipios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return municipios;
    }
}
