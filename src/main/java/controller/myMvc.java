package controller;

import model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;
import java.util.Map;

/**
 * Created by 12917 on 2017/7/13.
 */
@Controller
@Transactional
@RequestMapping(value = "mvc")
public class myMvc {
    @RequestMapping(value = "s")
    @ResponseBody
    public String ss(){
        return "shabi";
    }
    /*重定向*/
    @RequestMapping(value = "/a")
    public View home(Map<String,Object> model){
        model.put("dash","dash");
        return new RedirectView("/mvc/{dash}",true);
    }
    @RequestMapping(value = "/dash",method= RequestMethod.GET)
    public String dash(Map<String,Object> model){
        model.put("text","this is a model attribute");
        model.put("date", Instant.now());
        return "/dash";
    }

    //将实体类转化为视图
    @RequestMapping(value = "mvc/home",method = RequestMethod.GET)
    @ModelAttribute("currentUser")
    public Form setForm(){
        Form form=new Form();
        form.setName("HEHE");
        form.setPassword("HAHA");
        return form;
    }

}
