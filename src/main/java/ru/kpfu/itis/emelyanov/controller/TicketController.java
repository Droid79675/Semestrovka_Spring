package ru.kpfu.itis.emelyanov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.emelyanov.model.Buyer;
import ru.kpfu.itis.emelyanov.service.TicketService;

import java.security.Principal;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;


//    @GetMapping("/tickets")
//    public String tickets(@RequestParam(name = "date", required = false) Date date, Principal principal, Model model) {
//        model.addAttribute("tickets", ticketService.listTickets(date));
//        model.addAttribute("buyer", ticketService.getBuyerByPrincipal(principal));
//        model.addAttribute("searchDate", date);//не забудь поменять searchWord на searchDate в странице
//        return "tickets";
//    }

    @GetMapping("/my/tickets")
    public String buyerTickets(Principal principal, Model model) {
        Buyer buyer = ticketService.getBuyerByPrincipal(principal);
        model.addAttribute("buyer", buyer);
        model.addAttribute("tickets", buyer.getTickets());
        return "my_tickets";
    }
}
