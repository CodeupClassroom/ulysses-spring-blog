package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServicesDemoController {
    private final TwilioService twilioService;

    public ServicesDemoController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @GetMapping("/text/ryan")
    public @ResponseBody String textRyan() {
        return twilioService.sendTextToRyan("Hi Ryan!");
    }

    @GetMapping("/text/zach/{message}")
    public @ResponseBody String textZach(@PathVariable String message) {
        return twilioService.sendTextToZach(
            String.format("%s, Zach!", message)
        );
    }
}
