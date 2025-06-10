package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *评教信息：(TeachingEvaluationInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "TeachingEvaluationInformation")
public class TeachingEvaluationInformation implements Serializable {

    //TeachingEvaluationInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teaching_evaluation_information_id")
    private Integer teaching_evaluation_information_id;
    // 学期
    @Basic
    private String semester;
    // 所在院系
    @Basic
    private String department;
    // 任课教师
    @Basic
    private String teacher;
    // 课程名称
    @Basic
    private String course_name;
    // 课程编号
    @Basic
    private String course_number;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
