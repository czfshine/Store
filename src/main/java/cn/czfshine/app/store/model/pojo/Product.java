package cn.czfshine.app.store.model.pojo;

public class Product {
    private Integer id;

    private Integer gan;

    private String name;

    private String size;

    private Integer instid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGan() {
        return gan;
    }

    public void setGan(Integer gan) {
        this.gan = gan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Integer getInstid() {
        return instid;
    }

    public void setInstid(Integer instid) {
        this.instid = instid;
    }
}