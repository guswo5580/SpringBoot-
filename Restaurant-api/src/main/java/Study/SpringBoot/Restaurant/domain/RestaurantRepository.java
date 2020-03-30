package Study.SpringBoot.Restaurant.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    //class 내에서 이용할 수 있도록 field로 선언
    private List<Restaurant> restaurants = new ArrayList<>();

    //RestaurantRepository에 대한 생성자
    public RestaurantRepository(){
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(1005L, "Bob zip2", "Seoul1"));
        restaurants.add(new Restaurant(1006L, "Bob zip3", "Seoul2"));
    }

    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();

        return restaurants;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
