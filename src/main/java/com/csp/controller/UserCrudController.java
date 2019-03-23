package com.csp.controller;

import com.csp.entity.User;
import com.csp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserCrudController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public User selectById(@PathVariable("id") Integer id){
        return userService.selectById(id);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> list(){
        return userService.selectList();
    }

    @PostMapping("/add")
    public String add(User user){
        int add = userService.add(user);
        if (add != 0){
            return "新增用户信息成功！";
        }else {
            return "新增用户信息失败！";
        }
    }

    @PutMapping("/update")
    public String update(User user){
        int update = userService.updateById(user);
        if (update != 0){
            return "修改用户信息成功！";
        }else {
            return "修改用户信息失败！";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")Integer id){
        int delete = userService.deleteById(id);
        if (delete != 0){
            return "删除"+id+"号用户成功！";
        }else {
            return "您删除的用户不存在或错误！";
        }
    }


    @GetMapping("/test")
    @ResponseBody
    public Map list(@RequestParam String name,@RequestParam String name1){
        System.out.println(name + "-----" + name1);
        return new HashMap();
    }
}
