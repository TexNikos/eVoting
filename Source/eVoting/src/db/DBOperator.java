/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nikos
 */
public class DBOperator {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static boolean active = false;

    public static EntityManager create() {
        
        if (!active) {
            return create("eVotingPU");
        }

        return em;
        
    }

    public static EntityManager create(String pUnitName) {
        
        if (!active) {
            emf = Persistence.createEntityManagerFactory(pUnitName);
            em = emf.createEntityManager();
            active = true;
        }

        return em;
        
    }

    public static void Deactivate() {
        
        active = false;
        em.close();
        emf.close();
        em = null;

    }

}
