package ru.kpfu.itis.emelyanov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.emelyanov.dto.TicketResponseDto;
import ru.kpfu.itis.emelyanov.model.Buyer;
import ru.kpfu.itis.emelyanov.model.Product;
import ru.kpfu.itis.emelyanov.model.Ticket;
import ru.kpfu.itis.emelyanov.repository.BuyerRepository;
import ru.kpfu.itis.emelyanov.repository.ProductRepository;
import ru.kpfu.itis.emelyanov.repository.TicketRepository;
import ru.kpfu.itis.emelyanov.service.TicketService;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final BuyerRepository buyerRepository;

    private final ProductRepository productRepository;

    @Override
    public List<TicketResponseDto> findAllByDate(Date date) {
        return ticketRepository.findAll().stream().filter(t -> t.getDate().equals(date))
                .map(t -> TicketResponseDto.builder()
                        .id(t.getId())
                        .date(t.getDate())
                        .price(t.getPrice())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public List<TicketResponseDto> findAllByPrice(Integer price) {
        return ticketRepository.findAll().stream().filter(t -> t.getPrice().equals(price))
                .map(t -> TicketResponseDto.builder()
                        .id(t.getId())
                        .date(t.getDate())
                        .price(t.getPrice())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public Buyer getBuyerByPrincipal(Principal principal) {
        if (principal == null) return new Buyer();
        return buyerRepository.findBuyerByEmail(principal.getName());
    }

    @Override
    public List<Ticket> listTickets(Date date) {
        if (date != null) return ticketRepository.findAllByDate(date);
        return ticketRepository.findAll();
    }

    @Override
    public void createTicket(Product product, String email) {
        Buyer buyer = buyerRepository.findBuyerByEmail(email);
        Ticket ticket = Ticket.builder()
                .price(product.getPrice())
                .date(product.getDate())
                .buyer(buyer)
                .product(product)
                .build();
        ticketRepository.save(ticket);
    }
}
