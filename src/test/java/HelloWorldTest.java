import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springboot.HelloWorld;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldTest {
	private MockMvc mockMvc;
	
    @InjectMocks
    private HelloWorld helloWorld;
    
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorld)
                .build();
    }
    
    @Test
    public void locByIdTest() throws Exception{
           mockMvc.perform(get("/")
                  .accept(MediaType.APPLICATION_JSON))
                  .andExpect(status().isOk())
                  .andExpect(jsonPath("$", Matchers.is("hello world!!")));
           
    }

}
