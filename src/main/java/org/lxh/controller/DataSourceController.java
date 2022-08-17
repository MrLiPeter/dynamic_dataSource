package org.lxh.controller;

import org.lxh.dataSource.DataSourceName;

import org.lxh.model.User;
import org.lxh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.List;

@RestController
public class DataSourceController {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceController.class);

    @Autowired
    UserService userService;

    /**
     * modify dataSource
     * @param dsName
     */
    @PostMapping("/dsName")
    public void setDsType(String dsName, HttpSession session){
        //put dataSourceInfo in session
        session.setAttribute(DataSourceName.DS_SESSION_KEY,dsName);
        logger.info("数据源切换为:{}",dsName);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
