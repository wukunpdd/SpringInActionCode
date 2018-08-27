package cn.wukun.web;

import cn.wukun.dao.UserScoreDao;
import cn.wukun.domain.UserScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        UserScore userScore = userScoreDao.getUserScoreByUserId(14);
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

    @RequestMapping("/getOneByUserName")
    public String getOneByUserName(){
        UserScore userScore = userScoreDao.getUserScoreByUserName("吴堃", 13);
        System.out.println("UserScore:"+userScore);
        return "test";
    }

    @RequestMapping("/delete")
    public String delete(){
        UserScore userScore = userScoreDao.getUserScoreByUserName("王楠", 14);
        System.out.println("UserScore:"+userScore);

        userScore = userScoreDao.getUserScoreByUserName("王楠", 14);
        System.out.println("UserScore:"+userScore);

        userScore = userScoreDao.getUserScoreByUserName("王楠", 14);
        System.out.println("UserScore:"+userScore);

        userScoreDao.delete(14);

        userScore = userScoreDao.getUserScoreByUserName("王楠", 14);
        System.out.println("UserScore:"+userScore);

        return "test";
    }

    @RequestMapping
    public String deleteCache(){
        userScoreDao.delete(14);
        return "test";
    }
}
