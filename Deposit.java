import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img= i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,900,800);
        add(image);


        JLabel text=new JLabel("Deposit your amount: ");
        text.setForeground(Color.white);
        text.setFont(new Font("Arial",Font.BOLD,16));
        text.setBounds(255,270,700,35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Arial",Font.BOLD,16));
        amount.setBounds(175,320,320,20);

        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(345,395,150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(345,435,150,25);
        back.addActionListener(this);
        image.add(back);


        setUndecorated(true);
        setSize(900,800);
        setLocation(300,0);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==deposit)
        {
            String number = amount.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter amount to deposit ");
            }
            else {
                try {

                    Conn conn=new Conn();
                    String query = "insert into bank values ('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
