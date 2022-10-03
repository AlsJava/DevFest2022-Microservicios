package edu.alsjava.deffest.patterns.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
