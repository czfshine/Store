package cn.czfshine.app.store.repository;

import cn.czfshine.app.store.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    private MockMvc mvc;

    @Autowired
    WebApplicationContext wc;

    @Before
    public void beforeSetUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(wc).build();
    }

    @Test
    public void testSave() throws Exception {
        Customer customer = new Customer("test", "add", "tele");
        customerRepository.save(customer);
        mvc.perform(MockMvcRequestBuilders.get("/data/customers")).andDo(print());
    }

}