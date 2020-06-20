package andrey.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntityString{

    private Name name;
    private String description;

    public Category() {

    }

    public Category(Name name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
