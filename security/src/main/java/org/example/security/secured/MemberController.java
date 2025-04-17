package org.example.security.secured;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management")
public class MemberController {

    @GetMapping
    public String getMember() {
        return "Member: Secured end point";
    }
}
