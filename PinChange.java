import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class PinChange extends JFrame implements ActionListener{

    JButton change,back;
    JTextField pt,rpt;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img= i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,900,800);
        add(image);


        JLabel text=new JLabel("CHANGE PIN  ");
        text.setForeground(Color.white);
        text.setFont(new Font("Arial",Font.BOLD,16));
        text.setBounds(285,280,700,35);
        image.add(text);

        JLabel pintext=new JLabel("New Pin: ");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("Arial",Font.BOLD,16));
        pintext.setBounds(185,320,180,25);
        image.add(pintext);

        pt=new JTextField();
        pt.setBounds(320,320,180,20);
        image.add(pt);


        JLabel repintext=new JLabel("Re-Enter Pin: ");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("Arial",Font.BOLD,16));
        repintext.setBounds(185,360,200,25);
        image.add(repintext);

        rpt=new JTextField();
        rpt.setBounds(320,360,180,20);
        image.add(rpt);


        change=new JButton("Change");
        change.addActionListener(this);
        change.setBounds(285,400,100,25);
        image.add(change);

        back=new JButton("Back");
        back.addActionListener(this);
        back.setBounds(285,440,100,25);
        image.add(back);


        setUndecorated(true);
        setSize(900,800);
        setLocation(300,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change){
            try
            {
                String npin = pt.getText();
                String rpin = rpt.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Enter correctly!");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter PIN!");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter PIN!");
                    return;
                }

                Conn conn=new Conn();
                String query1="Update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2="Update login set Pin = '"+rpin+"'where Pin = '"+pinnumber+"'";
                String query3="Update signupthree set Pin = '"+rpin+"'where Pin = '"+pinnumber+"'";

                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                conn.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Updated Successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
