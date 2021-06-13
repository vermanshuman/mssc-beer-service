package com.tychon.msscbeerservice.bootstrap;

import com.tychon.msscbeerservice.domain.Beer;
import com.tychon.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args){
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
            .beerName("Beer 1")
            .beerStyle("IPA")
                    .minOnHand(12)
            .quantityToBrew(200)
                    .upc(3370100001L)
                    .price(new BigDecimal("12.5"))
            .build());

            beerRepository.save(Beer.builder()
                    .beerName("Beer 2")
                    .beerStyle("PALE_ALE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(3370100002L)
                    .price(new BigDecimal("11.95"))
                    .build());

        }
    }
}
