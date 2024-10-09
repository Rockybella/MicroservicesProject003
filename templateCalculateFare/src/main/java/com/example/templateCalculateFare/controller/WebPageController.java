package com.example.templateCalculateFare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {

    @GetMapping("/")
    public String showWelcomePage() {
        return "welcome"; // This will serve welcome.html from the static folder
    }

    @GetMapping("/book-cab")
    public String showBookCabPage() {
        return "book-cab"; // This will serve book-cab.html from the static folder
    }

    @GetMapping("/calculate-fare")
    public String showCalculateFarePage() {
        return "calculate-fare"; // This will serve calculate-fare.html from the static folder
    }
}
