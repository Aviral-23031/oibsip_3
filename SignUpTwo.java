import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener{
    JButton next,clear;
    JRadioButton Yes1, No1,Yes2,No2;
    JTextField pn,an;
    String formno;
    JComboBox cb1,cb2,cb3,cb4,cb5;
    SignUpTwo(String formno){
        this.formno=formno;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel personalDetails =new JLabel("Page2: Additional Details ");
        personalDetails.setBounds(310,55,400,30);
        personalDetails.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(personalDetails);


        JLabel religion = new JLabel("Religion: ");
        religion.setBounds(100,150,200,30);
        religion.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(religion);


        //Array is made to be used in combo box, now this combo box
        String rel[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        cb1=new JComboBox(rel);
        cb1.setBounds(400,150,300,30);
        add(cb1);



        JLabel category=new JLabel("Category: ");
        category.setBounds(100,200,200,30);
        category.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(category);

        String cat[] = {"General","SC","ST","OBC","other"};
        cb2=new JComboBox(cat);
        cb2.setBounds(400,200,300,30);
        add(cb2);


        JLabel income= new JLabel("Income: ");
        income.setBounds(100,250,200,30);
        income.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(income);

        String inc[] = {"Null","<1,50,000","2,00,000","5,00,000","other"};
        cb3=new JComboBox(inc);
        cb3.setBounds(400,250,300,30);
        add(cb3);


        JLabel eduquali = new JLabel("Educational Qualification: ");
        eduquali.setBounds(100,300,250,30);
        eduquali.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(eduquali);

        String eq[] = {"Graduate","Non-Graduate","Post Graduate","Doctrate","Upto 10th","Upto 12th"};
        cb4=new JComboBox(eq);
        cb4.setBounds(400,300,300,30);
        add(cb4);


        JLabel occupation = new JLabel("Occupation: ");
        occupation.setBounds(100,350,200,30);
        occupation.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(occupation);

        String occ[] = {"Student","Salaried","Self Employed","Business","Retired","Others"};
        cb5=new JComboBox(occ);
        cb5.setBounds(400,350,300,30);
        add(cb5);

        JLabel PANNumber =new JLabel("PAN Number: ");
        PANNumber.setBounds(100,400,200,30);
        PANNumber.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(PANNumber);

        pn= new JTextField();
        pn.setBounds(400,400,300,30);
        add(pn);

        JLabel AadharNumber =new JLabel("Aadhar Number: ");
        AadharNumber.setBounds(100,450,200,30);
        AadharNumber.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(AadharNumber);

        an= new JTextField();
        an.setBounds(400,450,300,30);
        add(an);



        JLabel sc =new JLabel("Senior Citizen: ");
        sc.setBounds(100,500,200,30);
        sc.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(sc);

        Yes1=new JRadioButton("Yes");
        Yes1.setBounds(400,500,60,30);
        Yes1.setBackground(Color.white);
        add(Yes1);

        No1=new JRadioButton("No");
        No1.setBounds(550,500,120,30);
        No1.setBackground(Color.white);
        add(No1);

        ButtonGroup bg = new ButtonGroup();
        bg.add(Yes1);
        bg.add(No1);


        JLabel ea =new JLabel("Existing Account: ");
        ea.setBounds(100,550,200,30);
        ea.setFont(new Font("Ubuntu",Font.BOLD,20));
        add(ea);

        Yes2=new JRadioButton("Yes");
        Yes2.setBounds(400,550,60,30);
        Yes2.setBackground(Color.white);
        add(Yes2);

        No2=new JRadioButton("No");
        No2.setBounds(550,550,120,30);
        No2.setBackground(Color.white);
        add(No2);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(Yes2);
        bg1.add(No2);



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


        String religion = (String) cb1.getSelectedItem();
        String category = (String) cb2.getSelectedItem();
        String income= (String) cb3.getSelectedItem();
        String eduquali = (String) cb4.getSelectedItem();
        String occupation =(String) cb5.getSelectedItem();
        String pan = pn.getText();
        String adhar=an.getText();
        String senior = null;
        if(Yes1.isSelected()){
            senior="Yes";

        } else if (No1.isSelected()) {
            senior="No";
        }

        String ea = null;
        if(Yes2.isSelected())
        {
              ea  = "Yes";
        } else if (No2.isSelected()) {
            ea="ea";
        }

        try{

                Conn c = new Conn();
                String query="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+eduquali+"'" +
                        ",'"+occupation+"','"+pan+"','"+adhar+"','"+senior+"','"+ea+"')";
                c.statement.executeUpdate(query);
                setVisible(false);
                new SignUpThree(formno);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if(e.getSource()==clear){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
