package exception;

import java.io.Serializable;

/**
 * Created by Harriet on 10/16/2019.
 */
public class MyApplicationException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public MyApplicationException() {
        super();
    }
    public MyApplicationException(String msg)   {
        super(msg);
    }
    public MyApplicationException(String msg, Exception e)  {
        super(msg, e);
    }
}
