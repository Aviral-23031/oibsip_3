import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdraw,fc,ms,pinChange,be,exit;

    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img= i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,900,800);
        add(image);


        JLabel text=new JLabel("Please select Transaction");
        text.setForeground(Color.white);
        text.setFont(new Font("Arial",Font.BOLD,16));
        text.setBounds(235,280,700,35);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,370,150,25);
        deposit.setFont(new Font("Arial",Font.BOLD,12));
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Cash withdraw");
        withdraw.setBounds(350,370,150,25);
        withdraw.setFont(new Font("Arial",Font.BOLD,12));
        withdraw.addActionListener(this);
        image.add(withdraw);

        fc = new JButton("Fast Cash");
        fc.setBounds(170,400,150,25);
        fc.setFont(new Font("Arial",Font.BOLD,12));
        fc.addActionListener(this);
        image.add(fc);

        ms = new JButton("Mini Statement");
        ms.setBounds(350,400,150,25);
        ms.setFont(new Font("Arial",Font.BOLD,12));
        ms.addActionListener(this);
        image.add(ms);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,430,150,25);
        pinChange.setFont(new Font("Arial",Font.BOLD,12));
        pinChange.addActionListener(this);
        image.add(pinChange);

        be = new JButton("Balance Enquiry");
        be.setBounds(350,430,150,25);
        be.setFont(new Font("Arial",Font.BOLD,12));
        be.addActionListener(this);
        image.add(be);

        exit = new JButton("Exit");
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
                System.exit(0);
            } else if (e.getSource()==deposit) {
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            } else if (e.getSource()==withdraw) {
                setVisible(false);
                new Withdrawl(pinnumber).setVisible(true);
                
            } else if (e.getSource()==fc) {
                setVisible(false);
                new FastCash(pinnumber).setVisible(true);
            } else if (e.getSource()==ms) {

                new MiniStatement(pinnumber).setVisible(true);
            } else if (e.getSource()==pinChange) {
                setVisible(false);
                new PinChange(pinnumber).setVisible(true);
                
            } else if (e.getSource()==be) {
                    setVisible(false);
                    new BalanceEnquiry(pinnumber).setVisible(true);
            }
    }

    public static void main(String[] args) {
      new Transactions("");
    }
}
