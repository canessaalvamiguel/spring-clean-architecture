package dev.canessaalvamiguel.springcleanarchitecture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Account {
    private Long id;
    private BigDecimal amount;

    public Boolean isBalanceGreaterThan(BigDecimal amount) {
        return this.amount.compareTo(amount) >= 0;
    }

    public void plus(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public void substract(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
    }

}
