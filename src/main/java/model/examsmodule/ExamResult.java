package model.examsmodule;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Harriet on 10/4/2019.
 */
@Entity
@Table(name = "tbl_exam_results")
@NamedQueries({
        @NamedQuery(name = "NQ_RESULTS_FIND_ALL",
                query = "select r from ExamResult  r"),
        @NamedQuery(name = "NQ_FIND_STUDENT_RESULTS",
                query = "select r from ExamResult r where r.studentId=:studentId"),
        @NamedQuery(name = "NQ_FIND_EXAM_RESULT",
                query = "select r from ExamResult r where r.exam=:examId"),
        @NamedQuery(name = "NQ_TOTAL_STUDENT_RESULT",
                query = "select sum(r.marks) from ExamResult r where r.studentId=:studentId")})

public class ExamResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "student_id")
    private long studentId;
    private long unitId;
    @OneToOne
    private Exam exam;
    private BigDecimal marks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public BigDecimal getMarks() {
        return marks;
    }

    public void setMarks(BigDecimal marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", unitId=" + unitId +
                ", exam=" + exam +
                ", marks=" + marks +
                '}';
    }
}