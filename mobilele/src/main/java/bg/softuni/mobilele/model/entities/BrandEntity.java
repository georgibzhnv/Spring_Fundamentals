package bg.softuni.mobilele.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String  toString() {
        final StringBuilder sb = new StringBuilder("BrandEntity{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append('}');
        return sb.toString();
    }
}
