package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repository.BeerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
//@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

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
                .upc(BEER_1_UPC)
                .price(new BigDecimal("13.5"))
                .id(BEER_1_UUID)
                .build());

            beerRepository.save(Beer.builder()
                .beerName("Corona Large")
                .beerStyle("PALE_AXE")
                .quantityToBrew(200)
                .upc(BEER_2_UPC)
                .price(new BigDecimal("11.5"))
                .id(BEER_2_UUID)
                .build());

            beerRepository.save(Beer.builder()
                .beerName("Corona Large")
                .beerStyle("PALE_AXE")
                .quantityToBrew(20)
                .upc(BEER_3_UPC)
                .price(new BigDecimal("13.5"))
                .id(BEER_3_UUID)
                .build());
        }

        log.debug("Loaded beers: {}", beerRepository.count());
    }
}
