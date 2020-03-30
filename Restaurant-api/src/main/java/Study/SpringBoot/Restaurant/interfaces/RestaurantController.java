package Study.SpringBoot.Restaurant.interfaces;

import Study.SpringBoot.Restaurant.domain.Restaurant;
import Study.SpringBoot.Restaurant.domain.RestaurantRepository;
import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //Controller임을 명시
public class RestaurantController {
    //repository = RestaurantRepository 타입의 변수임을 선언
    private RestaurantRepository repository = new RestaurantRepository();

    @GetMapping("/restaurants")
    //이 list 함수는 /restaurants로 접근하는 도메인에 나타낼 내용을 정의할 거야
    public List<Restaurant> list(){

        List<Restaurant> restaurants = repository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){

        Restaurant restaurant = repository.findById(id);

        return restaurant;
    }

}
