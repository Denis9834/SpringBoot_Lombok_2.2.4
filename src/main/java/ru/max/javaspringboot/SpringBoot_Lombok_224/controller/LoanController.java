package ru.max.javaspringboot.SpringBoot_Lombok_224.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.max.javaspringboot.SpringBoot_Lombok_224.service.LoanService;

@Controller
@AllArgsConstructor
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<Double> getCredit(@RequestParam(value = "userId", required = false) Long userId) {
        Double loan = loanService.approveLoan(userId);
        return ResponseEntity.ok(loan);
    }
}
