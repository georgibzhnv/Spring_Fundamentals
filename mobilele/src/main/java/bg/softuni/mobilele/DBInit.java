package bg.softuni.mobilele;

import bg.softuni.mobilele.model.entities.BaseEntity;
import bg.softuni.mobilele.model.entities.BrandEntity;
import bg.softuni.mobilele.model.entities.ModelEntity;
import bg.softuni.mobilele.model.entities.enums.ModelCategory;
import bg.softuni.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.repository.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);


        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand,hondaBrand));

        initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);
    }


    private ModelEntity initEscort(BrandEntity ford) {
        ModelEntity escort = new ModelEntity();
        escort.setName("Escort");
        escort.setCategory(ModelCategory.CAR);
        escort.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Ford_Escort_MkI_1100_1972.JPG/420px-Ford_Escort_MkI_1100_1972.JPG");
        escort.setStartYear(1976);
        escort.setEndYear(2002);
        escort.setBrand(ford);
        setCurrentTimestamps(escort);

        return modelRepository.save(escort);
    }
    
    private ModelEntity initNC750S(BrandEntity honda) {
        ModelEntity nc750s = new ModelEntity();
        nc750s.setName("NC750");
        nc750s.setCategory(ModelCategory.MOTORCYCLE);
        nc750s.setImageUrl("https://motorcycles.honda.bg/wp-content/uploads/sites/4/2024/10/411163_23ym_honda_nc750x1.jpg");
        nc750s.setStartYear(2014);
        nc750s.setBrand(honda);
        setCurrentTimestamps(nc750s);

        return modelRepository.save(nc750s);
    }

    private ModelEntity initFiesta(BrandEntity ford) {
        ModelEntity fiesta = new ModelEntity();
        fiesta.setName("Fiesta");
        fiesta.setCategory(ModelCategory.CAR);
        fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/413px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        fiesta.setStartYear(1976);
        fiesta.setBrand(ford);
        setCurrentTimestamps(fiesta);

        return modelRepository.save(fiesta);
    }

    private static void setCurrentTimestamps(BaseEntity baseEntity){
        baseEntity.setUpdated(Instant.now());
        baseEntity.setCreated(Instant.now());
    }
}
