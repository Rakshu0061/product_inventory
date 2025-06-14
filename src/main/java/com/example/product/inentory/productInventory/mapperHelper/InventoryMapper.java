package com.example.product.inentory.productInventory.mapperHelper;

import com.example.product.inentory.productInventory.dto.InventoryDto;
import com.example.product.inentory.productInventory.entity.Inventory;
import com.example.product.inentory.productInventory.entity.Product;

public class InventoryMapper {

//Dto to Entity
    public static Inventory toEntity(InventoryDto dto, Product product)
    {
        Inventory inventory=new Inventory();
        inventory.setAvailableQuantity(dto.getAvailableQuantity());
        inventory.setLastUpdated(dto.getLastUpdated());
        inventory.setProduct(product);
        return inventory;
    }

//Entity to dto
    public static  InventoryDto toDto(Inventory inventory)
    {
        InventoryDto inventoryDto=new InventoryDto();
        inventoryDto.setInventoryId(inventory.getInventoryId());
        inventoryDto.setAvailableQuantity(inventory.getAvailableQuantity());
        inventoryDto.setLastUpdated(inventory.getLastUpdated());

        if (inventory.getProduct()!=null)
        {
            inventoryDto.setProdId(inventory.getProduct().getProdId());
        }

         return inventoryDto;

    }


}
