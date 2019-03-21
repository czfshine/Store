package cn.czfshine.app.store.initer;

import cn.czfshine.app.store.model.InstProduct;
import cn.czfshine.app.store.repository.InstProductRepository;
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
    CommandLineRunner initDatabase(InstProductRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new InstProduct("可乐")));
            log.info("Preloading " + repository.save(new InstProduct("薯片")));
        };
    }
}
