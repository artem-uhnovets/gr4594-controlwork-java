package ui.commands;

import ui.ConsoleView;

public class Lottery extends Command {
    public Lottery(ConsoleView consoleView) {
        super(consoleView);
        description = "Запустить розыгрыш игрушек";
    }

    @Override
    public void execute(String text) {
        consoleView.Lottery();
    }
}
