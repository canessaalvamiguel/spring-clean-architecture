package dev.canessaalvamiguel.springcleanarchitecture.application.service;

import dev.canessaalvamiguel.springcleanarchitecture.application.port.in.ISendMoneyPort;
import dev.canessaalvamiguel.springcleanarchitecture.application.port.in.SendMoneyCommand;
import dev.canessaalvamiguel.springcleanarchitecture.application.port.out.ILoadAccountPort;
import dev.canessaalvamiguel.springcleanarchitecture.application.port.out.IUpdateAccountPort;
import dev.canessaalvamiguel.springcleanarchitecture.common.UseCase;
import dev.canessaalvamiguel.springcleanarchitecture.domain.Account;
import jakarta.transaction.Transactional;

@UseCase
public class SendMoneyService implements ISendMoneyPort {
    private final ILoadAccountPort loadAccountPort;
    private final IUpdateAccountPort updateAccountPort;

    public SendMoneyService(ILoadAccountPort loadAccountPort, IUpdateAccountPort updateAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.updateAccountPort = updateAccountPort;
    }

    @Transactional
    @Override
    public boolean sendMoney(SendMoneyCommand command) {

        Account source = loadAccountPort.load(command.getSourceId());
        Account target = loadAccountPort.load(command.getTargetId());

        if(!source.isBalanceGreaterThan(command.getAmount())) {
            throw new RuntimeException("Source account not have enough balance amount ... ");
        }

        target.plus(command.getAmount());
        source.substract(command.getAmount());

        updateAccountPort.update(source);
        updateAccountPort.update(target);

        return true;
    }
}
