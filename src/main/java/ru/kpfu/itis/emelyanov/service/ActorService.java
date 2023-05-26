package ru.kpfu.itis.emelyanov.service;

import ru.kpfu.itis.emelyanov.dto.ActorResponseDto;

import java.util.Date;
import java.util.List;

public interface ActorService {
    List<ActorResponseDto> findAllByName(String name);
    List<ActorResponseDto> findAllByBirthdate(Date birthday);
}
