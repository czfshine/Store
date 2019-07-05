package cn.czfshine.app.store.model.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    private Integer id;
    private Boolean del;
    private Date ordertime;
    private Integer customerId;
}