package ui.menus;

import ui.ConsoleView;
import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandsList;

    public MainMenu(ConsoleView consoleView) {
        commandsList = new ArrayList<>();
        commandsList.add(new OutputConsole(consoleView));
        commandsList.add(new OutputConsolePrizeToys(consoleView));
        commandsList.add(new AddToShop(consoleView));
        commandsList.add(new AddToPrizeList(consoleView));
        commandsList.add(new Lottery(consoleView));
        commandsList.add(new SetFreqWin(consoleView));
        commandsList.add(new SetQuantity(consoleView));
        commandsList.add(new Exit(consoleView));
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getSize(); i++) {
            sb.append(i + 1).append(". ");
            sb.append(commandsList.get(i).getDescription());
            sb.append("\n");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

    public void execute(int option, String data) {
        Command command = commandsList.get(option);
        command.execute(data);
    }

    public int getSize() {
        return commandsList.size();
    }
}
