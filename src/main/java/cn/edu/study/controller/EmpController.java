package cn.edu.study.controller;

import cn.edu.study.dao.DepartmentDao;
import cn.edu.study.dao.EmployeeDao;
import cn.edu.study.entities.Department;
import cn.edu.study.entities.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@Api(value = "用户的增删改查")
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmployeeDao empDao;

    @Autowired
    DepartmentDao deptDao;

    @ApiOperation(value = "用户列表", notes="list<user>")
    @GetMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> empList = empDao.getAll();
        model.addAttribute("emps", empList);
        return "emp/list";
    }

    @ApiOperation(value = "部门列表")
    @GetMapping()
    public String toAddPage(Model model){
        Collection<Department> depts = deptDao.getDepartments();
        model.addAttribute("depts", depts);
        return "emp/add";
    }

    @ApiOperation(value = "保存用户")
    @PostMapping()
    public String toEmp(Employee emp){
        empDao.save(emp);
        return "redirect:/emps";
    }

    @ApiOperation(value = "用户详细")
    @GetMapping("/{id}")
    public String toUpdatePage(@PathVariable("id")Integer id, Model model){
        Employee emp = empDao.get(id);
        model.addAttribute("emp", emp);
        Collection<Department> depts = deptDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/set";
    }

    @ApiOperation(value = "修改用户")
    @PutMapping()
    public String updateEmp(Employee emp){
        empDao.save(emp);
        System.out.println(emp);
        return "redirect:/emps";
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        empDao.delete(id);
        return "redirect:/emps";
    }
}
