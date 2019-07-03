package cn.czfshine.app.store.service.impl;

import cn.czfshine.app.store.dao.StorageServiceMapper;
import cn.czfshine.app.store.model.pojo.Storage;
import cn.czfshine.app.store.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageServiceMapper storageServiceMapper;

    @Override
    public List<Storage> getAllStorage() {
        return storageServiceMapper.getAllStorage();
    }
}
