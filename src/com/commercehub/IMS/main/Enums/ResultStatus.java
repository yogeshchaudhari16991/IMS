package com.commercehub.IMS.main.Enums;

/**
 * Created by yoges on 7/20/2016.
 */
public enum ResultStatus {
    Success("Request Completed!"),
    InsufficientInventory("Insufficient inventory level"),
    NoSuchProduct("Product not available!"),
    InvalidRequest("Invalid Request : product id not specified or requested amount is invalid"),
    ErrorToStock("Error occurred while Restocking");
    private String message;

    ResultStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
