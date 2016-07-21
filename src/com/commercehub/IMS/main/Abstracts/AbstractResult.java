package com.commercehub.IMS.main.Abstracts;

import com.commercehub.IMS.main.Enums.ResultStatus;

/**
 * Created by yoges on 7/20/2016.
 */
public abstract class AbstractResult {
    private ResultStatus resultStatus;
    private String productID;

    public AbstractResult(){
        super();
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    abstract public String toString();
}
