package com.commercehub.IMS.main.IMS;

import com.commercehub.IMS.main.Enums.ResultStatus;
import com.commercehub.IMS.main.Interfaces.InventoryManagementSystem;
import com.commercehub.IMS.main.Models.*;

import static com.commercehub.IMS.main.Models.ProductExtensions.getLevel;

/**
 * Created by yoges on 7/20/2016.
 */
public class InventoryManagement implements InventoryManagementSystem{

    private static Inventory inventory = new Inventory();

    public static void addToInventory(String productId, String name, String description, String zone, String section, int level){
        inventory.addProductToInventory(productId, name, description, zone, section, level);
    }

    @Override
    public PickingResult pickProduct(String productId, int amountToPick) {
        PickingResult pickingResult = new PickingResult();
        pickingResult.setProductID(productId);
        pickingResult.setRequestedLevel(amountToPick);
        if (productId.isEmpty() || amountToPick <= 0) {
            pickingResult.setResultStatus(ResultStatus.InvalidRequest);
            pickingResult.setCurrentLevel(-1);
        } else {
            if (inventory.getProduct(productId) == null) {
                pickingResult.setResultStatus(ResultStatus.NoSuchProduct);
                pickingResult.setCurrentLevel(-1);
            } else {
                if(inventory.getProduct(productId).pick(amountToPick)){
                    pickingResult.setResultStatus(ResultStatus.Success);
                } else {
                    pickingResult.setResultStatus(ResultStatus.InsufficientInventory);
                }
                pickingResult.setCurrentLevel(getLevel(inventory.getProduct(productId)));
            }
        }
        return pickingResult;
    }

    @Override
    public RestockingResult restockProduct(String productId, int amountToRestock) {
        RestockingResult restockingResult = new RestockingResult();
        restockingResult.setProductID(productId);
        restockingResult.setRestockedLevel(amountToRestock);
        if (productId.isEmpty() || amountToRestock <= 0) {
            restockingResult.setResultStatus(ResultStatus.InvalidRequest);
            restockingResult.setCurrentLevel(-1);
        } else {
            if (inventory.getProduct(productId) == null) {
                restockingResult.setResultStatus(ResultStatus.NoSuchProduct);
                restockingResult.setCurrentLevel(-1);
            } else {
                if(inventory.getProduct(productId).restock(amountToRestock)){
                    restockingResult.setResultStatus(ResultStatus.Success);
                } else {
                    restockingResult.setResultStatus(ResultStatus.ErrorToStock);
                }
                restockingResult.setCurrentLevel(getLevel(inventory.getProduct(productId)));
            }
        }
        return restockingResult;
    }
}
