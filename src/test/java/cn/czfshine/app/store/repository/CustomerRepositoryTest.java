package cn.czfshine.app.store.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerRepositoryTest {
//    @Autowired
//    private CustomerRepository customerRepository;

    private MockMvc mvc;

    @Autowired
    WebApplicationContext wc;

    @Before
    public void beforeSetUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(wc).build();
    }

    @Test
    public void testSave() throws Exception {
//        Customer customer = new Customer("test", "add", "tele");
//        customerRepository.save(customer);
//        mvc.perform(MockMvcRequestBuilders.get("/data/customers")).andDo(print());
    }

}