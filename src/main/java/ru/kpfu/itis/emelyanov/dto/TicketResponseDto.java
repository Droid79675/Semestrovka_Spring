package ru.kpfu.itis.emelyanov.dto;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.emelyanov.model.Ticket;
import java.util.Date;

@Data
@Builder
public class TicketResponseDto {
    Integer id;
    Date date;
    Integer price;

    public static TicketResponseDto fromEntity(Ticket ticket){
        return TicketResponseDto.builder()
                .id(ticket.getId())
                .date(ticket.getDate())
                .price(ticket.getPrice())
                .build();
    }
}
