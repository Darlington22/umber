/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.umber.service;

import com.ernest.umber.entity.EntityModel;
import com.ernest.umber.entity.UserAccount;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Darlington
 */
@Stateless
public class UmberService {

    @PersistenceContext(name = "com.ernest_umber_war_1.0-SNAPSHOTPU")
    EntityManager em;
    
    public Boolean delete(EntityModel information) {
        try {
            information.setDeleted(Boolean.TRUE);
            em.merge(information);
            em.flush();
            em.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> t, Object id) {
        try {

            if (em == null) {
                return null;
            }
            return (T) em.find(t, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public <T> T save(Object model) {
        try {
            return saveEntity(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T save(EntityModel model) {

        try {
            if (model.getId() == null) {
                em.persist(model);
            } else if (find(model.getClass(), model.getId()) != null) {
                em.merge(model);
            } else {
                em.persist(model);
            }

            em.flush();

            return (T) model;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public <T> T saveEntity(Object object) {

        em.merge(object);
        em.flush();

        return (T) object;
    }

    public List findAll(Class t) {
        try {
            String qry = "SELECT e FROM " + t.getSimpleName() + " e"
                    + " WHERE e.deleted =:deleted";
            return em.createQuery(qry).setParameter("deleted", false).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.EMPTY_LIST;
    }
    
    public Optional<UserAccount> findUserByEmail(String email){
        try {
            String qry = "SELECT e FROM " + UserAccount.class.getSimpleName() + " e"
                    + " WHERE e.deleted =:deleted "
                    + " AND e.emailAddress =:emailAddress ";
            System.out.println(qry);
            return em.createQuery(qry)
                    .setParameter("deleted", false)
                    .setParameter("emailAddress", email)
                    .getResultList().stream().findFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
