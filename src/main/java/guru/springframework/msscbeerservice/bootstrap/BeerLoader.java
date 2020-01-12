package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repository.BeerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@AllArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                .beerName("Lucida Console")
                .beerStyle("IPA")
                .quantityToBrew(200)
                .upc(333000000001L)
                .price(new BigDecimal("13.5"))
                .build());

            beerRepository.save(Beer.builder()
                .beerName("Corona Large")
                .beerStyle("PALE_AXE")
                .quantityToBrew(200)
                .upc(333000000002L)
                .price(new BigDecimal("11.5"))
                .build());
        }

        log.debug("Loaded beers: {}", beerRepository.count());
    }
}
