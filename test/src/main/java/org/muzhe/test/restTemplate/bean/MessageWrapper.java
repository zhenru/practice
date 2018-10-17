package org.muzhe.test.restTemplate.bean;

public class MessageWrapper {

    private Customer wrapped;
    private String message;

    public MessageWrapper(Customer wrapped, String message) {
        this.wrapped = wrapped;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Customer getWrapped() {
        return wrapped;
    }

}
