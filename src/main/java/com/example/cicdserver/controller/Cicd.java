package com.example.cicdserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * ClassName : Cicd
 * Package: com.example.cicdserver.controller
 * Description:
 *
 * @Author:wanggl
 * @Create: 2022/12/18-10:47
 * @Version: 1.0
 **/
@Controller
public class Cicd {

    private HashMap<String,Integer> jobMap = new HashMap<>();
    private Set<String> timeSet = new HashSet<>();
    @RequestMapping("setJob")
    @ResponseBody
    public String setJob(@RequestParam String []jobId){
        System.out.println(jobId);
        // jobMap.put(jobId,1);
        for (String id:jobId
             ) {
            jobMap.put(id,1);

        }
        return "set job"+jobMap;
    }
    @RequestMapping("setTime")
    public String setTime(@RequestParam String addTime,Model model){
        System.out.println(addTime);
        // jobMap.put(jobId,1);
        timeSet.add(addTime);
        model.addAttribute("time", timeSet);

        return "jobList";
    }
    @RequestMapping("delTime")
    public String delTime(@RequestParam String id,Model model){
        System.out.println(id);
        // jobMap.put(jobId,1);
        timeSet.remove(id);
        model.addAttribute("time", timeSet);
        return "jobList";
    }

    @RequestMapping("getJob")
    @ResponseBody
    public Object setJob(){
        HashMap<String,Integer> innerMap = new HashMap<>(jobMap);
        jobMap.clear();
        System.out.println(jobMap);
        return innerMap;
    }
    @RequestMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("time", timeSet);


        return "jobList";
    }
    @RequestMapping("/index")
    public String index(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setId((long) i);
            u.setName("javaboy:" + i);
            u.setAddress("深圳:" + i);
            users.add(u);
        }
        model.addAttribute("users", users);
        return "index";
    }
    void saveModel( Model model,String name ,Object obj){
        model.addAttribute(name,obj);
    }
}
