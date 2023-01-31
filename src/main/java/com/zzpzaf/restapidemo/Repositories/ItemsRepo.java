package com.zzpzaf.restapidemo.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.zzpzaf.restapidemo.dataObjects.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemsRepo {
    


    public List<Item> getItems() {
        List<Item> itemsList =  new ArrayList<>();

        itemsList.add(new Item(1, "Pencil", 3, 1998, 2.65 ));
        itemsList.add(new Item(2, "Notebook", 3, 2005, 3.75 ));
        itemsList.add(new Item(3, "Eraser Gum", 6, 2017, 1.05 ));

        return itemsList;
    }  
}

