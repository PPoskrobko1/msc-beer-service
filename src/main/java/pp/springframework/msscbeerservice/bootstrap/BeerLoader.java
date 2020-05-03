package pp.springframework.msscbeerservice.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pp.springframework.msscbeerservice.domain.Beer;
import pp.springframework.msscbeerservice.repositories.BeerRepository;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    final private BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
            .beerName("Mango Bobs")
            .beerStyle("IPA")
            .quantityToBrew(200)
                    .minOnHand(12)
            .upc(7254673254326458324L)
                    .price(new BigDecimal("12.51"))
            .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(7254673254326400324L)
                    .price(new BigDecimal("11.51"))
                    .build());
        }
    }
}
