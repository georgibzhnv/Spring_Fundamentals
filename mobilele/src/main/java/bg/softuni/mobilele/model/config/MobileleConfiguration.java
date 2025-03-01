package bg.softuni.mobilele.model.config;

import bg.softuni.mobilele.model.entities.ModelEntity;
import bg.softuni.mobilele.model.view.ModelViewModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobileleConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
