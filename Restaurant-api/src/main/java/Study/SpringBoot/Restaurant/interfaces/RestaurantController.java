package Study.SpringBoot.Restaurant.interfaces;

import Study.SpringBoot.Restaurant.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //Controller임을 명시
public class RestaurantController {

    @GetMapping("/restaurants")
    //이 list 함수는 /restaurants로 접근하는 도메인에 나타낼 내용을 정의할 거야
    public List<Restaurant> list(){
        List<Restaurant> restaurants = new ArrayList<Restaurant>();

        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

        restaurants.add(restaurant);

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(1005L, "Bob zip2", "Seoul1"));
        restaurants.add(new Restaurant(1006L, "Bob zip3", "Seoul2"));

        Restaurant restaurant = restaurants.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);

        return restaurant;
    }

}
