package cn.zm.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@ConditionalOnProperty(prefix = "mconfig", name = "swagger-ui-open", )
public class SwaggerConfig {
    @Bean
    public Docket createRestfulApi() {// api文档实例
        return new Docket(DocumentationType.SWAGGER_2)// 文档类型：DocumentationType.SWAGGER_2
                .apiInfo(apiInfo())// api信息
                .select()// 构建api选择器
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))// api选择器选择api的包
                .paths(PathSelectors.any())// api选择器选择包路径下任何api显示在文档中
                .build();// 创建文档
    }

    private ApiInfo apiInfo() {// 接口的相关信息
        return new ApiInfoBuilder()
                .title("SeClover数据开放平台")
                .description("接口文档")
                .version("1.0")
                .build();
    }
}
