package cn.wukun.web;

import java.util.Date;
import java.util.List;

import cn.wukun.data.SpittleRepository;
import cn.wukun.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spittle")
public class SpittleController {
  @Autowired
  private SpittleRepository spittleRepository;

  @RequestMapping(method=RequestMethod.GET)
  public List<Spittle> spittle(Model model) {
    List<Spittle> spittleList = spittleRepository.findSpittleByUserName("wukun");
    return spittleList;
  }

}
