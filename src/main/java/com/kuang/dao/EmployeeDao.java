package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 员工Dao
@Repository
public class EmployeeDao {

    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    // 员工所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer,Employee>(); //创建一个部门表
        employees.put(1001,new Employee(  1001,"AA","1622840727@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(  1002,"BB","2622840727@qq.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(  1003,"CC","4622840727@qq.com",1,new Department(103,"教研部")));
        employees.put(1004,new Employee(  1004,"DD","5628440727@qq.com",0,new Department(104,"运营部")));
        employees.put(1005,new Employee(  1005,"FF","6022840727@qq.com",1,new Department(105,"后勤部")));

    }

    // 模拟自增主键
    private static Integer initId = 1006;

    // 增加一个员工
    public void save(Employee employee) {
        if(employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getId()));
        employees.put(employee.getId(),employee);
    }

    // 查询所有员工
    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public void deleteById(Integer id){
        employees.remove(id);
    }

}
