package cn.czfshine.app.store.model.pojo;

import java.math.BigDecimal;

public class Sold {
    private Integer id;

    private Integer count;

    private BigDecimal pricing;

    private Integer productProid;

    private Integer storeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPricing() {
        return pricing;
    }

    public void setPricing(BigDecimal pricing) {
        this.pricing = pricing;
    }

    public Integer getProductProid() {
        return productProid;
    }

    public void setProductProid(Integer productProid) {
        this.productProid = productProid;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}