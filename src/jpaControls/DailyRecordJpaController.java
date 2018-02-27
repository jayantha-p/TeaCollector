/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControls;

import entity.DailyRecord;
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
public class DailyRecordJpaController implements Serializable {

    public DailyRecordJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DailyRecord dailyRecord) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier supplierID = dailyRecord.getSupplierID();
            if (supplierID != null) {
                supplierID = em.getReference(supplierID.getClass(), supplierID.getId());
                dailyRecord.setSupplierID(supplierID);
            }
            em.persist(dailyRecord);
            if (supplierID != null) {
                supplierID.getDailyRecordCollection().add(dailyRecord);
                supplierID = em.merge(supplierID);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DailyRecord dailyRecord) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DailyRecord persistentDailyRecord = em.find(DailyRecord.class, dailyRecord.getRecordID());
            Supplier supplierIDOld = persistentDailyRecord.getSupplierID();
            Supplier supplierIDNew = dailyRecord.getSupplierID();
            if (supplierIDNew != null) {
                supplierIDNew = em.getReference(supplierIDNew.getClass(), supplierIDNew.getId());
                dailyRecord.setSupplierID(supplierIDNew);
            }
            dailyRecord = em.merge(dailyRecord);
            if (supplierIDOld != null && !supplierIDOld.equals(supplierIDNew)) {
                supplierIDOld.getDailyRecordCollection().remove(dailyRecord);
                supplierIDOld = em.merge(supplierIDOld);
            }
            if (supplierIDNew != null && !supplierIDNew.equals(supplierIDOld)) {
                supplierIDNew.getDailyRecordCollection().add(dailyRecord);
                supplierIDNew = em.merge(supplierIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dailyRecord.getRecordID();
                if (findDailyRecord(id) == null) {
                    throw new NonexistentEntityException("The dailyRecord with id " + id + " no longer exists.");
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
            DailyRecord dailyRecord;
            try {
                dailyRecord = em.getReference(DailyRecord.class, id);
                dailyRecord.getRecordID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dailyRecord with id " + id + " no longer exists.", enfe);
            }
            Supplier supplierID = dailyRecord.getSupplierID();
            if (supplierID != null) {
                supplierID.getDailyRecordCollection().remove(dailyRecord);
                supplierID = em.merge(supplierID);
            }
            em.remove(dailyRecord);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DailyRecord> findDailyRecordEntities() {
        return findDailyRecordEntities(true, -1, -1);
    }

    public List<DailyRecord> findDailyRecordEntities(int maxResults, int firstResult) {
        return findDailyRecordEntities(false, maxResults, firstResult);
    }

    private List<DailyRecord> findDailyRecordEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DailyRecord.class));
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

    public DailyRecord findDailyRecord(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DailyRecord.class, id);
        } finally {
            em.close();
        }
    }

    public int getDailyRecordCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DailyRecord> rt = cq.from(DailyRecord.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
