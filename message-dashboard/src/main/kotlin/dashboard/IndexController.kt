package dashboard

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {
    val index: String @RequestMapping("/") get() = "index"
}
