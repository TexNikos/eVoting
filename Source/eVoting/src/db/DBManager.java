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
public class DBManager {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static boolean active = false;

    public static void create() {

        if (!active) {
            create("eVotingPU");
        }

    }

    public static void create(String pUnitName) {

        if (!active) {
            emf = Persistence.createEntityManagerFactory(pUnitName);
            em = emf.createEntityManager();
            active = true;
        }
    }

    public static EntityManager em() {
        return em;
    }

    public static void destroy() {
        if (active) {
            active = false;
            em.close();
            emf.close();
            em = null;
        }
    }

}
