package Study.SpringBoot.Restaurant.interfaces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class) //RestaurantController 클래스를 Test 하겠다는 의미
class RestaurantControllerTest {
    @Autowired //따로 실행하지 않아도 자동으로 구동하겠다
    private MockMvc mvc;

    @Test //Test 코드임을 명시
    //restaurants로 접근하는 도메인은 다음을 검증할거야 -- 도메인의 내용은 RestaurantController 안에 있어
    public void list() throws Exception { //perform에 대한 예외처리
        //mvc는 field를 이용해 선언
        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk());
                //.andExpect((ResultMatcher) content().string(containsString("\"name\" : \"Bob zip\"")));
    }

    @Test
    //restaurants/1로 접근하는 도메인은 다음을 검증할거야 -- 도메인의 내용은 RestaurantController 안에 있어
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1"))
                .andExpect(status().isOk());
    }
}