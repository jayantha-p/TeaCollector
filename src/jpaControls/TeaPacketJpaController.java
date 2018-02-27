/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControls;

import entity.TeaPacket;
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
public class TeaPacketJpaController implements Serializable {

    public TeaPacketJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TeaPacket teaPacket) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(teaPacket);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TeaPacket teaPacket) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            teaPacket = em.merge(teaPacket);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = teaPacket.getId();
                if (findTeaPacket(id) == null) {
                    throw new NonexistentEntityException("The teaPacket with id " + id + " no longer exists.");
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
            TeaPacket teaPacket;
            try {
                teaPacket = em.getReference(TeaPacket.class, id);
                teaPacket.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The teaPacket with id " + id + " no longer exists.", enfe);
            }
            em.remove(teaPacket);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TeaPacket> findTeaPacketEntities() {
        return findTeaPacketEntities(true, -1, -1);
    }

    public List<TeaPacket> findTeaPacketEntities(int maxResults, int firstResult) {
        return findTeaPacketEntities(false, maxResults, firstResult);
    }

    private List<TeaPacket> findTeaPacketEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TeaPacket.class));
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

    public TeaPacket findTeaPacket(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TeaPacket.class, id);
        } finally {
            em.close();
        }
    }

    public int getTeaPacketCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TeaPacket> rt = cq.from(TeaPacket.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
