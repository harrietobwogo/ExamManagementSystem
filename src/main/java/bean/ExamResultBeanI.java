package bean;

import model.examsmodule.Exam;
import model.examsmodule.ExamResult;


import javax.ejb.Local;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Harriet on 10/4/2019.
 */
@Local
public interface ExamResultBeanI extends BeanI<ExamResult>  {
    List<ExamResult> findAll();
    List<ExamResult> findResultByRegistrationNumber(String registrationNumber);
    BigDecimal findStudentTotalMarks(String registrationNumber);

}
