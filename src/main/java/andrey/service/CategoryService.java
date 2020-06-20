package andrey.service;

import andrey.model.entity.Category;
import andrey.model.entity.Name;
import andrey.model.service.CategoryServiceModel;

public interface CategoryService {
    void initCategories();

    CategoryServiceModel findByCategoryName(Name name);

    Category find(Name name);
}
