import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.SQLException;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img= i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,900,800);
        add(image);


        JLabel text=new JLabel("Enter amount to withdraw: ");
        text.setForeground(Color.white);
        text.setFont(new Font("Arial",Font.BOLD,16));
        text.setBounds(235,270,700,35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Arial",Font.BOLD,16));
        amount.setBounds(175,320,320,20);

        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(345,395,150,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

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

        if(e.getSource()==withdraw)
        {
            String number = amount.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter amount to withdraw ");
            }
            else {
                try {

                    Conn conn=new Conn();
                    String query = "insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawn Successfully");
                    setVisible(false);
                    new FastCash(pinnumber).setVisible(true);
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
        new Withdrawl("");
    }
}
