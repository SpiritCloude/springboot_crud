package cn.edu.study.config;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 	创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 	访问地址：http://项目实际地址/swagger-ui.html
     *	@return
     */
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact=new Contact("Gaoz","https://developer.aliyun.com/portrait/txu6phljsc6cs","12345678@qq.com");
        return new ApiInfoBuilder()
                .title("Spring Boot配置Swagger2构建RESTful APIs")
                .termsOfServiceUrl("http://localhost:8080")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
