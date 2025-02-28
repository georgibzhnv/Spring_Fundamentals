package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.entities.BrandEntity;
import bg.softuni.mobilele.model.entities.ModelEntity;
import bg.softuni.mobilele.model.view.BrandViewModel;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<ModelEntity>allModels = modelRepository.findAll();
        List<BrandViewModel>result = new ArrayList<>();

        ModelMapper mapper = new ModelMapper();

        allModels.forEach(me->{
            BrandEntity brandEntity= me.getBrand();
            Optional<BrandViewModel>brandViewModelOpt = findByName(result,brandEntity.getName());
            if(!brandViewModelOpt.isPresent()){
                BrandViewModel newBrandViewModel = new BrandViewModel();
                mapper.map(brandEntity,newBrandViewModel);
                result.add(newBrandViewModel);
            }
        });

        return result;
    }
    private static Optional<BrandViewModel> findByName(List<BrandViewModel>allModels, String name){
        return allModels
                .stream()
                .filter(m->m.getName().equals(name)).findAny();
    }
}
