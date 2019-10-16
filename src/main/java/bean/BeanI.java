package bean;

import javax.ejb.Local;

/**
 * Created by Harriet on 10/4/2019.
 */
@Local
public interface BeanI   <T> {

    T add(T t);
    T edit(T t);
    T findById(long id);
    boolean delete(T t);
}
