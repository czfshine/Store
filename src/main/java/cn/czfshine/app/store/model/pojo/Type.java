package cn.czfshine.app.store.model.pojo;

import lombok.Data;

@Data
public class Type {
    private Integer id;
    private String name;
    private Integer parentTypeId;
}