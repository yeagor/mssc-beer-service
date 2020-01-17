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

    public static final String BEER_1_IPC = "08374563475";
    public static final String BEER_2_IPC = "08374563476";
    public static final String BEER_3_IPC = "08374563477";

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
                .upc(BEER_1_IPC)
                .price(new BigDecimal("13.5"))
                .build());

            beerRepository.save(Beer.builder()
                .beerName("Corona Large")
                .beerStyle("PALE_AXE")
                .quantityToBrew(200)
                .upc(BEER_2_IPC)
                .price(new BigDecimal("11.5"))
                .build());

            beerRepository.save(Beer.builder()
                .beerName("Corona Large")
                .beerStyle("PALE_AsadXE")
                .quantityToBrew(20)
                .upc(BEER_3_IPC)
                .price(new BigDecimal("13.5"))
                .build());
        }

        log.debug("Loaded beers: {}", beerRepository.count());
    }
}
