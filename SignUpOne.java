import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nf,ff,ef,af,cf,sf,pf,df;
    JButton next,clear;
    JRadioButton male, female, married, unmarried;
    JDateChooser dc;
    SignUpOne(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Random rand = new Random();
         random = Math.abs((rand.nextLong()% 9000L)+1000L);

        JLabel formno =new JLabel("Application Form no. "+random);
        formno.setBounds(210,10,500,40);
        formno.setFont(new Font("Ubuntu",Font.BOLD,35));
        add(formno);

        JLabel personalDetails =new JLabel("Page1: Personal Details ");
        personalDetails.setBounds(310,55,400,30);
        personalDetails.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(personalDetails);


        JLabel name =new JLabel("Name: ");
        name.setBounds(100,140,200,30);
        name.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(name);

         nf= new JTextField();
        nf.setBounds(400,140,300,30);
        add(nf);

        JLabel fname =new JLabel("Father's Name: ");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(fname);


         ff= new JTextField();
        ff.setBounds(400,190,300,30);
        add(ff);

        JLabel dob =new JLabel("Date of Birth: ");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(dob);

         dc=new JDateChooser();
        dc.setBounds(400,240,300,30);
        dc.setForeground(new Color(105,105,105));
        add(dc);

        JLabel gender =new JLabel("Gender: ");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(gender);

          male=new JRadioButton("Male");
        male.setBounds(400,290,60,30);
        male.setBackground(Color.white);
        add(male);

         female=new JRadioButton("Female");
        female.setBounds(550,290,120,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);


        JLabel email =new JLabel("E-mail: ");
        email.setBounds(100,340,200,30);
        email.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(email);

        ef= new JTextField();
        ef.setBounds(400,340,300,30);
        add(ef);

        JLabel marital =new JLabel("Marital Status: ");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(marital);

         married=new JRadioButton("Married");
        married.setBounds(400,390,120,30);
        married.setBackground(Color.white);
        add(married);

         unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(550,390,120,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(married);
        bg1.add(unmarried);


        JLabel address =new JLabel("Address: ");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(address);

        af= new JTextField();
        af.setBounds(400,440,300,30);
        add(af);

        JLabel city =new JLabel("City: ");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(city);

        cf= new JTextField();
        cf.setBounds(400,490,300,30);
        add(cf);

        JLabel state =new JLabel("State: ");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(state);

        sf= new JTextField();
        sf.setBounds(400,540,300,30);
        add(sf);

        JLabel pin =new JLabel("Pin - Code: ");
        pin.setBounds(100,590,200,30);
        pin.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(pin);


        pf= new JTextField();
        pf.setBounds(400,590,300,30);
        add(pf);

        next = new JButton("NEXT");
        next.setBounds(400,650,230,30);
        next.setForeground(Color.white);
        next.setBackground(Color.DARK_GRAY);
        next.addActionListener(this);
        add(next);

        clear = new JButton("Close");
        clear.setBounds(400,690,230,30);
        clear.setForeground(Color.white);
        clear.setBackground(Color.DARK_GRAY);
        clear.addActionListener(this);
        add(clear);

        setUndecorated(true);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = ""+random;
        String name = nf.getText();
        String fname = ff.getText();
        String dob=((JTextField)dc.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender="male";

        } else if (female.isSelected()) {
            gender="female";
        }
        String email = ef.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "married";
        } else if (unmarried.isSelected()) {
            marital="unmarried";
        }
        String address = af.getText();
        String city = cf.getText();
        String state = sf.getText();
        String pin = pf.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name required!!");
            }
            else {
                Conn c = new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"'" +
                        ",'"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.statement.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        if(e.getSource()==clear){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
