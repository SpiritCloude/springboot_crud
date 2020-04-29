package cn.edu.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloTest {

    @RequestMapping(value = {"/", "login"})
    public String login() {
        return "login";
    }
    /* classpath: == java/  == resources/
    * 静态资源文件夹默认在classpath:/META-INF/resources/webjars/
    * 访问http://localhost:8080/webjars/相当于/META-INF/resources/webjars/
    * WebMvcAutoConfiguration  (ctrl+n)
    * customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
    * .addResourceLocations("classpath:/META-INF/resources/webjars/")
    *
    * " /abc "访问没人处理去以下文件夹找abc静态资源
    * classpath:/META-INF/resources/
    * classpath:/resources/
    * classpath:/static/
    * classpath:/public/
    * */
}
