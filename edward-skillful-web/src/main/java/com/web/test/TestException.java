package com.web.test;

import com.exception.MyBusinessException;
import com.exception.MyException;
import com.exception.MyIllegalArgumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by weideliang on 2016/9/22.
 */
@Controller
@RequestMapping("/test/exception")
public class TestException {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "test/exception/index";
    }

    @RequestMapping(value = "/{no}",method = RequestMethod.GET)
    public void controller(@PathVariable Integer no) throws MyException {
        switch (no){
            case 1:throw new MyIllegalArgumentException("不合法参数");
            case 2:throw new MyBusinessException("业务异常");
            default:throw new MyException("其他异常");
        }
    }
}
