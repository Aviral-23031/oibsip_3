import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JButton deposit,withdraw,fc,ms,pinChange,be,exit;

    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img= i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,900,800);
        add(image);


        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setForeground(Color.white);
        text.setFont(new Font("Arial",Font.BOLD,16));
        text.setBounds(235,280,700,35);
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,370,150,25);
        deposit.setFont(new Font("Arial",Font.BOLD,12));
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Rs 500");
        withdraw.setBounds(350,370,150,25);
        withdraw.setFont(new Font("Arial",Font.BOLD,12));
        withdraw.addActionListener(this);
        image.add(withdraw);

        fc = new JButton("Rs 1000");
        fc.setBounds(170,400,150,25);
        fc.setFont(new Font("Arial",Font.BOLD,12));
        fc.addActionListener(this);
        image.add(fc);

        ms = new JButton("Rs 2000");
        ms.setBounds(350,400,150,25);
        ms.setFont(new Font("Arial",Font.BOLD,12));
        ms.addActionListener(this);
        image.add(ms);

        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(170,430,150,25);
        pinChange.setFont(new Font("Arial",Font.BOLD,12));
        pinChange.addActionListener(this);
        image.add(pinChange);

        be = new JButton("Rs 10000");
        be.setBounds(350,430,150,25);
        be.setFont(new Font("Arial",Font.BOLD,12));
        be.addActionListener(this);
        image.add(be);

        exit = new JButton("Back");
        exit.setBounds(350,460,150,25);
        exit.setFont(new Font("Arial",Font.BOLD,12));
        exit.addActionListener(this);
        image.add(exit);

        setUndecorated(true);
        setSize(900,800);
        setLocation(300,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try
            {
                ResultSet rs = c.statement.executeQuery("Select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(e.getSource() != exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }
                Date date = new Date();
                String query= "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Successfully Debited");

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
