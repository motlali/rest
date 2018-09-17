package alid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaStringDedupController {

    @RequestMapping("/stringDeDup")
    public Result stringDedup(@RequestParam(value = "value", defaultValue = "") String value) {
        return Result.builder().content(JavaStringDeDup.deDup(value, 30)).build();
    }

}
