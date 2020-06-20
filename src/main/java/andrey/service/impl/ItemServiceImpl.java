package andrey.service.impl;

import andrey.model.entity.Item;
import andrey.model.service.CategoryServiceModel;
import andrey.model.service.ItemServiceModel;
import andrey.model.view.ItemViewModel;
import andrey.repository.ItemRepository;
import andrey.service.CategoryService;
import andrey.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

        Item item = this.modelMapper.map(itemServiceModel, Item.class);

        item.setCategory(this.categoryService.find(itemServiceModel.getCategory().getName()));

        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return this.itemRepository.findAll().stream().map(item -> {
            ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

            itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName().name()));

            return itemViewModel;
        }).collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
        return this.itemRepository.findById(id).map(item -> {
            ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

            itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName().name()));

            return itemViewModel;
        }).orElse(null);

    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }
}
