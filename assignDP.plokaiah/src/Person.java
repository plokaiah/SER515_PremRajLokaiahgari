import javax.swing.*;

public abstract class Person extends JFrame{
   
    private String password1;
    private ClassProductList classProductList;
    protected Facade facade1;
    private String name1;
    protected ProductMenu productMenu;
    
    public Person(String name, String password, Facade facade) {
        this.name1 = name;
        this.password1 = password;
        this.facade1 = facade;
    }
   
    public void addProductList(Product pro){
        classProductList.add(pro);
    }

    public abstract ProductMenu createProductMenu();
    public abstract void showMenu();
    
    public void showAddButton(){}

    public void showViewButton(){}

    public void showRadioButton() {productMenu.showRadioButton();}

    public void showLabel(){}
}
