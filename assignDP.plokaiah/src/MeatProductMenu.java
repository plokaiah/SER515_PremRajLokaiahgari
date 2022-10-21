import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeatProductMenu extends JFrame implements ProductMenu{
    private Person person_2;
    private JButton add_Button,view_Button,product_list,attached_product_list,select_product_list;

    public MeatProductMenu(Person person) throws HeadlessException {
        this.person_2 = person;
    }
    
    @Override
    public void showMenu() {
        showAddButton();
        showViewButton();
        product_list=new JButton("Product List must be created");
        product_list.setBounds(50,150,350,25);
        add(product_list);
        product_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                App.facade.createProductList();
            }
        });

        attached_product_list=new JButton("Products that are attached");
        attached_product_list.setBounds(50,200,350,25);
        add(attached_product_list);
        attached_product_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                App.facade.attachProductToUser();
            }
        });

        select_product_list=new JButton("Select product must be created");
        select_product_list.setBounds(50,250,350,25);
        add(select_product_list);

        select_product_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                App.facade.selectProduct();
            }
        });;

        setLayout(null);
        setVisible(true);
        setSize(550,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Meat_Product_Menu");

    }

    @Override
    public void showAddButton() {
    	add_Button=new JButton("Trade can be added by clicking this button");
    	add_Button.setBounds(50,50,350,25);
        add(add_Button);

        add_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                App.facade.addTrading();
            }
        });
    }

    @Override
    public void showViewButton() {
    	view_Button=new JButton("Trade can be viewed by clicking this button");
    	view_Button.setBounds(50,100,350,25);
        add(view_Button);

        view_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                App.facade.viewTrading();
            }
        });
    }

    @Override
    public void showRadioButton() {}

    @Override
    public void showLabels() {}

    @Override
    public void showComboxes() {}
}

