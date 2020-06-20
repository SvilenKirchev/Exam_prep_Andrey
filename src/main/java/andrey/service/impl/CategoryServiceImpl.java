package andrey.service.impl;

import andrey.model.entity.Category;
import andrey.model.entity.Name;
import andrey.model.service.CategoryServiceModel;
import andrey.repository.CategoryRepository;
import andrey.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0){
            Arrays.stream(Name.values()).forEach(name -> {
                this.categoryRepository.save(new Category(name, String.format("Description for %s", name.name())));
            });
        }
    }

    @Override
    public CategoryServiceModel findByCategoryName(Name name) {

        return this.categoryRepository.findByName(name).map(category -> this.modelMapper.map(category, CategoryServiceModel.class)).orElse(null);
    }

    @Override
    public Category find(Name name) {
        return this.categoryRepository.findByName(name).orElse(null);
    }
}
