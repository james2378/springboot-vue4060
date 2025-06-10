package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *教师评分统计：(TeacherScoreStatistics)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "TeacherScoreStatistics")
public class TeacherScoreStatistics implements Serializable {

    //TeacherScoreStatistics编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_score_statistics_id")
    private Integer teacher_score_statistics_id;
    // 教师姓名
    @Basic
    private String teacher_name;
    // 教师得分
    @Basic
    private String teacher_score;
    // 统计人
    @Basic
    private String statistician;
    // 备注
    @Basic
    private String remarks;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
