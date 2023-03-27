package com.example.demoToday.controller;
import com.example.demoToday.model.Emp;
import com.example.demoToday.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class EmpControllers {


    @Autowired
    EmpService empService;

    @PostMapping("save")
    public String addUser(@ModelAttribute Emp emps, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return "add_emp/add_emp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        empService.saveEms(emps);
        return "redirect:/list";
    }

    @GetMapping("")
    public String getUsers(Model model) {
        List<Emp> emps = empService.getUser();
        model.addAttribute("userList", emps);
        return "index";
    }

    @GetMapping("ems-form")
    public String AddUserPage(Model model) {
        model.addAttribute("emp", new Emp());
        return "add_emp/add_emp";
    }

    @GetMapping("delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long id) {
        empService.deleteUser(id);
        return "redirect:/list";
    }

    @GetMapping("edit/{userId}")
    public String editUser(@PathVariable("userId") Long id, Model model) {
        Emp user = empService.getUser(id);
        model.addAttribute("emp", user);
        return "add_emp/add_emp";
    }

    @GetMapping("list")
    public String getUser(Model model) {
        List<Emp> emps = empService.getUser();
        model.addAttribute("userList", emps);
        return "index";
    }


}
