package ru.kpfu.itis.emelyanov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.emelyanov.model.Product;
import ru.kpfu.itis.emelyanov.service.ProductService;
import ru.kpfu.itis.emelyanov.service.TicketService;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final TicketService ticketService;

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products",productService.listProducts());
        return "products";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "searchWord", required = false) String searchWord, Model model) {
        if(productService.findProductByName(searchWord) != null){
            model.addAttribute("product",productService.findProductByName(searchWord));
            model.addAttribute("searchWord", searchWord);
            return "search";
        }
        model.addAttribute("errorMessage", "No performance found by this name");
        return "products";
    }

    @PostMapping("/buyticket")
    public String buyTicket(@ModelAttribute Product product, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            ticketService.createTicket(product, (String) authentication.getPrincipal());
            return "profile";
        }
        model.addAttribute("errorMessage", "You need to be logged in order to buy");
        return "login";
    }
}
