package ru.kpfu.itis.emelyanov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.emelyanov.service.ProductService;

@RequiredArgsConstructor
@Controller
public class HitsController {

    private final ProductService productService;

    @GetMapping("/ajax/hits")
    @ResponseBody
    public String getHits() {
        return productService.findRandom().getName();
    }
}
