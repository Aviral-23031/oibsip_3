import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnquiry extends JFrame implements ActionListener {
        JButton back;
        String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img= i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,900,800);
        add(image);

        back=new JButton("Back");
        back.addActionListener(this);
        back.setBounds(285,440,100,25);
        image.add(back);


        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.statement.executeQuery("Select * from bank where pin='" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        JLabel text= new JLabel("Your current account balance is: Rs "+balance);
        text.setBounds(180,285,350,20);
        text.setFont(new Font("Arial",Font.BOLD,12));
        text.setForeground(Color.white);
        image.add(text);


        setUndecorated(true);
        setSize(900,800);
        setLocation(300,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
