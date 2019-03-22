package cn.czfshine.app.store.initer;

import cn.czfshine.app.store.model.*;
import cn.czfshine.app.store.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * 初始化一些数据，供调试
 *
 * @author:czfshine
 * @date:2019/3/21 20:00
 */

@Configuration
@Slf4j
class SetInitData {

    @Bean
    CommandLineRunner initDatabase(InstProductRepository instProductRepository,
                                   ProductRepository productRepository,
                                   TypeRepository typeRepository,
                                   StorageRepository storageRepository,
                                   StoreRepository storeRepository,
                                   SaleRepository saleRepository
    ) {

        return args -> {
            log.info("Preloading data ...");

            //注意外键的顺序

            //商品类别
            Type food = new Type("食品");
            typeRepository.save(food);
            Type yl = new Type("饮料", food);
            typeRepository.save(yl);
            Type ls = new Type("零食", food);
            typeRepository.save(ls);

            Type ryp =new Type("日用品");
            typeRepository.save(ryp);
            Type xfs = new Type("洗发水", ryp);
            typeRepository.save(xfs);

            //商品原型
            InstProduct coco = new InstProduct("可乐",yl);
            instProductRepository.save(coco);
            InstProduct supian = new InstProduct("薯片",ls);
            instProductRepository.save(supian);

            //实际商品
            String[] sizeml = {"250ml", "330ml", "500ml", "1L", "1.5L", "2.5L"};
            String[] sizemg = {"250g", "330g", "500g", "1kg", "1.5kg", "2.5kg"};
            String[] coconames = {"可口可乐", "百事可乐", "无糖可乐"};
            String[] spnames = {"可口薯片", "百事薯片", "无糖薯片"};
            for (int i = 0; i < sizeml.length; i++) {
                for (int j = 0; j < coconames.length; j++) {
                    productRepository.save(new Product(coconames[j], sizeml[i], coco));
                    productRepository.save(new Product(spnames[j], sizemg[i], supian));
                }
            }

            //增加库存数据
            List<Product> all = productRepository.findAll();
            List<Product> products = all.subList(1, 10);

            for (Product p:products
                 ) {
                storageRepository.save(new Storage(p, new Random().nextInt(100)));
            }

            /****增加一个商店***/
            //取库存
            List<Storage> all1 = storageRepository.findAll();

            //增加商品价格
            for (Storage s: all1
                 ) {
                Product product = s.getProduct();
                //todo:随机
                saleRepository.save(new Sale(new BigDecimal("1.00"), product));
            }

            //取商品价格
            List<Sale> all2 = saleRepository.findAll();

            //增加商店对象
            Store store = new Store("华山超市", "华南农业大学华山区学生宿舍",
                    all1, //库存
                    all2);//价格
            storeRepository.save(store);
        };
    }
}
