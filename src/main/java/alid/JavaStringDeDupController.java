package alid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaStringDeDupController {

    @RequestMapping("/stringDeDup")
    public Result stringDeDup(@RequestParam(value = "value", defaultValue = "") String value) {//FIXME : not specified --> ask client before : default String empty
        return Result.builder().content(JavaStringDeDup.deDup(value, 30)).build();
    }

}
