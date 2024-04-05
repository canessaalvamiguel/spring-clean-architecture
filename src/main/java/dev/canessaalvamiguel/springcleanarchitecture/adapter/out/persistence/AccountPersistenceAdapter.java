package dev.canessaalvamiguel.springcleanarchitecture.adapter.out.persistence;

import dev.canessaalvamiguel.springcleanarchitecture.application.port.out.ILoadAccountPort;
import dev.canessaalvamiguel.springcleanarchitecture.application.port.out.IUpdateAccountPort;
import dev.canessaalvamiguel.springcleanarchitecture.common.PersistenceAdapter;
import dev.canessaalvamiguel.springcleanarchitecture.domain.Account;

@PersistenceAdapter
public class AccountPersistenceAdapter implements ILoadAccountPort, IUpdateAccountPort {

    private final SpringAccountRepository accountRepository;

    public AccountPersistenceAdapter(SpringAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void update(Account account) {
        accountRepository.save(AccountMapper.domainToEntity(account));
    }

    @Override
    public Account load(Long id) {
        return accountRepository
                .findById(id)
                .map(AccountMapper::entityToDomain)
                .orElseThrow(RuntimeException::new);
    }
}
