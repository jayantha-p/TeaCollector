/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControls;

import entity.Fertilizer;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpaControls.exceptions.NonexistentEntityException;

/**
 *
 * @author jayantha
 */
public class FertilizerJpaController implements Serializable {

    public FertilizerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fertilizer fertilizer) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(fertilizer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Fertilizer fertilizer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            fertilizer = em.merge(fertilizer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = fertilizer.getId();
                if (findFertilizer(id) == null) {
                    throw new NonexistentEntityException("The fertilizer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fertilizer fertilizer;
            try {
                fertilizer = em.getReference(Fertilizer.class, id);
                fertilizer.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fertilizer with id " + id + " no longer exists.", enfe);
            }
            em.remove(fertilizer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fertilizer> findFertilizerEntities() {
        return findFertilizerEntities(true, -1, -1);
    }

    public List<Fertilizer> findFertilizerEntities(int maxResults, int firstResult) {
        return findFertilizerEntities(false, maxResults, firstResult);
    }

    private List<Fertilizer> findFertilizerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fertilizer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Fertilizer findFertilizer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fertilizer.class, id);
        } finally {
            em.close();
        }
    }

    public int getFertilizerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fertilizer> rt = cq.from(Fertilizer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
