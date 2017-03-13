/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedmethods;

import dbentity.Candidate;
import dbentity.ElectoralPeriphery;
import dbentity.Vote;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nikos
 */
public class CastVote implements Runnable {

    private final ElectoralPeriphery ep;
    private final float voteChance;
    private final float blankChance;
    private final float invalidChance;

    public CastVote(ElectoralPeriphery ep, float voteChance, float blankChance, float invalidChance) {
        this.ep = ep;
        this.voteChance = voteChance;
        this.blankChance = blankChance;
        this.invalidChance = invalidChance;
    }

    @Override
    public void run() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eVotingPU");
        EntityManager em = emf.createEntityManager();

        Random rand = new Random(LocalTime.now().toNanoOfDay());
        List<Candidate> candies = (List<Candidate>) ep.getCandidateCollection();
        int j = 0;

        em.getTransaction().begin();

        for (int i = 0; i < (ep.getFldRegisteredCitizensCount() / 1000); i++) {
            j++;
            if (rand.nextFloat() < voteChance) {

                if (rand.nextFloat() < blankChance) {
                    Vote v = new Vote();
                    v.setFldIsBlank(true);
                    v.setFldIsInvalid(false);
                    v.setFkElectoralPeripheryId(ep);
                    em.persist(v);
                    if (j == 100000) {
                        em.getTransaction().commit();
                        em.getTransaction().begin();
                        j = 0;
                    }
                } else if (rand.nextFloat() < invalidChance) {
                    Vote v = new Vote();
                    v.setFldIsInvalid(true);
                    v.setFldIsBlank(false);
                    v.setFkElectoralPeripheryId(ep);
                    em.persist(v);
                    if (j == 100000) {
                        em.getTransaction().commit();
                        em.getTransaction().begin();
                        j = 0;
                    }
                } else {
                    Vote v = new Vote();
                    v.setFldIsInvalid(false);
                    v.setFldIsBlank(false);
                    Candidate votedCandi = candies.get(rand.nextInt(candies.size()));
                    v.setFkCandidateId(votedCandi);
                    v.setFkElectoralPeripheryId(ep);
                    v.setFkPoliticalPartyId(votedCandi.getFkPoliticalPartyId());
                    em.persist(v);
                    if (j == 100000) {
                        em.getTransaction().commit();
                        em.getTransaction().begin();
                        j = 0;
                    }
                }

            }

        }

        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
