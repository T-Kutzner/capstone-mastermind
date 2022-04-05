package de.tk.mastermind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactRoutingForwardingController {

    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    public String forwardToRouteUrl() {
        return "forward:/";
    }
}
