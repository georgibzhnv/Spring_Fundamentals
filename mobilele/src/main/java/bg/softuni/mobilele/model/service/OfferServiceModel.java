package bg.softuni.mobilele.model.service;
import bg.softuni.mobilele.model.entities.enums.EngineEnum;
import bg.softuni.mobilele.model.entities.enums.TransmissionEnum;
import bg.softuni.mobilele.model.validation.YearInPastOrPresent;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class OfferServiceModel {

    @NotNull
    private EngineEnum engine;
    @NotEmpty
    private String imageUrl;
    @NotNull
    @Positive
    private Integer mileage;
    @NotNull
    @DecimalMin("100")
    private BigDecimal price;
    @YearInPastOrPresent(minYear = 1930)
    private Integer year;
    @NotEmpty
    @Size(min = 10,max=512)
    private String description;
    @NotNull
    private TransmissionEnum transmission;
    @NotNull
    private Long modelId;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OfferServiceModel{");
        sb.append("engine=").append(engine);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", mileage=").append(mileage);
        sb.append(", price=").append(price);
        sb.append(", year=").append(year);
        sb.append(", description='").append(description).append('\'');
        sb.append(", transmission=").append(transmission);
        sb.append(", modelId=").append(modelId);
        sb.append('}');
        return sb.toString();
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }
}
