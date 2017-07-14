package controller;

import model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.servlet.http.Part;

/**
 * Created by 12917 on 2017/6/11.
 */
@Controller
@Transactional
public class InsertUserinfo  extends BaseAction{
    @RequestMapping(value="insertUserinfo")
    public String insertUserinfo(){
        //this.getAllService().getUserinfoService().insertUserinfo(4,"SHABI",5);
        return "/index";
    }
    @RequestMapping(value="show",method = RequestMethod.GET)
    public String can(@RequestParam ("a") String a,@RequestParam(value = "b",required = false,defaultValue = "sss") String b){
        System.out.print(a+b);
        return "/index";
    }
    @RequestMapping(value = "in",consumes = {"text/json","application/json"},produces = {"text/json","application/json"})
    public String song(){
        return "/index.jsp";
    }
    @RequestMapping(value = "info",method = RequestMethod.POST)
    public String login(Form form){

        /*这里不写@EequestParams*/
        System.out.println("hello"+form.getName());
        return "/result";
    }
    @RequestMapping(value = "file/upload",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "username",required = false,defaultValue = "sss") String username, @RequestPart("upload")MultipartFile multipartFile){
        System.out.print(username);
        //aa
        return "/result";
    }

}
