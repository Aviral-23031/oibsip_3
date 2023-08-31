

//Login class - The first frame
// all the necessary import statements required for the class to run


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.ResultSet;


//JFrame is for creating swing based applications and
// Action Listener provides a method with which we can assign what happens when a button is clicked
// it is necessary to override the actionPerformed method otherwise it gives error


public class Login extends JFrame implements ActionListener {

    JButton signin,signup,clear;
    JTextField tf;
        JPasswordField pf;

        Login(){
            super("AUTOMATED TELLER MACHINE"); //Title
            getContentPane().setBackground(Color.white); //sets frame color white
            setLayout(null);
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
            Image img= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon i2=new ImageIcon(img);
            JLabel image=new JLabel(i2);
            image.setBounds(150,10,100,100);
            add(image);

            //the above lines of code are for adding a single image
            //we take this many steps because we can't directly add the ImageIcon or Image object
            //that is why back and forth there and then we put it in JLabel


            //normal headings
            JLabel heading = new JLabel("Welcome to ATM");
            heading.setBounds(250,40,350,40);
            heading.setFont(new Font("Roboto",Font.BOLD,40));
            add(heading);

            JLabel cardno = new JLabel("Card No.: ");
            cardno.setBounds(175,140,350,40);
            cardno.setFont(new Font("Roboto",Font.BOLD,22));
            add(cardno);


            //textfield, the blank space where you write stuff
            tf = new JTextField();
            tf.setBounds(350,145,230,30);
            add(tf);

            JLabel pin = new JLabel("PIN: ");
            pin.setBounds(175,200,350,40);
            pin.setFont(new Font("Roboto",Font.BOLD,22));
            add(pin);

            //similar like textfield but now you can't see numbers
            pf = new JPasswordField();
            pf.setBounds(350,205,230,30);
            add(pf);


            //creating three buttons
            signin = new JButton("Sign in");
            signin.setBounds(350,250,230,30);
            signin.setForeground(Color.white);
            signin.setBackground(Color.DARK_GRAY);
            signin.addActionListener(this);
            add(signin);

            signup = new JButton("Sign up");
            signup.setBounds(350,290,230,30);
            signup.setForeground(Color.white);
            signup.setBackground(Color.DARK_GRAY);
            signup.addActionListener(this);
            add(signup);

            clear = new JButton("CLEAR");
            clear.setBounds(350,330,230,30);
            clear.setForeground(Color.white);
            clear.setBackground(Color.DARK_GRAY);
            clear.addActionListener(this);
            add(clear);


            //these statements are a must to be in a JFrame program
            setSize(800,480); //specifies size
            setVisible(true); //defines visibility (the frame only appears when setVisible is set to true)
            setLocation(300,160); // where on the screen
        }



    @Override
    public void actionPerformed(ActionEvent e) {

            //the main logic of every java class like this is going to lie here

            if(e.getSource()==signin){
                   Conn c=new Conn();
                   String cardnumber = tf.getText();
                   String pinnumber= pf.getText();


                   String query = "select * from login where CardNumber ='"+cardnumber+"' and Pin = '"+pinnumber+"' ";
                   try{
                       ResultSet rs=c.statement.executeQuery(query);
                       if (rs.next()){
                           setVisible(false);
                           new Transactions(pinnumber);
                       }else {
                           JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin!");
                       }
                   } catch (Exception ex) {
                       throw new RuntimeException(ex);
                   }
            } else if (e.getSource()==signup) {
                setVisible(false);
                  new SignUpOne();
            }
            else {
                tf.setText("");
                pf.setText("");
            }
    }

    public static void main(String[] args) {
        new Login();
    }
}
