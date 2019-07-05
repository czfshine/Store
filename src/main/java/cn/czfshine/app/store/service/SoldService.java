package cn.czfshine.app.store.service;

import java.util.HashMap;
import java.util.List;

public interface SoldService {

    List<HashMap<String, Object>> list(String str);

    void post(HashMap<String, Object> json);
}
