package cn.czfshine.app.store.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页控制器
 *
 * @author:czfshine
 * @date:2019/3/22 16:21
 */
@Controller
public class IndexController {

    /**
     * 访问根目录时使用index.html
     *
     * @return
     */
    @RequestMapping(value = "/")
    public String index() {
        return "login";
    }

    /**
     * /main 定向到main.html
     *
     * @return
     */
    @Deprecated
    @RequestMapping(value = "/main")
    public String main() {
        return "main";
    }
}
