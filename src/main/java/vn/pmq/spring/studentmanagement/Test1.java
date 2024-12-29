package vn.pmq.spring.studentmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test1 {
    @GetMapping("/hello")
    public String test() {
        return "hello";
    }
}
