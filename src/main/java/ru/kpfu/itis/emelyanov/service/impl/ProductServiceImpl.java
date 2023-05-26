package ru.kpfu.itis.emelyanov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.emelyanov.dto.ProductResponseDto;
import ru.kpfu.itis.emelyanov.dto.TicketResponseDto;
import ru.kpfu.itis.emelyanov.model.Product;
import ru.kpfu.itis.emelyanov.repository.ProductRepository;
import ru.kpfu.itis.emelyanov.repository.TicketRepository;
import ru.kpfu.itis.emelyanov.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final TicketRepository ticketRepository;

    @Override
    public List<ProductResponseDto> findAllByName(String name) {
        return productRepository.findAll().stream().filter(p -> p.getName().equals(name))
                .map(p -> ProductResponseDto.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .date(p.getDate())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductResponseDto findRandom() {
        Random rand = new Random();
        int random = rand.nextInt(6);
        return productRepository.findById(random).map(
                p -> ProductResponseDto.builder()
                        .name(p.getName())
                        .price(p.getPrice())
                        .date(p.getDate())
                        .actors(p.getActorList())
                        .build()).get();
    }

    @Override
    public List<TicketResponseDto> findTicketByProduct(String product_name) {
        return ticketRepository.findAll().stream().filter(t -> t.getProduct().getName().equals(product_name))
                .map(t -> TicketResponseDto.builder()
                        .id(t.getId())
                        .date(t.getDate())
                        .price(t.getPrice())
                        .build()
                ).collect(Collectors.toList());
    }
    @Override
    public ProductResponseDto findProductByName(String name) {
        if (name != null) return productRepository.findAllByName(name).stream().findFirst()
                .map(p -> ProductResponseDto.builder()
                        .name(p.getName())
                        .price(p.getPrice())
                        .date(p.getDate())
                        .actors(p.getActorList())
                        .build()).get();
        return null;
    }

    @Override
    public List<ProductResponseDto> listProducts(){
        return productRepository.findAll().stream().map(p -> ProductResponseDto.builder()
                .id(p.getId())
                .name(p.getName())
                .date(p.getDate())
                .actors(p.getActorList())
                .price(p.getPrice())
                .build())
                .collect(Collectors.toList());
    }
}
