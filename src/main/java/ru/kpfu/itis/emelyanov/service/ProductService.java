package ru.kpfu.itis.emelyanov.service;

import ru.kpfu.itis.emelyanov.dto.ProductResponseDto;
import ru.kpfu.itis.emelyanov.dto.TicketResponseDto;
import ru.kpfu.itis.emelyanov.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductResponseDto> findAllByName(String name);

    Optional<Product> findById(Integer id);

    ProductResponseDto findRandom();

    List<TicketResponseDto> findTicketByProduct(String product_name);

    ProductResponseDto findProductByName(String title);

    List<ProductResponseDto> listProducts();
}
