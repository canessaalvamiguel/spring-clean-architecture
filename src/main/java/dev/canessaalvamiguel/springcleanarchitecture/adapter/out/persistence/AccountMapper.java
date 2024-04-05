package dev.canessaalvamiguel.springcleanarchitecture.adapter.out.persistence;

import dev.canessaalvamiguel.springcleanarchitecture.domain.Account;

public class AccountMapper {
    public static Account entityToDomain(AccountEntity accountEntity) {
        return new Account(accountEntity.getId(), accountEntity.getAmount());
    }

    public static AccountEntity domainToEntity(Account account) {
        return new AccountEntity(account.getId(), account.getAmount());
    }
}
