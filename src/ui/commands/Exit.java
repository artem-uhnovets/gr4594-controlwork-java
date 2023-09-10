package ui.commands;

import ui.ConsoleView;

public class Exit extends Command {
    public Exit(ConsoleView consoleView) {
        super(consoleView);
        description = "Выход";
    }

    @Override
    public void execute(String text) {
        consoleView.exit();
    }
}
