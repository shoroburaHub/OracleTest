package com.oracle.test.service;

import com.oracle.test.entity.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@DataBaseDataStore
public class DbDataStore implements DataStore {

    @PersistenceContext(unitName="primary")
    private EntityManager em;

    public DbDataStore() {
    }
    public DbDataStore(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Category> findAllCategory() {
        return em.createNamedQuery("Category.findAll", Category.class).getResultList();
    }

    @Override
    public int allCategoriesCount() {
        return ((Number) em.createNamedQuery("Category.findAllCount").getSingleResult()).intValue();
    }

    @Override
    public List<Question> allQuestions() {
        return em.createNamedQuery("Question.findAll", Question.class).getResultList();
    }

    @Override
    public List<Question> findQuestions(final Subcategory cat) {
        final List<Question> list = em.createNamedQuery("Question.findBySubcategoryAndLimit", Question.class)
                .setParameter("subCategory", cat)
                .getResultList();
        return list;
    }

    @Override
    public List<User> allUsers() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    @Override
    public User getUser(final String username) {
        final List<User> list = em.createNamedQuery("User.findByName", User.class)
                .setParameter("name", username)
                .getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public <T extends BaseEntity> void persist(final T entity) {
        em.persist(entity);
    }

    @Override
    public void flush() {
        em.flush();
    }
}
