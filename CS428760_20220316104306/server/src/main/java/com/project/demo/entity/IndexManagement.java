package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *指标管理：(IndexManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "IndexManagement")
public class IndexManagement implements Serializable {

    //IndexManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index_management_id")
    private Integer index_management_id;
    // 教师
    @Basic
    private Integer teacher;
    // 所在院系
    @Basic
    private String department;
    // 课程编号
    @Basic
    private String course_number;
    // 课程名称
    @Basic
    private String course_name;
    // 学生人数
    @Basic
    private String number_of_students;
    // 学生及格率
    @Basic
    private String student_pass_rate;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
