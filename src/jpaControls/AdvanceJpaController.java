/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControls;

import entity.Advance;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Supplier;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpaControls.exceptions.NonexistentEntityException;

/**
 *
 * @author jayantha
 */
public class AdvanceJpaController implements Serializable {

    public AdvanceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Advance advance) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier supplierID = advance.getSupplierID();
            if (supplierID != null) {
                supplierID = em.getReference(supplierID.getClass(), supplierID.getId());
                advance.setSupplierID(supplierID);
            }
            em.persist(advance);
            if (supplierID != null) {
                supplierID.getAdvanceCollection().add(advance);
                supplierID = em.merge(supplierID);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Advance advance) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Advance persistentAdvance = em.find(Advance.class, advance.getAdvId());
            Supplier supplierIDOld = persistentAdvance.getSupplierID();
            Supplier supplierIDNew = advance.getSupplierID();
            if (supplierIDNew != null) {
                supplierIDNew = em.getReference(supplierIDNew.getClass(), supplierIDNew.getId());
                advance.setSupplierID(supplierIDNew);
            }
            advance = em.merge(advance);
            if (supplierIDOld != null && !supplierIDOld.equals(supplierIDNew)) {
                supplierIDOld.getAdvanceCollection().remove(advance);
                supplierIDOld = em.merge(supplierIDOld);
            }
            if (supplierIDNew != null && !supplierIDNew.equals(supplierIDOld)) {
                supplierIDNew.getAdvanceCollection().add(advance);
                supplierIDNew = em.merge(supplierIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = advance.getAdvId();
                if (findAdvance(id) == null) {
                    throw new NonexistentEntityException("The advance with id " + id + " no longer exists.");
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
            Advance advance;
            try {
                advance = em.getReference(Advance.class, id);
                advance.getAdvId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The advance with id " + id + " no longer exists.", enfe);
            }
            Supplier supplierID = advance.getSupplierID();
            if (supplierID != null) {
                supplierID.getAdvanceCollection().remove(advance);
                supplierID = em.merge(supplierID);
            }
            em.remove(advance);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Advance> findAdvanceEntities() {
        return findAdvanceEntities(true, -1, -1);
    }

    public List<Advance> findAdvanceEntities(int maxResults, int firstResult) {
        return findAdvanceEntities(false, maxResults, firstResult);
    }

    private List<Advance> findAdvanceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Advance.class));
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

    public Advance findAdvance(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Advance.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdvanceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Advance> rt = cq.from(Advance.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
