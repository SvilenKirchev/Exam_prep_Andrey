package andrey.model.service;

import andrey.model.entity.Name;

public class CategoryServiceModel {
    private Name name;
    private String description;

    public CategoryServiceModel() {

    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
