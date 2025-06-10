package com.project.demo.controller;

import com.project.demo.entity.IndexManagement;
import com.project.demo.service.IndexManagementService;
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
 *指标管理：(IndexManagement)表控制层
 *
 */
@RestController
@RequestMapping("/index_management")
public class IndexManagementController extends BaseController<IndexManagement,IndexManagementService> {

    /**
     *指标管理对象
     */
    @Autowired
    public IndexManagementController(IndexManagementService service) {
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
