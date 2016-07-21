package com.commercehub.IMS.main.model;

import com.commercehub.IMS.main.Abstracts.AbstractResult;
import com.commercehub.IMS.main.Enums.ResultStatus;

/**
 * Created by yoges on 7/20/2016.
 */
public class RestockingResult extends AbstractResult {

    private int restockedLevel;
    private int currentLevel;

    public RestockingResult() {
        super();
    }

    public RestockingResult(ResultStatus resultStatus, String productID, int requestedLevel, int currentLevel){
        this();
        this.setResultStatus(resultStatus);
        this.setProductID(productID);
        this.setRestockedLevel(requestedLevel);
        this.setCurrentLevel(currentLevel);
    }

    public int getRestockedLevel() {
        return restockedLevel;
    }

    public void setRestockedLevel(int restockedLevel) {
        this.restockedLevel = restockedLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RestockingResult{");
        sb.append("\nRequested Product ID: ");
        sb.append(this.getProductID());
        sb.append(";");
        sb.append("\nRequest Result: ");
        sb.append(this.getResultStatus().getMessage());
        sb.append(";");
//        sb.append("\nPrevious Inventory Level: ");
//        sb.append(this.getPreviousLevel());
//        sb.append(";");
        sb.append("\nInventory Level Requested to Restock: ");
        sb.append(this.getRestockedLevel());
        sb.append(";");
        sb.append("\nCurrent Inventory Level: ");
        sb.append(this.getCurrentLevel());
        sb.append(";");
        sb.append('}');
        return sb.toString();
    }
}
