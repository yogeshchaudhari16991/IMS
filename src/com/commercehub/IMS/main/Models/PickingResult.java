package com.commercehub.IMS.main.Models;

import com.commercehub.IMS.main.Abstracts.AbstractResult;
import com.commercehub.IMS.main.Enums.ResultStatus;

/**
 * Created by yoges on 7/20/2016.
 */
public class PickingResult extends AbstractResult {

    private int requestedLevel;
    private int currentLevel;

    public PickingResult(){
        super();
    }

    public PickingResult(ResultStatus resultStatus, String productID, int requestedLevel, int currentLevel){
        this();
        this.setResultStatus(resultStatus);
        this.setProductID(productID);
        this.setRequestedLevel(requestedLevel);
        this.setCurrentLevel(currentLevel);
    }

    public int getRequestedLevel() {
        return requestedLevel;
    }

    public void setRequestedLevel(int requestedLevel) {
        this.requestedLevel = requestedLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PickingResult{");
        sb.append("\nRequested Product ID: ");
        sb.append(this.getProductID());
        sb.append(";");
        sb.append("\nRequest Result: ");
        sb.append(this.getResultStatus().getMessage());
        sb.append(";");
        sb.append("\nInventory Level Requested to Pick: ");
        sb.append(this.getRequestedLevel());
        sb.append(";");
        sb.append("\nCurrent Inventory Level: ");
        sb.append(this.getCurrentLevel());
        sb.append(";");
        sb.append('}');
        return sb.toString();
    }
}
