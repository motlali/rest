package alid;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void currentTimeShouldReturnTime() throws Exception {

        DateTimeUtils.setCurrentMillisFixed(DateTime.parse("2018-01-16T00:00:00.000-05:00").getMillis());//set Fixed Time for test

        this.mockMvc.perform(get("/time/current")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$").value("2018-01-16T00:00:00.000-05:00"));
    }

    @After
    public void tearDown() {
        DateTimeUtils.setCurrentMillisSystem();// UnSet Fixed Time after test
    }

}
