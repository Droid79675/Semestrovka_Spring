package ru.kpfu.itis.emelyanov.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.emelyanov.dto.BuyerResponseDto;
import ru.kpfu.itis.emelyanov.dto.CreateBuyerRequestDto;
import ru.kpfu.itis.emelyanov.model.Buyer;
import ru.kpfu.itis.emelyanov.repository.BuyerRepository;
import ru.kpfu.itis.emelyanov.service.BuyerService;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public BuyerResponseDto createBuyer(CreateBuyerRequestDto buyerRequestDto) {
        if(buyerRepository.findByEmail(buyerRequestDto.getEmail()).isEmpty()){
            Buyer buyer = Buyer.builder()
                    .fName(buyerRequestDto.getFName())
                    .sName(buyerRequestDto.getSName())
                    .username(buyerRequestDto.getUsername())
                    .email(buyerRequestDto.getEmail())
                    .password(passwordEncoder.encode(buyerRequestDto.getPassword()))
                    .build();
            buyerRepository.save(buyer);
            return BuyerResponseDto.fromEntity(buyer);
        }
        return null;
    }

    @Override
    public List<BuyerResponseDto> findAllByEmail(String email) {
        return buyerRepository.findAll().stream().filter(b -> Objects.equals(b.getEmail(), email))
                .map(b -> BuyerResponseDto.builder()
                        .id(b.getId())
                        .username(b.getUsername())
                        .fName(b.getFName())
                        .sName(b.getSName())
                        .email(b.getEmail())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public List<BuyerResponseDto> findAll() {
        return buyerRepository.findAll().stream().map(b -> BuyerResponseDto.builder()
                .id(b.getId())
                .fName(b.getFName())
                .sName(b.getSName())
                .username(b.getUsername())
                .email(b.getEmail())
                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public Optional<BuyerResponseDto> findById(Integer id) {
        return buyerRepository.findAllById(List.of(id))
                .stream().map(b -> BuyerResponseDto.builder()
                        .id(b.getId())
                        .fName(b.getFName())
                        .sName(b.getSName())
                        .username(b.getUsername())
                        .email(b.getEmail())
                        .build()
                ).findFirst();
    }

    @Override
    public BuyerResponseDto findBuyerByFNameAndSName(String fName, String sName) {
        return buyerRepository.findAll().stream().filter(b -> b.getFName().equals(fName) && b.getSName().equals(sName))
                .map(b -> BuyerResponseDto.builder()
                        .id(b.getId())
                        .username(b.getUsername())
                        .fName(b.getFName())
                        .sName(b.getSName())
                        .email(b.getEmail())
                        .build()
                ).findFirst()
                .orElse(null);
    }

//    public void banReview(Integer id) {
//        Review review = buyerRepository.findReviewById(id).orElse(null);
//        if (review != null) {
//            if (review.isActive()) {
//                review.setActive(false);
//                log.info("Ban user with id = {}; email: {}", review.getId(), review.getEmail());
//            } else {
//                review.setActive(true);
//                log.info("Unban user with id = {}; email: {}", review.getId(), review.getEmail());
//            }
//        }
//        buyerRepository.save(review);
//    }
    @Override
    public Buyer getBuyerByPrincipal(Principal principal) {
        if (principal == null) return new Buyer();
        return buyerRepository.findBuyerByEmail(principal.getName());
    }

//    public Buyer getCurrentBuyer() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = (String) authentication.getPrincipal();
//
//        Buyer currentBuyer = (BuyerRepository.findBuyerByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + "not found")));
//
//        return currentBuyer;
//    }
}
