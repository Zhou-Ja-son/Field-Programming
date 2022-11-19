package com.fzu.controller;

import com.fzu.result.ServiceResult;
import com.fzu.utils.JudgeUp;
import com.fzu.utils.LowercaseToUppercase;
import com.fzu.utils.UppercaseToLowercase;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/change")
@Api(value = "ChangeController",tags = "ChangeController")
public class ChangeController {


    @PostMapping("/{str}")
    public String change(@PathVariable String str) {
        boolean flag=true;
        for (int i = 0;i<str.length();i++){
            if (!Character.isDigit(str.charAt(i))) {
                flag=false;
                break;
            }
        }
        if (!flag){

            try {
                if (!JudgeUp.bigjudge(str.substring(0,str.indexOf("元")-1))) {
                    return "输入有误";
                }
            } catch (Exception e) {
                return "输入有误";
            }
        }
        String toRmbUpper="";
        if (flag){
            toRmbUpper = LowercaseToUppercase.toRmbUpper(Double.parseDouble(str));
        }else {
            BigDecimal bigDecimal = UppercaseToLowercase.chinese2Number(str);
            toRmbUpper = bigDecimal.stripTrailingZeros().toPlainString();
        }

        return toRmbUpper;
    }

}
