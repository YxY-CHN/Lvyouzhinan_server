package com.yuxuyi.lvyouzhinan.web;

import com.yuxuyi.lvyouzhinan.entity.Comment;
import com.yuxuyi.lvyouzhinan.entity.User;
import com.yuxuyi.lvyouzhinan.mapper.CommentMapper;
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
@RequestMapping("/comment")
public class CommentController {

    @Autowired(required = false)
    CommentMapper commentMapper;

    @GetMapping("/list")
    public String list(Model model){
        List<Comment> list = commentMapper.findAll();
        model.addAttribute("commentlist",list);
        return "commentinfo";
    }

    @GetMapping("/delete")
    @ResponseBody // 响应给客户端的是数据
    public Map<String,Object> delete(Integer id){
        commentMapper.deleteById(id);
        // 删除成功以后，返回数据
        Map<String,Object> r = new HashMap<>();
        r.put("code","系统提示");//删除成功
        r.put("msg","删除成功");
        return r;
    }

    @GetMapping("/getcomment")
    @ResponseBody
    public List<Comment> getcomment(){
        return commentMapper.findAll();
    }

    @PostMapping("/add")
    public String add(Comment comment){
        commentMapper.save(comment);
        // 保存用户数据成功以后重定向到用户列表页面
        return "ok";
    }
}
