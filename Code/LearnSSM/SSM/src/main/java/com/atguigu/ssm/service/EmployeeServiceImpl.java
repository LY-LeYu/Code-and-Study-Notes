package com.atguigu.ssm.service;

import com.atguigu.ssm.mapper.EmployeeMapper;
import com.atguigu.ssm.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Employee> list = employeeMapper.getAllEmployee();
        PageInfo<Employee> employeePageInfo = new PageInfo<>(list, 5);
        return  employeePageInfo;
    }
}
