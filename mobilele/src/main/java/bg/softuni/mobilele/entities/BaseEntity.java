package bg.softuni.mobilele.entities;

import jakarta.persistence.*;

import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected Instant created;

    @Column(nullable = false)
    protected Instant updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseEntity{");
        sb.append("id=").append(id);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append('}');
        return sb.toString();
    }
}
