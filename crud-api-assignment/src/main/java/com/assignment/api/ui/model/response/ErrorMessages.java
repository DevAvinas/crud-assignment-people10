/**
 
@author Avinash_Kumar


 */
package com.assignment.api.ui.model.response;

public enum ErrorMessages {

  
    INTERNAL_SERVER_ERROR("Internal server error"),
    RECORD_NOT_FOUND("Record not Found");
    

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}