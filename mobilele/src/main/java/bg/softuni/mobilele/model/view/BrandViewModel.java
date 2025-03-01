package bg.softuni.mobilele.model.view;

import java.util.ArrayList;
import java.util.List;

public class BrandViewModel {

    private String name;
    private List<ModelViewModel>models=new ArrayList<>();

    public BrandViewModel addModel(ModelViewModel modelViewModel){
        this.models.add(modelViewModel);
        return this;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }

    public void setModels(List<ModelViewModel> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
