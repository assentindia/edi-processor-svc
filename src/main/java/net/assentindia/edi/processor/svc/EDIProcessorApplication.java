/**
 * 
 */
package net.assentindia.edi.processor.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author kush
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableCaching
//@EnableScheduling
@ComponentScan({"net.assentindia.common","net.assentindia"})
public class EDIProcessorApplication 
{
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EDIProcessorApplication.class, args);
	    System.out.println(String.format(">>>>> %s is Running", ctx.getId()));
	}
	
	@Bean
    public Docket apiDocket() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("net.assentindia.edi.processor.svc"))              
          .paths(PathSelectors.any())                          
          .build().apiInfo(apiInfoMetaData());                                           
    }
	
	private ApiInfo apiInfoMetaData() {

        return new ApiInfoBuilder().title("API Documentation")
                .description("Describing the purpose of the API")
                .contact(new Contact("Dev-Team", "https://www.assentindia.net/", "contact@assentindia.net"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
