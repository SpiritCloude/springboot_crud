package cn.edu.study.controller;

import cn.edu.study.entities.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Api("测试数据校验 + 统一异常处理")
@Controller
public class ValidController {
    @ApiOperation(value = "login")
    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }



    @ApiOperation(value = "数据校验（aspect环绕通知处理异常）")
    @PostMapping("/test")
    @ResponseBody
    public String toEmp(@Valid @RequestBody Employee emp,BindingResult bindingResult){
        int i=10/0;
        return "success"+i;
    }
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

//Get请求时 return ResponseEntity.ok();
//Post请求新增一条记录时,有返回值return new ResponseEntity(HttpStatus.CREATED);
//Put更新请求，无返回值ResponseEntity.noContent().build();
//Delete删除请求,无返回return new ResponseEntity(HttpStatus.NO_CONTENT);

/*
xmlHttp.status的值（HTTP状态表）

'100' : 'Continue',
 '101' : 'Switching Protocols',
        //Successful 2xx
        '200' : 'OK',
        '201' : 'Created',
        '202' : 'Accepted',
        '203' : 'Non-Authoritative Information',
        '204' : 'No Content',
        '205' : 'Reset Content',
        '206' : 'Partial Content',
        //Redirection 3xx
        '300' : 'Multiple Choices',
        '301' : 'Moved Permanently',
        '302' : 'Found',
        '303' : 'See Other',
        '304' : 'Not Modified',
        '305' : 'Use Proxy',
        '306' : 'Unused',
        '307' : 'Temporary Redirect',
        //Client Error 4xx
        '400' : 'Bad Request',
        '401' : 'Unauthorized',
        '402' : 'Payment Required',
        '403' : 'Forbidden',
        '404' : 'Not Found',
        '405' : 'Method Not Allowed',
        '406' : 'Not Acceptable',
        '407' : 'Proxy Authentication Required',
        '408' : 'Request Timeout',
        '409' : 'Conflict',
        '410' : 'Gone',
        '411' : 'Length Required',
        '412' : 'Precondition Failed',
        '413' : 'Request Entity Too Large',
        '414' : 'Request-URI Too Long',
        '415' : 'Unsupported Media Type',
        '416' : 'Requested Range Not Satisfiable',
        '417' : 'Expectation Failed',
        //Server Error 5xx
        '500' : 'Internal Server Error',
        '501' : 'Not Implemented',
        '502' : 'Bad Gateway',
        '503' : 'Service Unavailable',
        '504' : 'Gateway Timeout',
        '505' : 'HTTP Version Not Supported'

*/