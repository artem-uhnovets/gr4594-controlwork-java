package ui.commands;

import ui.ConsoleView;

public class SetFreqWin extends Command {
    public SetFreqWin(ConsoleView consoleView) {
        super(consoleView);
        description = "Установить вероятность выигрыша";
    }

    @Override
    public void execute(String text) {
        consoleView.SetFreqWin();
    }
}
