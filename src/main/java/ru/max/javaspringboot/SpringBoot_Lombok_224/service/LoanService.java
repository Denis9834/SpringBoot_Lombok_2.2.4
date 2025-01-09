package ru.max.javaspringboot.SpringBoot_Lombok_224.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.max.javaspringboot.SpringBoot_Lombok_224.config.LoanProperties;
import ru.max.javaspringboot.SpringBoot_Lombok_224.model.Car;
import ru.max.javaspringboot.SpringBoot_Lombok_224.model.User;
import ru.max.javaspringboot.SpringBoot_Lombok_224.repository.CarRepository;
import ru.max.javaspringboot.SpringBoot_Lombok_224.repository.UserRepository;

@Service
@AllArgsConstructor
public class LoanService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final IncomeService incomeService;
    private final LoanProperties loanProperties;

    public Double approveLoan(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return 0.0;
        }
        Car car = user.getCar();
        double carPrice = car != null ? car.getPrice() : 0.0;

        double income = incomeService.getUserIncome(userId);
        double maxLoanByIncome = income > loanProperties.getMinimalIncome() ? (income * 12 * loanProperties.getMaxCredit()) : 0.0;
        double maxLoanByCar = carPrice > 1_000_000 ? (carPrice * loanProperties.getCarCredit()) : 0.0;

        return Math.max(maxLoanByIncome, maxLoanByCar);
    }
}