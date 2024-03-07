package com.example.springboot.thymleafdemo.Controller;

import com.example.springboot.thymleafdemo.Service.EmployeeService;
import com.example.springboot.thymleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listStudents(Model theModel){
        //get the employee from db
        List<Employee> theEmployees = employeeService.findAll();

        System.out.println(theEmployees);
        //add to the spring model
        theModel.addAttribute("employees",theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model theModel){
        //create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel){
        //get the employee from the service
        Optional<Employee> theEmployee = employeeService.findById(theId);
        //set employee in the model to prepopulate the form
        theModel.addAttribute("employee",theEmployee);
        //send over to our form

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        //save the employee
        employeeService.save(theEmployee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){

        //delete the employee
        employeeService.delete(theId);
        //redirect to the /employee/list
        return "redirect:/employees/list";
    }
}
