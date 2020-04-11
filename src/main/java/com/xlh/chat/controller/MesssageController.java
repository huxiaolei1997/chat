package com.xlh.chat.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月11日 21:17 胡晓磊 Exp $
 */
@RestController
@RequestMapping("/message")
public class MesssageController {

//    @PostMapping("/send")
//    public
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView modelAndView = new ModelAndView("websocket");
        modelAndView.addObject("cid", cid);
        return modelAndView;
    }
}
