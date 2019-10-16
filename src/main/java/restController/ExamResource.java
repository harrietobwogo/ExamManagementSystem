package restController;

import bean.ExamBeanI;
import com.google.gson.Gson;
import exception.MyApplicationException;
import model.examsmodule.Exam;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 * Created by Harriet on 10/7/2019.
 */
@Path("/exam")
public class ExamResource {
    Logger log= Logger.getLogger(ExamResource.class);
    /**
     * injecting ExamBeanI interface
     */
    @EJB
    private ExamBeanI examBeanI;

    /**
     * Adding an exam Record
     * @param json
     * @return json representation of added record with the assigned ID
     */
    @POST
    @Path("/add-exam")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addExam(String json) throws MyApplicationException {
        log.info("Get API called for json object:"+json);
        Exam exam = new Gson().fromJson(json, Exam.class);
        System.out.println(new Gson().toJson(exam));
        exam = examBeanI.add(exam);
        return Response.ok().entity(exam).build();
    }

    /**
     *
     * @return list of all existing exam records
     */
    @GET
    @Path("/list-exams")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findExam() throws MyApplicationException {
        return Response.ok().entity(examBeanI.findAllExams()).build();
    }

    /**
     * Get a list of exam records using the exam type
     * @param examType
     * @return
     */
    @GET
    @Path("/{examType}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findExamByType(@PathParam("examType") String examType) throws MyApplicationException{
        log.info("Get API called for exam list:"+examType);
        return Response.ok().entity(examBeanI.findByExamType(examType)).build();
    }

    /**
     * Update an existing exam Record
     * @param json
     * @return
     */
    @PUT
    @Path("/update-exam")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateExam(String json) throws MyApplicationException {
        Exam exam = new Gson().fromJson(json, Exam.class);
        System.out.println(new Gson().toJson(exam));
        exam = examBeanI.edit(exam);
        return Response.ok().entity(exam).build();
    }

    /**
     * Delete an existing exam record
     * @param json
     * @return
     */

    @DELETE
    @Path("/delete-exam")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteExam(String json) throws MyApplicationException {
        Exam exam = new Gson().fromJson(json, Exam.class);
        return Response.ok().entity(examBeanI.delete(exam)).build();
    }
}
