package exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Harriet on 10/16/2019.
 */
@Provider
public class MyApplicationExceptionHandler implements ExceptionMapper<MyApplicationException>
{
    @Override
    public Response toResponse(MyApplicationException exception)
    {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
