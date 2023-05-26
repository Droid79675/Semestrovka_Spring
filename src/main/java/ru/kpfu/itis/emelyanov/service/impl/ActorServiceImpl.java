package ru.kpfu.itis.emelyanov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.emelyanov.dto.ActorResponseDto;
import ru.kpfu.itis.emelyanov.repository.ActorRepository;
import ru.kpfu.itis.emelyanov.service.ActorService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;


    @Override
    public List<ActorResponseDto> findAllByName(String name) {
        return actorRepository.findAll().stream().filter(a -> a.getName().equals(name))
                .map(a -> ActorResponseDto.builder()
                .id(a.getId())
                .name(a.getName())
                .birthday(a.getBirthday())
                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<ActorResponseDto> findAllByBirthdate(Date birthday) {
        return actorRepository.findAll().stream().filter(a -> a.getBirthday().equals(birthday))
                .map(a -> ActorResponseDto.builder()
                        .id(a.getId())
                        .name(a.getName())
                        .birthday(a.getBirthday())
                        .build()
                ).collect(Collectors.toList());
    }
}
