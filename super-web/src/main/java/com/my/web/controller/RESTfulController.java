package com.my.web.controller;


import com.my.web.bo.User;
import com.my.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by lilianga on 2018/11/12.
 */

@RestController
@RequestMapping(value="/users")
public class RESTfulController {

    @Autowired
    private UserService userService;

    // 创建线程安全的Map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @RequestMapping("/hello-rest")
    public String hello() {
        return "Hello RESTful!";
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public String postUser(@RequestBody  User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        User user = users.get(Integer.parseInt(id+""));
        return user;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        System.out.println("开始新增...");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public boolean updateUser( User user) {
        System.out.println("开始更新...");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "userName", required = true) int userId) {
        System.out.println("开始删除...");
        return userService.deleteUser(userId);
    }

    @RequestMapping(value = "/userName", method = RequestMethod.GET)
    public User findByUserName(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("开始查询...");
        return userService.findUserByName(userName);
    }

    @RequestMapping(value = "/userId", method = RequestMethod.GET)
    public User findByUserId(@RequestParam(value = "userId", required = true) int userId) {
        System.out.println("开始查询...");
        return userService.findUserById(userId);
    }

    @RequestMapping(value = "/userAge", method = RequestMethod.GET)
    public User findByUserAge(@RequestParam(value = "userAge", required = true) int userAge) {
        System.out.println("开始查询...");
        return userService.findUserByAge(userAge);
    }


}
