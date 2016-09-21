package com.web.test;

import com.utils.JsonData;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by weideliang on 2016/9/20.
 */
@Controller
@RequestMapping(value = "/test/ajax")
public class TestAjax {


    @RequestMapping(value = "/ajax2",method = RequestMethod.GET)
    public String ajax(){
        return "test/ajax/ajax2";
    }


    @ResponseBody
    @RequestMapping(value="/ajax21", method = RequestMethod.GET)
    public JsonData ajax21(@ModelAttribute User user){
//        user.setName(null);
//        System.out.println(user.getName());
//        user.setName("ajax");
//        int a = 1/0;
        return JsonData.getFailed("操作失败");
    }

    @ResponseBody
    @RequestMapping(value="/ajax22", method = RequestMethod.POST)
    public JsonData ajax22(@ModelAttribute User user){
        return JsonData.getSucceed(user);
    }

    @ResponseBody
    @RequestMapping(value="/ajax23", method = RequestMethod.GET)
    public JsonData ajax23(){
        User user = new User();
        user.setDate(DateTime.now().toDate()); //Tue Sep 20 19:41:05 CST 2016 {"name":null,"date":1474371665167}
        user.setId(1234l);
        return JsonData.getSucceed(user);
    }

    public static void main(String[] args) {
        System.out.println(DateTime.now().toDate().toString());//Tue Sep 20 20:00:02 CST 2016
    }

}

