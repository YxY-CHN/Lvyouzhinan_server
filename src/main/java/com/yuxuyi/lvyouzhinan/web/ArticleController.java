package com.yuxuyi.lvyouzhinan.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.yuxuyi.lvyouzhinan.entity.Article;
import com.yuxuyi.lvyouzhinan.entity.User;
import com.yuxuyi.lvyouzhinan.mapper.ArticleMapper;
import com.yuxuyi.lvyouzhinan.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired(required = false)
    ArticleMapper articleMapper;

    @Autowired
    FileUploadService fileUploadService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> list = articleMapper.findAll();
        model.addAttribute("articlelist", list);
        return "pageview";
    }

    @GetMapping("/add")
    public String add() {
        return "pageadd";
    }

    @PostMapping("/add")
    public String add( MultipartFile file, Article article) throws Exception {
        String path = fileUploadService.upload(file);

        article.setImage(path);

        articleMapper.save(article);
        // 保存文章数据成功以后重定向到文章列表页面
        return "redirect:/article/list";
    }

    @GetMapping("/update")
    public String update(Integer id, Model model) {
        model.addAttribute("article", articleMapper.getById(id));
        return "pageupdate";
    }

    @PostMapping("/update")
    public String update(MultipartFile file,Article article) throws Exception {
        String path = fileUploadService.upload(file);

        article.setImage(path);

        articleMapper.update(article);
        return "redirect:/article/list";
    }

    @GetMapping("/delete")
    @ResponseBody // 响应给客户端的是数据
    public Map<String, Object> delete(Integer id) {
        articleMapper.deleteById(id);
        // 删除成功以后，返回数据
        Map<String, Object> r = new HashMap<>();
        r.put("code", "系统提示");//删除成功
        r.put("msg", "删除成功");
        return r;
    }

    @GetMapping("/getarticle")
    @ResponseBody
    public List<Article> getarticle(){
        return articleMapper.findAll();
    }
}
