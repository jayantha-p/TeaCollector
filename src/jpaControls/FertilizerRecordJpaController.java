/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControls;

import entity.FertilizerRecord;
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
public class FertilizerRecordJpaController implements Serializable {

    public FertilizerRecordJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FertilizerRecord fertilizerRecord) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier supplierId = fertilizerRecord.getSupplierId();
            if (supplierId != null) {
                supplierId = em.getReference(supplierId.getClass(), supplierId.getId());
                fertilizerRecord.setSupplierId(supplierId);
            }
            em.persist(fertilizerRecord);
            if (supplierId != null) {
                supplierId.getFertilizerRecordCollection().add(fertilizerRecord);
                supplierId = em.merge(supplierId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FertilizerRecord fertilizerRecord) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FertilizerRecord persistentFertilizerRecord = em.find(FertilizerRecord.class, fertilizerRecord.getId());
            Supplier supplierIdOld = persistentFertilizerRecord.getSupplierId();
            Supplier supplierIdNew = fertilizerRecord.getSupplierId();
            if (supplierIdNew != null) {
                supplierIdNew = em.getReference(supplierIdNew.getClass(), supplierIdNew.getId());
                fertilizerRecord.setSupplierId(supplierIdNew);
            }
            fertilizerRecord = em.merge(fertilizerRecord);
            if (supplierIdOld != null && !supplierIdOld.equals(supplierIdNew)) {
                supplierIdOld.getFertilizerRecordCollection().remove(fertilizerRecord);
                supplierIdOld = em.merge(supplierIdOld);
            }
            if (supplierIdNew != null && !supplierIdNew.equals(supplierIdOld)) {
                supplierIdNew.getFertilizerRecordCollection().add(fertilizerRecord);
                supplierIdNew = em.merge(supplierIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = fertilizerRecord.getId();
                if (findFertilizerRecord(id) == null) {
                    throw new NonexistentEntityException("The fertilizerRecord with id " + id + " no longer exists.");
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
            FertilizerRecord fertilizerRecord;
            try {
                fertilizerRecord = em.getReference(FertilizerRecord.class, id);
                fertilizerRecord.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fertilizerRecord with id " + id + " no longer exists.", enfe);
            }
            Supplier supplierId = fertilizerRecord.getSupplierId();
            if (supplierId != null) {
                supplierId.getFertilizerRecordCollection().remove(fertilizerRecord);
                supplierId = em.merge(supplierId);
            }
            em.remove(fertilizerRecord);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FertilizerRecord> findFertilizerRecordEntities() {
        return findFertilizerRecordEntities(true, -1, -1);
    }

    public List<FertilizerRecord> findFertilizerRecordEntities(int maxResults, int firstResult) {
        return findFertilizerRecordEntities(false, maxResults, firstResult);
    }

    private List<FertilizerRecord> findFertilizerRecordEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FertilizerRecord.class));
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

    public FertilizerRecord findFertilizerRecord(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FertilizerRecord.class, id);
        } finally {
            em.close();
        }
    }

    public int getFertilizerRecordCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FertilizerRecord> rt = cq.from(FertilizerRecord.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
