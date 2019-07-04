package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.SoldServiceMapper;
import cn.czfshine.app.store.service.SoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SoldServiceImpl implements SoldService {


    @Autowired
    private SoldServiceMapper soldServiceMapper;
    @Override
    public List<HashMap<String,Object>> list(String str) {
        return soldServiceMapper.list(str);
    }
}
