package bean;

import model.examsmodule.Exam;
import model.examsmodule.ExamType;
import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harriet on 10/4/2019.
 */
@Local
@Stateless
public class ExamBean extends Bean<Exam> implements ExamBeanI {

    @PostConstruct
    public void init() {
        this.entityClass = Exam.class;
    }


    @Override
    public List<Exam> findAllExams() {
        List<Exam> exams = this.entityManager
                .createNamedQuery("NQ_EXAMS_FIND_ALL")
                .getResultList();
        return exams;
    }

    @Override
    public List<Exam> findByExamType(String examType) {
        ExamType exam = ExamType.valueOf(examType);

        List<Exam> examList=this.entityManager
                        .createNamedQuery("NQ_EXAMS_FIND_BY_EXAM_TYPE")
                        .setParameter("examType", exam)
                        .getResultList();

    return examList.size()>0?examList:null;
    }


}
