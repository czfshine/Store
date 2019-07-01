package cn.czfshine.app.store.model.pojo;

import java.math.BigDecimal;

public class Sale {
    private Integer id;

    private BigDecimal pricing;

    private Integer proid;

    private Integer storeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPricing() {
        return pricing;
    }

    public void setPricing(BigDecimal pricing) {
        this.pricing = pricing;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}