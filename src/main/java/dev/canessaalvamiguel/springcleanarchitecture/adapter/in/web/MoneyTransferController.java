package dev.canessaalvamiguel.springcleanarchitecture.adapter.in.web;

import dev.canessaalvamiguel.springcleanarchitecture.application.port.in.SendMoneyCommand;
import dev.canessaalvamiguel.springcleanarchitecture.application.service.SendMoneyService;
import dev.canessaalvamiguel.springcleanarchitecture.common.WebAdapter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@WebAdapter
@RestController
public class MoneyTransferController {

    private final SendMoneyService sendMoneyService;

    public MoneyTransferController(SendMoneyService sendMoneyService) {
        this.sendMoneyService = sendMoneyService;
    }

    @PostMapping(path = "/accounts/transfer/{sourceAccountId}/{targetAccountId}/{amount}")
    void transfer(
        @PathVariable("sourceAccountId") Long sourceAccountId,
        @PathVariable("targetAccountId") Long targetAccountId,
        @PathVariable("amount") BigDecimal  amount
    ){
        SendMoneyCommand command = new SendMoneyCommand(sourceAccountId, targetAccountId, amount);
        sendMoneyService.sendMoney(command);
    }
}
