package bean;

import com.google.gson.JsonParser;
import model.examsmodule.ExamResult;
import utilities.Util;


import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Harriet on 10/4/2019.
 */
@Local
@Stateless
public class ExamResultBean extends Bean<ExamResult> implements ExamResultBeanI {
    @PostConstruct
    public void init() {
        this.entityClass = ExamResult.class;
    }

    @Override
    public ExamResult add(ExamResult examResult) {
        return super.add(examResult);
    }

    @Override
    public List<ExamResult> findAll() {
        List<ExamResult> results = this.entityManager
                .createNamedQuery("NQ_RESULTS_FIND_ALL")
                .getResultList();
        return results;

    }

    @Override
    public List<ExamResult> findResultByRegistrationNumber(String registrationNumber) {
        String json = new Util().getStudentByRegistrationNumber(registrationNumber, "exam-api/students/findByRegistrationNumber");
        if(json!=null) {
            long id = new JsonParser().parse(json).getAsJsonObject().get("id").getAsLong();
            return this.entityManager
                    .createNamedQuery("NQ_FIND_STUDENT_RESULTS")
                    .setParameter("studentId", id)
                    .getResultList();
        }
        return null;
    }
    @Override
    public BigDecimal findStudentTotalMarks(String registrationNumber) {
        String student = new Util().getStudentByRegistrationNumber(registrationNumber,"exam-api/students/findByRegistrationNumber");
        long id = new JsonParser().parse(student).getAsJsonObject().get("id").getAsLong();
        BigDecimal totalMarks = (BigDecimal) entityManager
                .createNamedQuery("NQ_TOTAL_STUDENT_RESULT")
                .setParameter("studentId", id)
                .getSingleResult();
        return totalMarks;
    }
}
