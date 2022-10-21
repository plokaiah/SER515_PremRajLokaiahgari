//bridge pattern used for facade pattern

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Facade {
    private int user_Type;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList=new ClassProductList();
    private Person the_Person;

    public boolean login() {
        Login login = new Login(this);
        login.setVisible(true);
        boolean x = login.getResult();
        user_Type = login.getUserType();
        the_Person = login.getPerson();
        login.dispose();
        return x;
    }

    public void addTrading(){
        if(user_Type == 0)
        {
            JOptionPane.showMessageDialog(null, "Showing the addition of trading for buyer");
        }else{
            JOptionPane.showMessageDialog(null, "Showing  the addition of trading for seller");
        }
        
    }

    public void viewTrading(){
        if(user_Type == 0){
            JOptionPane.showMessageDialog(null, "Showing the view menu of trading for buyer to view trading");
        }else {
            JOptionPane.showMessageDialog(null, "Showing the view menu of trading for seller to view trading");
        }
    }

    public void viewOffering(){
    	JOptionPane.showMessageDialog(null, "Showing the view menu of trading to view offering");
    }

    public void markOffering(){
    	JOptionPane.showMessageDialog(null, "Mark the menu of trading to mark offering");

    }

    public void submitOffering(){
    	JOptionPane.showMessageDialog(null, "Submit the offering");

    }

    public void remind(){

    }

    public void createUser(){

    }

    public void createProductList(){
        try {
            Scanner read = new Scanner(new File("src\\ProductInfo.txt"));
            while (read.hasNextLine()){
                String mat[] = read.nextLine().split(":");

                theProductList.add(new Product(mat[1], mat[0]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "User product list");
    }

    public void attachProductToUser(){
        try {
            Scanner read2 = new Scanner(new File("src\\UserProduct.txt"));
            while (read2.hasNextLine()){
                String mat2[] = read2.nextLine().split(":");
                if(mat2[0].equals(the_Person.getName())) {
                    Product product=null;
                    
                    int n=0;
                    while(n++<theProductList.size()) {
                    	Product prem=theProductList.get(n);
                        if(prem.getName().equals(mat2[1])) {
                            product = prem;
                            break;
                    }
                    }
                    if(product != null)
                        the_Person.addProductList(product);
                }

            }
            JOptionPane.showMessageDialog(null, "Attached to the user is a product list");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void selectProduct(){
        String productList = "Please select 1: \n";
       
        int k=0;
        while(k++ <theProductList.size() && k<5) {
        	productList += k +" "+ theProductList.get(k).getName() +"\n";
        }
        int case1 = Integer.parseInt(JOptionPane.showInputDialog(productList));
        if(case1 > 0 && case1 < theProductList.size())
        {
            theSelectedProduct = theProductList.get(case1);
        }
        else {
        	
        }
    }

    public void productOperation(){

    }

    public void accept(ReminderVisitor reminderVisitor) {
    }

    public Person getThePerson() {
        return the_Person;
    }
}
