package bg.softuni.mobilele.model.view;

import bg.softuni.mobilele.model.entities.enums.ModelCategory;

public class ModelViewModel {

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModelViewModel{");
        sb.append("name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", startYear=").append(startYear);
        sb.append(", endYear=").append(endYear);
        sb.append('}');
        return sb.toString();
    }
}
