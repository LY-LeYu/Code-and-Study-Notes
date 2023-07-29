package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        List<Employee> list = employeeServiceImpl.getAllEmployee();
        model.addAttribute("list", list);
        return "employee_list";
    }

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(Model model,@PathVariable("pageNum") Integer pageNum){
        PageInfo<Employee> page = employeeServiceImpl.getEmployeePage(pageNum);
        model.addAttribute("page", page);
        return "employee_list";

    }

}
