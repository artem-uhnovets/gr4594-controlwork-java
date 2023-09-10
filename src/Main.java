import model.service.Service;
import model.toy.Toy;
import model.toyshop.ToyShop;
import ui.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ToyShop<Toy> wonderLand = wonderLandShop();
        Service<Toy> service = new Service<>(wonderLand);
        ConsoleView app = new ConsoleView();
        app.getPresenter().setService(service);
        app.start();
    }

    static ToyShop<Toy> wonderLandShop() {
        ToyShop<Toy> wonderLand = new ToyShop<>();
        wonderLand.addToShop(new Toy("Barbie"));
        wonderLand.addToShop(new Toy("Ken"));
        wonderLand.addToShop(new Toy("Lego"));
        wonderLand.addToShop(new Toy("Teddy"));
        wonderLand.addToShop(new Toy("Monopoly"));
        wonderLand.addToShop(new Toy("Uno"));
        wonderLand.addToShop(new Toy("GameBoy"));
        wonderLand.addToShop(new Toy("NintendoSwitch"));
        wonderLand.addToShop(new Toy("NintendoSwitch"));
        wonderLand.addToShop(new Toy("NintendoSwitch"));
        wonderLand.addToShop(new Toy("NintendoSwitch"));
        return wonderLand;
    }

}