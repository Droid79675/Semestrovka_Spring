package ru.kpfu.itis.emelyanov.service;

import ru.kpfu.itis.emelyanov.dto.BuyerResponseDto;
import ru.kpfu.itis.emelyanov.dto.CreateBuyerRequestDto;
import ru.kpfu.itis.emelyanov.model.Buyer;

import java.security.Principal;
import java.util.Optional;

import java.util.List;

public interface BuyerService {

    List<BuyerResponseDto> findAllByEmail(String email);

    BuyerResponseDto createBuyer(CreateBuyerRequestDto buyerRequestDto);

    List<BuyerResponseDto> findAll();

    Optional<BuyerResponseDto> findById(Integer id);
    BuyerResponseDto findBuyerByFNameAndSName(String fName, String sName);

    Buyer getBuyerByPrincipal(Principal principal);

//    Buyer getCurrentBuyer();
}
