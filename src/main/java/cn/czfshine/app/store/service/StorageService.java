package cn.czfshine.app.store.service;

import java.util.HashMap;
import java.util.List;

public interface StorageService {
    List<HashMap<String,Object>> getAllStorage(String searchStr);

    Integer getCount(Integer gan);
}
