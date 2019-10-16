package restController;


import bean.ExamResultBeanI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import exception.MyApplicationException;
import model.examsmodule.Exam;
import model.examsmodule.ExamResult;
import org.glassfish.jersey.internal.inject.Custom;
import org.jboss.logging.Logger;
import utilities.Util;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

/**
 * Created by Harriet on 10/7/2019.
 */
@Path("/results")
public class ExamResultResource {

    Logger logger=Logger.getLogger(ExamResultResource.class);
    @EJB
    private ExamResultBeanI examResultBeanI;

    /**
     * assign a student exam results
     *
     * @param json
     * @return
     */
    @POST
    @Path("/add-exam-result")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addExamResult(String json) throws MyApplicationException {
        logger.info("Get API called for Json object:"+json);
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(null);
        customResponse.setMessage("empty");
        customResponse.setStatus(false);
        try {
            if (json != null) {
                JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
                String registrationNumber = jsonObject.get("registrationNumber").getAsString();
                String unitCode = jsonObject.get("unitCode").getAsString();
                JsonObject examObject = jsonObject.get("exam").getAsJsonObject();
                BigDecimal marks = jsonObject.get("marks").getAsBigDecimal();
                Exam exam = new Gson().fromJson(examObject.toString(), Exam.class);
                String student = new Util()
                        .getStudentByRegistrationNumber(
                                registrationNumber,
                                "api/students/findStudentByRegistrationNumber"
                        );


                String unit = new Util()
                        .getUnitByUnitCode(unitCode,
                                "api/units/findUnitByUnitCode");
                if (student != null && unit != null) {
                    long id = new JsonParser()
                            .parse(student)
                            .getAsJsonObject()
                            .get("id")
                            .getAsLong();
                    long unit_id = new JsonParser()
                            .parse(unit)
                            .getAsJsonObject()
                            .get("id")
                            .getAsLong();
                    ExamResult examResult = new ExamResult();
                    examResult.setExam(exam);
                    examResult.setUnitId(unit_id);
                    examResult.setStudentId(id);
                    examResult.setMarks(marks);
                    customResponse.setData(examResultBeanI.add(examResult));
                    customResponse.setMessage("OK");
                    customResponse.setStatus(true);
                    return Response.ok().entity(examResult).build();

                }

            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }


        return Response.ok().entity(customResponse).build();
    }

    /**
     * @return a list of available exam results
     */
    @GET
    @Path("/list-exam-results")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showExamResults() throws MyApplicationException {
        return Response.ok().entity(examResultBeanI.findAll()).build();
    }

    /**
     * @param json
     * @return
     */
    @POST
    @Path("/student-results")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStudentResult(String json) throws MyApplicationException{
        if(json==null){
            throw new MyApplicationException("No record found");
        }
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(null);
        customResponse.setMessage("Record does not exist");
        customResponse.setStatus(false);
        try {
            if (json != null) {
                JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
                String registrationNumber = jsonObject.get("registrationNumber").getAsString();

                    customResponse.setData(examResultBeanI.findResultByRegistrationNumber(registrationNumber));
                    customResponse.setMessage("OK");
                    customResponse.setStatus(true);
                    return Response.ok().entity(customResponse).build();



            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        return Response.ok().entity(customResponse).build();
    }

    @PUT
    @Path("/update-exam-result")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateExamResult(String json) throws MyApplicationException {
        if(json==null){
            throw new MyApplicationException("Record doesnot match existing one");
        }
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(null);
        customResponse.setMessage("Record Not found");
        customResponse.setStatus(false);
        try {
            if (json != null) {
                JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
                String registrationNumber = jsonObject.get("registrationNumber").getAsString();
                String unitCode = jsonObject.get("unitCode").getAsString();
                JsonObject examObject = jsonObject.get("exam").getAsJsonObject();
                BigDecimal marks = jsonObject.get("marks").getAsBigDecimal();
                Exam exam = new Gson().fromJson(examObject.toString(), Exam.class);
                String student = new Util()
                        .getStudentByRegistrationNumber(
                                registrationNumber,
                                "api/students/findStudentByRegistrationNumber"
                        );


                String unit = new Util()
                        .getUnitByUnitCode(unitCode,
                                "api/units/findUnitByUnitCode");
                if (student != null && unit != null) {
                    long id = new JsonParser()
                            .parse(student)
                            .getAsJsonObject()
                            .get("id")
                            .getAsLong();
                    long unit_id = new JsonParser()
                            .parse(unit)
                            .getAsJsonObject()
                            .get("id")
                            .getAsLong();
                    ExamResult examResult = new ExamResult();
                    examResult.setExam(exam);
                    examResult.setUnitId(unit_id);
                    examResult.setStudentId(id);
                    examResult.setMarks(marks);
                    customResponse.setData(examResultBeanI.add(examResult));
                    customResponse.setMessage("OK");
                    customResponse.setStatus(true);
                    return Response.ok().entity(examResult).build();

                }

            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }


        return Response.ok().entity(customResponse).build();
    }
}