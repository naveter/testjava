package sb;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Student Entity!!!!")
@RestController
public class HelloController {

    @ApiOperation(value = "Get list of Students in the System ", response = String.class)
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
