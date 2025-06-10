package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *评价打分：(EvaluationAndScoring)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EvaluationAndScoring")
public class EvaluationAndScoring implements Serializable {

    //EvaluationAndScoring编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_and_scoring_id")
    private Integer evaluation_and_scoring_id;
    // 学生
    @Basic
    private Integer student;
    // 姓名
    @Basic
    private String full_name;
    // 专业
    @Basic
    private String major;
    // 学期
    @Basic
    private String semester;
    // 所在院系
    @Basic
    private String department;
    // 课程编号
    @Basic
    private String course_number;
    // 课程名称
    @Basic
    private String course_name;
    // 任课教师
    @Basic
    private String teacher;
    // 学生评价
    @Basic
    private String student_evaluation;
    // 学生打分
    @Basic
    private String student_scoring;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
