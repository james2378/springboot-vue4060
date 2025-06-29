package com.project.demo.controller;

import com.project.demo.entity.TeacherScoreStatistics;
import com.project.demo.service.TeacherScoreStatisticsService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *教师评分统计：(TeacherScoreStatistics)表控制层
 *
 */
@RestController
@RequestMapping("/teacher_score_statistics")
public class TeacherScoreStatisticsController extends BaseController<TeacherScoreStatistics,TeacherScoreStatisticsService> {

    /**
     *教师评分统计对象
     */
    @Autowired
    public TeacherScoreStatisticsController(TeacherScoreStatisticsService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
