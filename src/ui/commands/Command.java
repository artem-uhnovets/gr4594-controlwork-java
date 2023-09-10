package ui.commands;

import ui.ConsoleView;

public abstract class Command {
    String description;
    ConsoleView consoleView;

    public Command(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(String text);
}
