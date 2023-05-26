package ru.kpfu.itis.emelyanov.dto;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.emelyanov.model.Actor;
import java.util.Date;

@Data
@Builder
public class ActorResponseDto {

    int id;
    String name;
    Date birthday;

    public static ActorResponseDto fromEntity(Actor actor){
        return ActorResponseDto.builder()
                .id(actor.getId())
                .name(actor.getName())
                .birthday(actor.getBirthday())
                .build();
    }
}
