package dev.canessaalvamiguel.springcleanarchitecture.application.port.in;

public interface ISendMoneyPort {
    public boolean sendMoney(SendMoneyCommand command);
}
