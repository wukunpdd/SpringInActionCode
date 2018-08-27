package cn.wukun.web;

import cn.wukun.dao.UserScoreDao;
import cn.wukun.domain.UserScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/userScore")
public class UserScoreController {

    @Autowired
    private UserScoreDao userScoreDao;

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/data")
    public String testData(){
        UserScore userScore = userScoreDao.findOneByUserId(14);
        System.out.println("UserScore:"+userScore);
        return "test";
    }

    @RequestMapping("/findAll")
    public String findAll(@RequestParam Integer size){
        System.out.println("Size:"+size);

        List<UserScore> userScoreList = userScoreDao.findAll();
        for(UserScore userScore:userScoreList){
            System.out.println("UserScore:"+userScore);
        }

        return "test";
    }
}
