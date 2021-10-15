package cn.com.scitc.studentmanager.pojo;

import org.springframework.stereotype.Component;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 班级实体
 * 年级、班级、班主任、总人数
 */
@Component
public class Clazz {
    private Long id;
    private String grade;
    private String clazz;
    private String headTeacher;
    private Integer totalStudent;           //限定总人数
    private Integer currentTotalStudent;    //当前总人数

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(String headTeacher) {
        this.headTeacher = headTeacher;
    }

    public Integer getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(Integer totalStudent) {
        this.totalStudent = totalStudent;
    }

    public Integer getCurrentTotalStudent() {
        return currentTotalStudent;
    }

    public void setCurrentTotalStudent(Integer currentTotalStudent) {
        this.currentTotalStudent = currentTotalStudent;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                ", clazz='" + clazz + '\'' +
                ", headTeacher='" + headTeacher + '\'' +
                ", totalStudent=" + totalStudent +
                ", currentTotalStudent=" + currentTotalStudent +
                '}';
    }
}
