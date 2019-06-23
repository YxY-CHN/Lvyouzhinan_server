package com.yuxuyi.lvyouzhinan.web;

import com.yuxuyi.lvyouzhinan.entity.Admin;
import com.yuxuyi.lvyouzhinan.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired(required = false)
    AdminMapper adminMapper;

    @PostMapping("/login")
    public String login(Admin admin){
        Admin adminMapperByName = adminMapper.getByName(admin.getName());
        if (adminMapperByName!=null && admin.getPassword().equals(adminMapperByName.getPassword())){
            return "main";
        }
        return null;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Admin> list = adminMapper.findAll();
        model.addAttribute("adminList", list);
        return "admininfo";  //templates/user_list.html
    }

    @GetMapping("/update")
    public String update(Integer id, Model model) {
        model.addAttribute("admin", adminMapper.getById(id));
        return "adminupdate";
    }

    @PostMapping("/update")
    public String update(Admin admin){
        adminMapper.update(admin);
        return "redirect:/admin/list";
    }
}
