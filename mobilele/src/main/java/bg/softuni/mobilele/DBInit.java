package bg.softuni.mobilele;

import bg.softuni.mobilele.model.entities.*;
import bg.softuni.mobilele.model.entities.enums.EngineEnum;
import bg.softuni.mobilele.model.entities.enums.ModelCategory;
import bg.softuni.mobilele.model.entities.enums.TransmissionEnum;
import bg.softuni.mobilele.model.entities.enums.UserRoleEnum;
import bg.softuni.mobilele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository, OfferRepository offerRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
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

        ModelEntity fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);
        createFiestaOffer(fiestaModel);

        initUsers();
    }

    private void initUsers() {
        UserRoleEntity adminRole = new UserRoleEntity();
        adminRole.setRole(UserRoleEnum.ADMIN);
        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setRole(UserRoleEnum.USER);

        userRoleRepository.saveAll(List.of(adminRole,userRole));

        UserEntity admin = new UserEntity();
        admin.setFirstName("Кирил");
        admin.setLastName("Димитров");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("topsecret"));
        admin.setRole(List.of(adminRole,userRole));
        setCurrentTimestamps(admin);
        userRepository.save(admin);

        UserEntity pesho = new UserEntity();
        pesho.setFirstName("Петър");
        pesho.setLastName("Иванов");
        pesho.setUsername("pesho");
        pesho.setPassword(passwordEncoder.encode("topsecret"));
        pesho.setRole(List.of(userRole));
        setCurrentTimestamps(pesho);

        userRepository.saveAll(List.of(admin,pesho));
    }

    private void createFiestaOffer(ModelEntity modelEntity){
        OfferEntity fiestaOffer = new OfferEntity();
        fiestaOffer.setEngine(EngineEnum.GASOLINE);
        fiestaOffer.setImageUrl("https://www.automoli.com/common/vehicles/_assets/img/gallery/f87/ford-fiesta-active.jpg");
        fiestaOffer.setMileage(80000);
        fiestaOffer.setPrice(BigDecimal.valueOf(10000));
        fiestaOffer.setYear(2022);
        fiestaOffer.setDescription("Karana e ot nemska baba. Zimata v garaj.");
        fiestaOffer.setTransmission(TransmissionEnum.MANUAL);
        fiestaOffer.setModel(modelEntity);
        setCurrentTimestamps(fiestaOffer);

        offerRepository.save(fiestaOffer);
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
