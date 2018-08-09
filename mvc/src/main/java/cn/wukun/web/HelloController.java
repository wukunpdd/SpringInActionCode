package cn.wukun.web;

import cn.wukun.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap modelMap){
        modelMap.addAttribute("message", "My Name Is Tom");
        return "hello";
    }

    /**
     * 目前返回的信息一定要包含指定的jsp页面信息
     * 暂时无法通过接口返回实体类信息
     * 默认和/test对应的是test.jsp
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<Student> test(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(createStudent(1, "吴堃", 25));
        studentList.add(createStudent(2, "刘卿香", 26));
        studentList.add(createStudent(3, "王楠", 24));
        return studentList;
    }

    @RequestMapping(value = "/domain", method = RequestMethod.GET)
    public Student domain(){
        return createStudent(2, "刘卿香", 26);
    }

    public static Student createStudent(int id, String name, int age){
        Student student = new Student();
        student.setId(id);
        student.setAge(age);
        student.setName(name);
        return student;
    }
}
