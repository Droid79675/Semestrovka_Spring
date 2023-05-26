package ru.kpfu.itis.emelyanov.dto;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.emelyanov.model.Buyer;

@Data
@Builder
public class BuyerResponseDto {

    int id;
    String username;
    String fName;
    String sName;
    String password;
    String email;

    public static BuyerResponseDto fromEntity(Buyer buyer){
        return BuyerResponseDto.builder()
                .id(buyer.getId())
                .username(buyer.getUsername())
                .fName(buyer.getFName())
                .sName(buyer.getSName())
                .password(buyer.getPassword())
                .email(buyer.getEmail())
                .build();
    }
}
