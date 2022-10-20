import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Login extends JFrame {

    private final JRadioButton buyer;
    private final JRadioButton seller;
    private volatile int ct;
    private boolean login_id;
    private ArrayList<String> buyer1;
    private ArrayList<String> seller1;
    private int userType;
    private Person per;
    private Facade facade;

    public Login(Facade facade)
    {

        this.facade = facade;
        getBuyers();
        getsellers();
        ct = 0;


        JLabel label_text = new JLabel("Login ID :");
        label_text.setBounds(30,30,110,35);
        this.add(label_text);
        JTextField username_text = new JTextField();
        username_text.setBounds(110,30,160,35);
        add(username_text);

        JLabel passwordLabel_box = new JLabel("Passcode :");
        passwordLabel_box.setBounds(30,80,160,35);
        add(passwordLabel_box);

        JPasswordField password_box = new JPasswordField();
        password_box.setBounds(110,80,160,35);
        add(password_box);

        buyer = new JRadioButton("Buyer");
        buyer.setBounds(90,130,90,30);
        add(buyer);
        seller = new JRadioButton("Seller");
        seller.setBounds(190,130,90,30);
        add(seller);
        buyer.setSelected(true);

        buyer.addActionListener(e -> seller.setSelected(false));
        seller.addActionListener(e -> buyer.setSelected(false));

        JButton button = new JButton("Login");
        button.setBounds(120,180,100,30);
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(buyer.isSelected())
                {
                    if(username_text.getText().isEmpty() || password_box.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"All the fields must be filled.");
                    }
                    else
                    {
                        for(int i=0;i<buyer1.size();i++)
                        {
                            String str[]=buyer1.get(i).split(":");
                            if(username_text.getText().equals(str[0]) && password_box.getText().equals(str[1]))
                            {
                                userType = 0;
                                per = new Buyer(username_text.getText(), password_box.getText(), facade);
                                login_id = true;
                                ct = 1;
                            }

                        }
                       
                        
                    }
                }
                else if(seller.isSelected())
                {
                    if(username_text.getText().isEmpty() || password_box.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"All the fields must be filled.");
                    }
                    else
                    {
                        for(int i=0;i<seller1.size();i++)
                        {
                            String str[]=seller1.get(i).split(":");
                            if(username_text.getText().equals(str[0]) && password_box.getText().equals(str[1]))
                            {
                                userType = 0;
                                per = new Buyer(username_text.getText(), password_box.getText(), facade);
                                login_id = true;
                                ct = 1;
                            }

                        }
                    }
                }

            }
        });



        setLayout(null);
        setSize(400,320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Login");
    }

    private void getBuyers() {
       buyer1 = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("src\\BuyerInfo.txt"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                buyer1.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getsellers() {
        seller1 = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("src\\SellerInfo.txt"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                seller1.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean getResult() {
        while (ct == 0) Thread.onSpinWait();
        return login_id;
    }

    public int getUserType() {
        return userType;
    }

    public Person getPerson() {
        return per;
    }
}
