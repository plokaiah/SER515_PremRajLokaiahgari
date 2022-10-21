import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProduceProductMenu extends JFrame implements ProductMenu {
    private JButton attached_product_list;
    private JButton add_Button;
    private JButton product_list;
    private JButton view_Button;
    private Person person_1;
    private JButton select_product_list;
    private ArrayList<JLabel> label_1;

    public ProduceProductMenu(Person buyer) {
        this.person_1 = buyer;
    }

    @Override
    public void showMenu() {
        showAddButton();
        showViewButton();
        product_list=new JButton("Please create a list of products");
        product_list.setBounds(50,150,350,25);
        add(product_list);
        product_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event1) {
                App.facade.createProductList();
            }
        });

        attached_product_list=new JButton("products that are attached");
        attached_product_list.setBounds(50,200,350,25);
        add(attached_product_list);
        attached_product_list.addActionListener(new ActionListener() {
           
        	@Override
            public void actionPerformed(ActionEvent event1) {
                App.facade.attachProductToUser();
            }
        });

        select_product_list=new JButton("product that must be selected");
        select_product_list.setBounds(50,250,350,25);
        add(select_product_list);

        select_product_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event1) {
                App.facade.selectProduct();
            }
        });;

        setLayout(null);
        setLocationRelativeTo(null);
        setSize(450,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Meat_Product_Menu");
    }

    @Override
    public void showAddButton() {
    	add_Button=new JButton("Add a trading you would like");
    	add_Button.setBounds(50,50,350,25);
        add(add_Button);

        add_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event1) {
                App.facade.addTrading();
            }
        });
    }

    @Override
    public void showViewButton() {
    	view_Button=new JButton("View all the tradings");
    	view_Button.setBounds(50,100,350,25);
        add(view_Button);

        view_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event1) {
                App.facade.viewTrading();
            }
        });
    }

    @Override
    public void showRadioButton() {}

    @Override
    public void showLabels() {
        for(JLabel l:label_1){
            l.setVisible(true);
        }
    }

    @Override
    public void showComboxes() {}
}
