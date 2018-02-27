/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControls;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.DailyRecord;
import java.util.ArrayList;
import java.util.Collection;
import entity.Advance;
import entity.TeaPacket;
import entity.FertilizerRecord;
import entity.Supplier;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpaControls.exceptions.IllegalOrphanException;
import jpaControls.exceptions.NonexistentEntityException;

/**
 *
 * @author jayantha
 */
public class SupplierJpaController implements Serializable {

    public SupplierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Supplier supplier) {
        if (supplier.getDailyRecordCollection() == null) {
            supplier.setDailyRecordCollection(new ArrayList<DailyRecord>());
        }
        if (supplier.getAdvanceCollection() == null) {
            supplier.setAdvanceCollection(new ArrayList<Advance>());
        }
        if (supplier.getTeaPacketCollection() == null) {
            supplier.setTeaPacketCollection(new ArrayList<TeaPacket>());
        }
        if (supplier.getFertilizerRecordCollection() == null) {
            supplier.setFertilizerRecordCollection(new ArrayList<FertilizerRecord>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<DailyRecord> attachedDailyRecordCollection = new ArrayList<DailyRecord>();
            for (DailyRecord dailyRecordCollectionDailyRecordToAttach : supplier.getDailyRecordCollection()) {
                dailyRecordCollectionDailyRecordToAttach = em.getReference(dailyRecordCollectionDailyRecordToAttach.getClass(), dailyRecordCollectionDailyRecordToAttach.getRecordID());
                attachedDailyRecordCollection.add(dailyRecordCollectionDailyRecordToAttach);
            }
            supplier.setDailyRecordCollection(attachedDailyRecordCollection);
            Collection<Advance> attachedAdvanceCollection = new ArrayList<Advance>();
            for (Advance advanceCollectionAdvanceToAttach : supplier.getAdvanceCollection()) {
                advanceCollectionAdvanceToAttach = em.getReference(advanceCollectionAdvanceToAttach.getClass(), advanceCollectionAdvanceToAttach.getAdvId());
                attachedAdvanceCollection.add(advanceCollectionAdvanceToAttach);
            }
            supplier.setAdvanceCollection(attachedAdvanceCollection);
            Collection<TeaPacket> attachedTeaPacketCollection = new ArrayList<TeaPacket>();
            for (TeaPacket teaPacketCollectionTeaPacketToAttach : supplier.getTeaPacketCollection()) {
                teaPacketCollectionTeaPacketToAttach = em.getReference(teaPacketCollectionTeaPacketToAttach.getClass(), teaPacketCollectionTeaPacketToAttach.getId());
                attachedTeaPacketCollection.add(teaPacketCollectionTeaPacketToAttach);
            }
            supplier.setTeaPacketCollection(attachedTeaPacketCollection);
            Collection<FertilizerRecord> attachedFertilizerRecordCollection = new ArrayList<FertilizerRecord>();
            for (FertilizerRecord fertilizerRecordCollectionFertilizerRecordToAttach : supplier.getFertilizerRecordCollection()) {
                fertilizerRecordCollectionFertilizerRecordToAttach = em.getReference(fertilizerRecordCollectionFertilizerRecordToAttach.getClass(), fertilizerRecordCollectionFertilizerRecordToAttach.getId());
                attachedFertilizerRecordCollection.add(fertilizerRecordCollectionFertilizerRecordToAttach);
            }
            supplier.setFertilizerRecordCollection(attachedFertilizerRecordCollection);
            em.persist(supplier);
            for (DailyRecord dailyRecordCollectionDailyRecord : supplier.getDailyRecordCollection()) {
                Supplier oldSupplierIDOfDailyRecordCollectionDailyRecord = dailyRecordCollectionDailyRecord.getSupplierID();
                dailyRecordCollectionDailyRecord.setSupplierID(supplier);
                dailyRecordCollectionDailyRecord = em.merge(dailyRecordCollectionDailyRecord);
                if (oldSupplierIDOfDailyRecordCollectionDailyRecord != null) {
                    oldSupplierIDOfDailyRecordCollectionDailyRecord.getDailyRecordCollection().remove(dailyRecordCollectionDailyRecord);
                    oldSupplierIDOfDailyRecordCollectionDailyRecord = em.merge(oldSupplierIDOfDailyRecordCollectionDailyRecord);
                }
            }
            for (Advance advanceCollectionAdvance : supplier.getAdvanceCollection()) {
                Supplier oldSupplierIDOfAdvanceCollectionAdvance = advanceCollectionAdvance.getSupplierID();
                advanceCollectionAdvance.setSupplierID(supplier);
                advanceCollectionAdvance = em.merge(advanceCollectionAdvance);
                if (oldSupplierIDOfAdvanceCollectionAdvance != null) {
                    oldSupplierIDOfAdvanceCollectionAdvance.getAdvanceCollection().remove(advanceCollectionAdvance);
                    oldSupplierIDOfAdvanceCollectionAdvance = em.merge(oldSupplierIDOfAdvanceCollectionAdvance);
                }
            }
            for (TeaPacket teaPacketCollectionTeaPacket : supplier.getTeaPacketCollection()) {
                Supplier oldSupplierIdOfTeaPacketCollectionTeaPacket = teaPacketCollectionTeaPacket.getSupplierId();
                teaPacketCollectionTeaPacket.setSupplierId(supplier);
                teaPacketCollectionTeaPacket = em.merge(teaPacketCollectionTeaPacket);
                if (oldSupplierIdOfTeaPacketCollectionTeaPacket != null) {
                    oldSupplierIdOfTeaPacketCollectionTeaPacket.getTeaPacketCollection().remove(teaPacketCollectionTeaPacket);
                    oldSupplierIdOfTeaPacketCollectionTeaPacket = em.merge(oldSupplierIdOfTeaPacketCollectionTeaPacket);
                }
            }
            for (FertilizerRecord fertilizerRecordCollectionFertilizerRecord : supplier.getFertilizerRecordCollection()) {
                Supplier oldSupplierIdOfFertilizerRecordCollectionFertilizerRecord = fertilizerRecordCollectionFertilizerRecord.getSupplierId();
                fertilizerRecordCollectionFertilizerRecord.setSupplierId(supplier);
                fertilizerRecordCollectionFertilizerRecord = em.merge(fertilizerRecordCollectionFertilizerRecord);
                if (oldSupplierIdOfFertilizerRecordCollectionFertilizerRecord != null) {
                    oldSupplierIdOfFertilizerRecordCollectionFertilizerRecord.getFertilizerRecordCollection().remove(fertilizerRecordCollectionFertilizerRecord);
                    oldSupplierIdOfFertilizerRecordCollectionFertilizerRecord = em.merge(oldSupplierIdOfFertilizerRecordCollectionFertilizerRecord);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Supplier supplier) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier persistentSupplier = em.find(Supplier.class, supplier.getId());
            Collection<DailyRecord> dailyRecordCollectionOld = persistentSupplier.getDailyRecordCollection();
            Collection<DailyRecord> dailyRecordCollectionNew = supplier.getDailyRecordCollection();
            Collection<Advance> advanceCollectionOld = persistentSupplier.getAdvanceCollection();
            Collection<Advance> advanceCollectionNew = supplier.getAdvanceCollection();
            Collection<TeaPacket> teaPacketCollectionOld = persistentSupplier.getTeaPacketCollection();
            Collection<TeaPacket> teaPacketCollectionNew = supplier.getTeaPacketCollection();
            Collection<FertilizerRecord> fertilizerRecordCollectionOld = persistentSupplier.getFertilizerRecordCollection();
            Collection<FertilizerRecord> fertilizerRecordCollectionNew = supplier.getFertilizerRecordCollection();
            List<String> illegalOrphanMessages = null;
            for (DailyRecord dailyRecordCollectionOldDailyRecord : dailyRecordCollectionOld) {
                if (!dailyRecordCollectionNew.contains(dailyRecordCollectionOldDailyRecord)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DailyRecord " + dailyRecordCollectionOldDailyRecord + " since its supplierID field is not nullable.");
                }
            }
            for (Advance advanceCollectionOldAdvance : advanceCollectionOld) {
                if (!advanceCollectionNew.contains(advanceCollectionOldAdvance)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Advance " + advanceCollectionOldAdvance + " since its supplierID field is not nullable.");
                }
            }
            for (TeaPacket teaPacketCollectionOldTeaPacket : teaPacketCollectionOld) {
                if (!teaPacketCollectionNew.contains(teaPacketCollectionOldTeaPacket)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TeaPacket " + teaPacketCollectionOldTeaPacket + " since its supplierId field is not nullable.");
                }
            }
            for (FertilizerRecord fertilizerRecordCollectionOldFertilizerRecord : fertilizerRecordCollectionOld) {
                if (!fertilizerRecordCollectionNew.contains(fertilizerRecordCollectionOldFertilizerRecord)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain FertilizerRecord " + fertilizerRecordCollectionOldFertilizerRecord + " since its supplierId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<DailyRecord> attachedDailyRecordCollectionNew = new ArrayList<DailyRecord>();
            for (DailyRecord dailyRecordCollectionNewDailyRecordToAttach : dailyRecordCollectionNew) {
                dailyRecordCollectionNewDailyRecordToAttach = em.getReference(dailyRecordCollectionNewDailyRecordToAttach.getClass(), dailyRecordCollectionNewDailyRecordToAttach.getRecordID());
                attachedDailyRecordCollectionNew.add(dailyRecordCollectionNewDailyRecordToAttach);
            }
            dailyRecordCollectionNew = attachedDailyRecordCollectionNew;
            supplier.setDailyRecordCollection(dailyRecordCollectionNew);
            Collection<Advance> attachedAdvanceCollectionNew = new ArrayList<Advance>();
            for (Advance advanceCollectionNewAdvanceToAttach : advanceCollectionNew) {
                advanceCollectionNewAdvanceToAttach = em.getReference(advanceCollectionNewAdvanceToAttach.getClass(), advanceCollectionNewAdvanceToAttach.getAdvId());
                attachedAdvanceCollectionNew.add(advanceCollectionNewAdvanceToAttach);
            }
            advanceCollectionNew = attachedAdvanceCollectionNew;
            supplier.setAdvanceCollection(advanceCollectionNew);
            Collection<TeaPacket> attachedTeaPacketCollectionNew = new ArrayList<TeaPacket>();
            for (TeaPacket teaPacketCollectionNewTeaPacketToAttach : teaPacketCollectionNew) {
                teaPacketCollectionNewTeaPacketToAttach = em.getReference(teaPacketCollectionNewTeaPacketToAttach.getClass(), teaPacketCollectionNewTeaPacketToAttach.getId());
                attachedTeaPacketCollectionNew.add(teaPacketCollectionNewTeaPacketToAttach);
            }
            teaPacketCollectionNew = attachedTeaPacketCollectionNew;
            supplier.setTeaPacketCollection(teaPacketCollectionNew);
            Collection<FertilizerRecord> attachedFertilizerRecordCollectionNew = new ArrayList<FertilizerRecord>();
            for (FertilizerRecord fertilizerRecordCollectionNewFertilizerRecordToAttach : fertilizerRecordCollectionNew) {
                fertilizerRecordCollectionNewFertilizerRecordToAttach = em.getReference(fertilizerRecordCollectionNewFertilizerRecordToAttach.getClass(), fertilizerRecordCollectionNewFertilizerRecordToAttach.getId());
                attachedFertilizerRecordCollectionNew.add(fertilizerRecordCollectionNewFertilizerRecordToAttach);
            }
            fertilizerRecordCollectionNew = attachedFertilizerRecordCollectionNew;
            supplier.setFertilizerRecordCollection(fertilizerRecordCollectionNew);
            supplier = em.merge(supplier);
            for (DailyRecord dailyRecordCollectionNewDailyRecord : dailyRecordCollectionNew) {
                if (!dailyRecordCollectionOld.contains(dailyRecordCollectionNewDailyRecord)) {
                    Supplier oldSupplierIDOfDailyRecordCollectionNewDailyRecord = dailyRecordCollectionNewDailyRecord.getSupplierID();
                    dailyRecordCollectionNewDailyRecord.setSupplierID(supplier);
                    dailyRecordCollectionNewDailyRecord = em.merge(dailyRecordCollectionNewDailyRecord);
                    if (oldSupplierIDOfDailyRecordCollectionNewDailyRecord != null && !oldSupplierIDOfDailyRecordCollectionNewDailyRecord.equals(supplier)) {
                        oldSupplierIDOfDailyRecordCollectionNewDailyRecord.getDailyRecordCollection().remove(dailyRecordCollectionNewDailyRecord);
                        oldSupplierIDOfDailyRecordCollectionNewDailyRecord = em.merge(oldSupplierIDOfDailyRecordCollectionNewDailyRecord);
                    }
                }
            }
            for (Advance advanceCollectionNewAdvance : advanceCollectionNew) {
                if (!advanceCollectionOld.contains(advanceCollectionNewAdvance)) {
                    Supplier oldSupplierIDOfAdvanceCollectionNewAdvance = advanceCollectionNewAdvance.getSupplierID();
                    advanceCollectionNewAdvance.setSupplierID(supplier);
                    advanceCollectionNewAdvance = em.merge(advanceCollectionNewAdvance);
                    if (oldSupplierIDOfAdvanceCollectionNewAdvance != null && !oldSupplierIDOfAdvanceCollectionNewAdvance.equals(supplier)) {
                        oldSupplierIDOfAdvanceCollectionNewAdvance.getAdvanceCollection().remove(advanceCollectionNewAdvance);
                        oldSupplierIDOfAdvanceCollectionNewAdvance = em.merge(oldSupplierIDOfAdvanceCollectionNewAdvance);
                    }
                }
            }
            for (TeaPacket teaPacketCollectionNewTeaPacket : teaPacketCollectionNew) {
                if (!teaPacketCollectionOld.contains(teaPacketCollectionNewTeaPacket)) {
                    Supplier oldSupplierIdOfTeaPacketCollectionNewTeaPacket = teaPacketCollectionNewTeaPacket.getSupplierId();
                    teaPacketCollectionNewTeaPacket.setSupplierId(supplier);
                    teaPacketCollectionNewTeaPacket = em.merge(teaPacketCollectionNewTeaPacket);
                    if (oldSupplierIdOfTeaPacketCollectionNewTeaPacket != null && !oldSupplierIdOfTeaPacketCollectionNewTeaPacket.equals(supplier)) {
                        oldSupplierIdOfTeaPacketCollectionNewTeaPacket.getTeaPacketCollection().remove(teaPacketCollectionNewTeaPacket);
                        oldSupplierIdOfTeaPacketCollectionNewTeaPacket = em.merge(oldSupplierIdOfTeaPacketCollectionNewTeaPacket);
                    }
                }
            }
            for (FertilizerRecord fertilizerRecordCollectionNewFertilizerRecord : fertilizerRecordCollectionNew) {
                if (!fertilizerRecordCollectionOld.contains(fertilizerRecordCollectionNewFertilizerRecord)) {
                    Supplier oldSupplierIdOfFertilizerRecordCollectionNewFertilizerRecord = fertilizerRecordCollectionNewFertilizerRecord.getSupplierId();
                    fertilizerRecordCollectionNewFertilizerRecord.setSupplierId(supplier);
                    fertilizerRecordCollectionNewFertilizerRecord = em.merge(fertilizerRecordCollectionNewFertilizerRecord);
                    if (oldSupplierIdOfFertilizerRecordCollectionNewFertilizerRecord != null && !oldSupplierIdOfFertilizerRecordCollectionNewFertilizerRecord.equals(supplier)) {
                        oldSupplierIdOfFertilizerRecordCollectionNewFertilizerRecord.getFertilizerRecordCollection().remove(fertilizerRecordCollectionNewFertilizerRecord);
                        oldSupplierIdOfFertilizerRecordCollectionNewFertilizerRecord = em.merge(oldSupplierIdOfFertilizerRecordCollectionNewFertilizerRecord);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = supplier.getId();
                if (findSupplier(id) == null) {
                    throw new NonexistentEntityException("The supplier with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier supplier;
            try {
                supplier = em.getReference(Supplier.class, id);
                supplier.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The supplier with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DailyRecord> dailyRecordCollectionOrphanCheck = supplier.getDailyRecordCollection();
            for (DailyRecord dailyRecordCollectionOrphanCheckDailyRecord : dailyRecordCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Supplier (" + supplier + ") cannot be destroyed since the DailyRecord " + dailyRecordCollectionOrphanCheckDailyRecord + " in its dailyRecordCollection field has a non-nullable supplierID field.");
            }
            Collection<Advance> advanceCollectionOrphanCheck = supplier.getAdvanceCollection();
            for (Advance advanceCollectionOrphanCheckAdvance : advanceCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Supplier (" + supplier + ") cannot be destroyed since the Advance " + advanceCollectionOrphanCheckAdvance + " in its advanceCollection field has a non-nullable supplierID field.");
            }
            Collection<TeaPacket> teaPacketCollectionOrphanCheck = supplier.getTeaPacketCollection();
            for (TeaPacket teaPacketCollectionOrphanCheckTeaPacket : teaPacketCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Supplier (" + supplier + ") cannot be destroyed since the TeaPacket " + teaPacketCollectionOrphanCheckTeaPacket + " in its teaPacketCollection field has a non-nullable supplierId field.");
            }
            Collection<FertilizerRecord> fertilizerRecordCollectionOrphanCheck = supplier.getFertilizerRecordCollection();
            for (FertilizerRecord fertilizerRecordCollectionOrphanCheckFertilizerRecord : fertilizerRecordCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Supplier (" + supplier + ") cannot be destroyed since the FertilizerRecord " + fertilizerRecordCollectionOrphanCheckFertilizerRecord + " in its fertilizerRecordCollection field has a non-nullable supplierId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(supplier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Supplier> findSupplierEntities() {
        return findSupplierEntities(true, -1, -1);
    }

    public List<Supplier> findSupplierEntities(int maxResults, int firstResult) {
        return findSupplierEntities(false, maxResults, firstResult);
    }

    private List<Supplier> findSupplierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Supplier.class));
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

    public Supplier findSupplier(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Supplier.class, id);
        } finally {
            em.close();
        }
    }

    public int getSupplierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Supplier> rt = cq.from(Supplier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
