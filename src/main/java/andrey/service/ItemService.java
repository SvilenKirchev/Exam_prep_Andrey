package andrey.service;

import andrey.model.service.ItemServiceModel;
import andrey.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel>findAllItems();

    ItemViewModel findById(String id);

    void delete(String id);
}
