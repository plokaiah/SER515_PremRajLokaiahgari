// Display menu using users factory design pattern

import javax.swing.*;

public class Seller extends Person{
    public Seller(String name, String password, Facade facade) {
        super(name, password, facade);
    }

    @Override
    public ProductMenu createProductMenu() {
        int m = Integer.parseInt(JOptionPane.showInputDialog("1. Meat_Product_Menu\n2. Produce_Product_Menu"));
        super.productMenu = (m==1) ? new MeatProductMenu(this) : new ProduceProductMenu(this);
        return super.productMenu;
    }

    @Override
    public void showMenu() {
        super.productMenu.showMenu();
    }
}
