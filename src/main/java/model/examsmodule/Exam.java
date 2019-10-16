package model.examsmodule;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Harriet on 10/4/2019.
 */
@Entity
@Table(name = "tbl_exams")
@NamedQueries({
        @NamedQuery(name = "NQ_EXAMS_FIND_ALL",
                query = "SELECT e from Exam e"),
        @NamedQuery(name = "NQ_EXAMS_FIND_BY_EXAM_TYPE",
                query = "SELECT  e from Exam e where e.examType=:examType"),

})
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private ExamType examType;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Nairobi")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Nairobi")
    private Date endDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examType=" + examType +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
