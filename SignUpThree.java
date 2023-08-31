import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;


public class SignUpThree extends JFrame implements ActionListener{
    JButton cancel, submit;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    SignUpThree(String formno){
        this.formno=formno;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel personalDetails =new JLabel("Page3: Account Details ");
        personalDetails.setBounds(280,10,400,40);
        personalDetails.setFont(new Font("Ubuntu",Font.BOLD,22));
        add(personalDetails);


        JLabel type =new JLabel("Account type");
        type.setBounds(100,90,200,30);
        type.setFont(new Font("Algerian",Font.PLAIN,22));
        add(type);


        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Arial",Font.PLAIN,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,150,200,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit");
        r2.setFont(new Font("Arial",Font.PLAIN,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,150,150,20);
        add(r2);

        r3=new JRadioButton("Current Deposit");
        r3.setFont(new Font("Arial",Font.PLAIN,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,190,200,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit");
        r4.setFont(new Font("Arial",Font.PLAIN,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,190,200,20);
        add(r4);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel card =new JLabel("Card Number: ");
        card.setBounds(100,250,200,30);
        card.setFont(new Font("Algerian",Font.PLAIN,22));
        add(card);

        JLabel number =new JLabel("XXXX-XXXX-XXXX-4184 ");
        number.setBounds(330,250,300,30);
        number.setFont(new Font("Ubuntu",Font.PLAIN,22));
        add(number);


        JLabel carddetail=new JLabel("Your 16 digit card number:  ");
        carddetail.setBounds(100,280,300,20);
        carddetail.setFont(new Font("Ubuntu",Font.PLAIN,12));
        add(carddetail);


        JLabel pin =new JLabel("PIN: ");
        pin.setBounds(100,330,200,30);
        pin.setFont(new Font("Algerian",Font.PLAIN,22));
        add(pin);

        JLabel pnumber =new JLabel("XXXX");
        pnumber.setBounds(330,330,300,30);
        pnumber.setFont(new Font("Ubuntu",Font.PLAIN,22));
        add(pnumber);


        JLabel pindetail=new JLabel("Your 4 digit password:  ");
        pindetail.setBounds(100,360,300,20);
        pindetail.setFont(new Font("Ubuntu",Font.PLAIN,12));
        add(pindetail);

        JLabel service =new JLabel("Services Required: ");
        service.setBounds(100,410,200,30);
        service.setFont(new Font("Algerian",Font.PLAIN,18));
        add(service);

        c1=new JCheckBox("ATM card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Arial",Font.PLAIN,16));
        c1.setBounds(100,460,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Arial",Font.PLAIN,16));
        c2.setBounds(350,460,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Arial",Font.PLAIN,16));
        c3.setBounds(100,510,200,30);
        add(c3);

        c4=new JCheckBox("Email & SMS alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Arial",Font.PLAIN,16));
        c4.setBounds(350,510,200,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Arial",Font.PLAIN,16));
        c5.setBounds(100,560,200,30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Arial",Font.PLAIN,16));
        c6.setBounds(350,560,200,30);
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Arial",Font.PLAIN,12));
        c7.setBounds(100,610,500,30);
        add(c7);

        cancel = new JButton("Cancel");
        cancel.setBounds(400,660,230,30);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(100,660,230,30);
        submit.setForeground(Color.white);
        submit.setBackground(Color.DARK_GRAY);
        submit.addActionListener(this);
        add(submit);



        setUndecorated(true);
        setSize(800,820);
        setLocation(350,0);
        setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Savings Account";
            } else if (r2.isSelected()) {
                accountType="Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType="Current Account";
            } else if (r4.isSelected()) {
                accountType="Recurring Deposit";
            }

            Random r=new Random();
            String cardnumber = ""+ Math.abs((r.nextLong()% 90000000L)+ 5040936000000000L);

            String pinnumber = ""+  Math.abs((r.nextLong()% 9000L)+ 1000L);

             String facility = "";
             if(c1.isSelected()){
                 facility =facility+" ATM card";
             }
            if(c2.isSelected()){
                facility =facility+" Internet Banking";
            }
            if(c3.isSelected()){
                facility =facility+" Mobile Banking";
            }
            if(c4.isSelected()){
                facility =facility+" Email & SMS alerts";
            }
            if(c5.isSelected()){
                facility =facility+" Cheque Book";
            }
            if(c6.isSelected()){
                facility =facility+" E-Statement";
            }
            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select account type" );
                }
                else {
                    Conn conn=new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.statement.executeUpdate(query1);
                    conn.statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n"+"PIN: "+pinnumber);
                    new Deposit(pinnumber).setVisible(true);

                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (e.getSource()==cancel) {
               setVisible(false);
               new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpThree(" ");
    }
}
