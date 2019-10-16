package bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * Created by Harriet on 10/4/2019.
 */
@Local
@Stateless
public class Bean<T> implements BeanI<T> {
    @PersistenceContext(unitName = "school")
    protected EntityManager entityManager;
    protected   Class<T> entityClass;

    @Override
    public T add(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T edit(T t) {

        try {
            entityManager.merge(t);
            return t;
        } catch (PersistenceException ex) {
            return null;

        }
    }

    @Override
    public T findById(long id) {
        return entityManager.find(entityClass,id);

    }


    @Override
    public boolean delete(T t) {
        try {
            entityManager.remove(t);
            return true;
        } catch (PersistenceException ex) {
            return false;
        }
    }
}
