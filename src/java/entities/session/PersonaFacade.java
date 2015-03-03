/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.session;

import entities.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> {
    @PersistenceContext(unitName = "BomberAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    //Vamos a obtener todas las personas 
    public List<Persona> getPersonas(){
        List<Persona> personas =new ArrayList();
        try{
            Query query = em.createNamedQuery("Persona.findAll");
            personas  = query.getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
            return null;                
        }
        return personas;
    }
           
}
