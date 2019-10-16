package bean;

import model.examsmodule.Exam;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Harriet on 10/4/2019.
 */
@Local
public interface ExamBeanI extends BeanI<Exam> {
    List<Exam> findAllExams();
    List<Exam> findByExamType(String examType);

}
