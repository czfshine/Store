package cn.czfshine.app.store.initer;

import cn.czfshine.app.store.model.InstProduct;
import cn.czfshine.app.store.model.Product;
import cn.czfshine.app.store.repository.InstProductRepository;
import cn.czfshine.app.store.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始化一些数据，供调试
 * @author:czfshine
 * @date:2019/3/21 20:00
 */

@Configuration
@Slf4j
class SetInitData {

    @Bean
    CommandLineRunner initDatabase(InstProductRepository instProductRepository,
                                   ProductRepository productRepository) {

        return args -> {
            log.info("Preloading data ..." );

            //商品原型
            InstProduct coco = new InstProduct("可乐");
            instProductRepository.save(coco);
            InstProduct supian = new InstProduct("薯片");
            instProductRepository.save(supian);

            //实际商品
            String[] sizeml={"250ml","330ml","500ml","1L","1.5L","2.5L"};
            String[] sizemg={"250g","330g","500g","1kg","1.5kg","2.5kg"};
            String[] coconames={"可口可乐","百事可乐","无糖可乐"};
            String[] spnames={"可口薯片","百事薯片","无糖薯片"};
            for (int i = 0; i < sizeml.length; i++) {
                for (int j = 0; j < coconames.length; j++) {
                    productRepository.save(new Product(coconames[j],sizeml[i],coco));
                    productRepository.save(new Product(spnames[j],sizemg[i],supian));
                }
            }



        };
    }
}
