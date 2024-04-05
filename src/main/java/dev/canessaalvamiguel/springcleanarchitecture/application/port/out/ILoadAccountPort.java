package dev.canessaalvamiguel.springcleanarchitecture.application.port.out;

import dev.canessaalvamiguel.springcleanarchitecture.domain.Account;

public interface ILoadAccountPort {
    Account load(Long id);
}
