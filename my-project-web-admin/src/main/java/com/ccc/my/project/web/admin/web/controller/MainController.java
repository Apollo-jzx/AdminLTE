package com.ccc.my.project.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ccc
 * @create 2019-10-25 15:15
 */
@Controller
public class MainController {

        @RequestMapping(value = "main", method = RequestMethod.GET)
        public String main() {
            return "main";
        }
    }


