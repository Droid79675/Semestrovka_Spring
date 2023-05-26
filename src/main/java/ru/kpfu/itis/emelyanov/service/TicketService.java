package ru.kpfu.itis.emelyanov.service;

import ru.kpfu.itis.emelyanov.dto.TicketResponseDto;
import ru.kpfu.itis.emelyanov.model.Buyer;
import ru.kpfu.itis.emelyanov.model.Product;
import ru.kpfu.itis.emelyanov.model.Ticket;

import java.security.Principal;
import java.util.Date;
import java.util.List;

public interface TicketService {
    List<TicketResponseDto> findAllByDate(Date date);

    List<TicketResponseDto> findAllByPrice(Integer price);

    Buyer getBuyerByPrincipal(Principal principal);

    List<Ticket> listTickets(Date date);

    void createTicket(Product product, String email);
}
