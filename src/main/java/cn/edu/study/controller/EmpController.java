package cn.edu.study.controller;

import cn.edu.study.dao.DepartmentDao;
import cn.edu.study.dao.EmployeeDao;
import cn.edu.study.entities.Department;
import cn.edu.study.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    EmployeeDao empDao;

    @Autowired
    DepartmentDao deptDao;

    @GetMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> empList = empDao.getAll();
        model.addAttribute("emps", empList);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> depts = deptDao.getDepartments();
        model.addAttribute("depts", depts);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String toEmp(Employee emp){
        empDao.save(emp);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id")Integer id, Model model){
        Employee emp = empDao.get(id);
        model.addAttribute("emp", emp);
        Collection<Department> depts = deptDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/set";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee emp){
        empDao.save(emp);
        System.out.println(emp);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        empDao.delete(id);
        return "redirect:/emps";
    }
}
