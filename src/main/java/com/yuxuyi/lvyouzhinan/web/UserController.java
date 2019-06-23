package com.yuxuyi.lvyouzhinan.web;


import com.yuxuyi.lvyouzhinan.entity.User;
import com.yuxuyi.lvyouzhinan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired(required = false)
    UserMapper userMapper;

    @GetMapping("/list")
    public String list(Model model) {
        List<User> list = userMapper.findAll();
        model.addAttribute("userlist", list);
        return "userinfo";
    }

    @GetMapping("/update")
    public String update(Integer id, Model model) {
        model.addAttribute("user", userMapper.getById(id));
        return "userupdate";
    }

    @PostMapping("/update")
    public String update(User user){
        userMapper.update(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete")
    @ResponseBody
    public Map<String,Object> delete(Integer id){
        userMapper.deleteById(id);
        // 删除成功以后，返回数据
        Map<String,Object> r = new HashMap<>();
        r.put("code","系统提示");//删除成功
        r.put("msg","删除成功");
        return r;
    }

    @GetMapping("/getuser")
    @ResponseBody
    public List<User> getuser(){
        return userMapper.findAll();
    }


    @PostMapping("/add")
    public String add(User user){
        userMapper.save(user);
        // 保存用户数据成功以后重定向到用户列表页面
        return "ok";
    }
}
