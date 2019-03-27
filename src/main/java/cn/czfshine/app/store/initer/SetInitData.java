package cn.czfshine.app.store.initer;

import cn.czfshine.app.store.model.*;
import cn.czfshine.app.store.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    //从CustomerRepository开始的5个参数是新增的
    @Bean
    CommandLineRunner initDatabase(InstProductRepository instProductRepository,
                                   ProductRepository productRepository,
                                   TypeRepository typeRepository,
                                   StorageRepository storageRepository,
                                   StoreRepository storeRepository,
                                   SaleRepository saleRepository,
                                   CustomerRepository customerRepository,
                                   OrderItemRepository orderItemRepository,
                                   OrdersRepository ordersRepository,
                                   SoldRepository soldRepository,
                                   VendorRepository vendorRepository

    ) {

        return args -> {
            if(productRepository.count()==0)
                //如果数据库没有数据的话才装填数据进去
                initData(instProductRepository, productRepository, typeRepository, storageRepository, storeRepository, saleRepository, customerRepository, soldRepository, vendorRepository);
        };
    }
    private void initData(InstProductRepository instProductRepository, ProductRepository productRepository, TypeRepository typeRepository, StorageRepository storageRepository, StoreRepository storeRepository, SaleRepository saleRepository, CustomerRepository customerRepository, SoldRepository soldRepository, VendorRepository vendorRepository) {
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
        //为后面sold信息的添加专门做两个product
        Product soldProduct1 = new Product("零度可乐","1.5L",coco);
        Product soldProduct2 = new Product("可比克薯片","330g",supian);
        productRepository.save(soldProduct1);
        productRepository.save(soldProduct2);

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
        //增加商店对象
        Store store = new Store("华山超市", "华南农业大学华山区学生宿舍",
                all1);//价格
        storeRepository.save(store);


        //增加商品价格
        for (Storage s: all1
             ) {
            Product product = s.getProduct();
            //todo:随机
            saleRepository.save(new Sale(new BigDecimal("1.00"), product,store));
        }
        //取商品价格
        List<Sale> all2 = saleRepository.findAll();

        //新增customer信息
        Customer c1 = new Customer("张三","广州","8556855");
        Customer c2 = new Customer("李四","深圳","0203134");
        Customer c3 = new Customer("王五","珠海","0769257");

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);

        //添加Sold信息
        Sold sold1 = new Sold(store,soldProduct1, new BigDecimal("1500.00"),300);
        Sold sold2 = new Sold(store,soldProduct1, new BigDecimal("200"),50);
        soldRepository.save(sold1);
        soldRepository.save(sold2);

        //添加Vendor信息
        List<Sold> soldList = new ArrayList<>();
        soldList.add(sold1);
        soldList.add(sold2);
        Vendor vendor1 = new Vendor("广州长盛经销商","长兴路",soldList);
        vendorRepository.save(vendor1);
    }
}
