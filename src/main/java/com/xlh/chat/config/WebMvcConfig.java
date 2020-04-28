//package com.xlh.chat.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * 用途描述
// *
// * @author 胡晓磊
// * @company xxx
// * @date 2020年04月14日 20:51 胡晓磊 Exp $
// */
//@Configuration
//@EnableWebMvc
//public class WebMvcConfig implements WebMvcConfigurer {
//    /**
//     *  视图跳转控制器
//     * 无业务逻辑的跳转 均可以以这种方法写在这里
//     * @param registry
//     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addViewController("/").setViewName("wes");
//        registry.addViewController("/wechat/index").setViewName("wechat/index");
//        registry.addViewController("/wechat/friends").setViewName("wechat/friends");
//        registry.addViewController("/wechat/install").setViewName("wechat/install");
////        registry.addViewController("/login").setViewName("login");
//    }
//
//    /**
//     * 添加静态资源文件，外部可以直接访问地址
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
//    }
//}
