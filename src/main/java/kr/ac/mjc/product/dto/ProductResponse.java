package kr.ac.mjc.product.dto;

import kr.ac.mjc.product.domain.Product;

public class ProductResponse {
    private boolean success;

    private String message;

    private Product product;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
