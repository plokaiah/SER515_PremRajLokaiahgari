//bridge pattern used for facade pattern

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Facade {
    private int userType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList=new ClassProductList();
    private Person thePerson;

    public boolean login() {
        Login login = new Login(this);
        login.setVisible(true);
        boolean x = login.getResult();
        userType = login.getUserType();
        thePerson = login.getPerson();
        login.dispose();
        return x;
    }

    public void addTrading(){
        if(userType == 0)
        {
            JOptionPane.showMessageDialog(null, "It shows the addition of trading for buyer");
        }else{
            JOptionPane.showMessageDialog(null, "It shows the addition of trading for seller");
        }
        
    }

    public void viewTrading(){
        if(userType == 0){
            JOptionPane.showMessageDialog(null, "It shows the view menu of trading for buyer to view trading");
        }else {
            JOptionPane.showMessageDialog(null, "It shows the view menu of trading for seller to view trading");
        }
    }

    public void viewOffering(){

    }

    public void markOffering(){

    }

    public void submitOffering(){

    }

    public void remind(){

    }

    public void createUser(){

    }

    public void createProductList(){
        try {
            Scanner read = new Scanner(new File("ProductInfo.txt"));
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
            Scanner read2 = new Scanner(new File("UserProduct.txt"));
            while (read2.hasNextLine()){
                String mat2[] = read2.nextLine().split(":");
                if(mat2[0].equals(thePerson.getName())) {
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
                        thePerson.addProductList(product);
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
        while(k++ <theProductList.size()) {
        	productList += k +" "+ theProductList.get(k).getName() +"\n";
        }
        int case1 = Integer.parseInt(JOptionPane.showInputDialog(productList));
        if(case1 > 0 && case1 < theProductList.size())
            theSelectedProduct = theProductList.get(case1);
        else {
        	
        }
    }

    public void productOperation(){

    }

    public void accept(ReminderVisitor reminderVisitor) {
    }

    public Person getThePerson() {
        return thePerson;
    }
}
