package alid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriteNumberController {

    @RequestMapping("/writeNumber")
    public Result stringDeDup(@RequestParam(value = "value", defaultValue = "") Integer value) {
        return Result.builder().content(WriteNumber.toEnglishString(value)).build();
    }

}
