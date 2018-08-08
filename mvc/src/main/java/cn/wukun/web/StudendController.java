package cn.wukun.web;

import cn.wukun.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudendController {
    /**
     * 在ModelAndView对象中传递了一个名为“command”的空对象，因为如果在JSP中使用<form：form>标签，spring框架需要一个名为“command”的对象文件。
     * @return
     */
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        Student student = new Student();
        student.setName("刘卿香");
        student.setAge(26);
        student.setId(751364);
        return new ModelAndView("student", "command", student);
    }

    /**
     * @ModelAttribute("SpringWeb")Student student
     *      获取表单提交的信息
     * @param student
     * @param model
     * @return
     */
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb")Student student,
                             ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());

        return "result";
    }
}
