package ru.kpfu.itis.emelyanov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.emelyanov.dto.CreateBuyerRequestDto;
import ru.kpfu.itis.emelyanov.logs.Loggable;
import ru.kpfu.itis.emelyanov.service.BuyerService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@Loggable
@RequiredArgsConstructor
public class BuyerController {
    private final BuyerService buyerService;

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        model.addAttribute("buyer", buyerService.getBuyerByPrincipal(principal));
        return "login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal,
                          Model model) {
        model.addAttribute("buyer", buyerService.getBuyerByPrincipal(principal));
        model.addAttribute("tickets", buyerService.getBuyerByPrincipal(principal).getTickets());
        return "profile";
    }

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("buyer", new CreateBuyerRequestDto());
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String createBuyer(@ModelAttribute @Valid CreateBuyerRequestDto buyer, Model model) {
        if (buyerService.createBuyer(buyer) == null) {
            model.addAttribute("errorMessage", "User with this email: " + buyer.getEmail() + " already exists");
            return "sign_up";
        }
        return "redirect:/login";
    }

//    @GetMapping("/user/{user}")
//    public String userInfo(@PathVariable("user") User user, Model model, Principal principal) {
//        model.addAttribute("user", user);
//        model.addAttribute("userByPrincipal", buyerService.getUserByPrincipal(principal));
//        model.addAttribute("products", user.getProducts());
//        return "user-info";
//    }

//    @GetMapping(value = {"/buyers/{id}", "buyers"})
//    public Iterable<BuyerResponseDto> buyer(@PathVariable(required = false) Optional<Integer> id) {
//        if (id.isPresent()) {
//            return List.of(buyerService.findById(id.get()).get());
//        } else {
//            return buyerService.findAll();
//        }
//    }
}
