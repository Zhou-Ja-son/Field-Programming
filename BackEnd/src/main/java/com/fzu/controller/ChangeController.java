package com.fzu.controller;

import com.fzu.result.ServiceResult;
import com.fzu.utils.LowercaseToUppercase;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/change")
@Api(value = "ChangeController",tags = "ChangeController")
public class ChangeController {


    @PostMapping("/{str}")
    public String change(@PathVariable String str) {
        String toRmbUpper = LowercaseToUppercase.toRmbUpper(Double.parseDouble(str));
        return toRmbUpper;
    }

}
