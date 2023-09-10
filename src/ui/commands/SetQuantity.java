package ui.commands;

import ui.ConsoleView;

public class SetQuantity extends Command {
    public SetQuantity(ConsoleView consoleView) {
        super(consoleView);
        description = "Установить количество игрушек";
    }

    @Override
    public void execute(String text) {
        consoleView.SetQuantity();
    }
}
