package ru.max.javaspringboot.SpringBoot_Lombok_224.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.max.javaspringboot.SpringBoot_Lombok_224.model.User;

@Service
public class IncomeService {

    private final String URL = "https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income";
    private final RestTemplate restTemplate;

    @Autowired
    public IncomeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public double getUserIncome(Long userId) {
        User[] users = restTemplate.getForObject(URL, User[].class);

        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user.getIncome();
            }
        }
        return 0.0;
    }
}
