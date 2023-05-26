package ru.kpfu.itis.emelyanov.dto;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.emelyanov.model.Actor;
import ru.kpfu.itis.emelyanov.model.Product;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ProductResponseDto {

    Integer id;
    String name;
    Date date;
    Integer price;
    List<Actor> actors;

    public static ProductResponseDto fromEntity(Product product){
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .date(product.getDate())
                .price(product.getPrice())
                .actors(product.getActorList())
                .build();
    }
}
