package bg.softuni.mobilele.model.view;

import bg.softuni.mobilele.model.entities.enums.ModelCategory;

public class ModelViewModel {

    private long id;
    private String name;
    private ModelCategory category;
    private String imageUrl;
    private int startYear;
    private Integer endYear;

    public String getName() {
        return name;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(ModelCategory category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModelViewModel{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", startYear=").append(startYear);
        sb.append(", endYear=").append(endYear);
        sb.append('}');
        return sb.toString();
    }
}
