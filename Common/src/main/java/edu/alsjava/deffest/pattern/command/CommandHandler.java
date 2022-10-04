package edu.alsjava.deffest.pattern.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
