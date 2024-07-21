package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tname,tfname,taddress,tphone,taadhaar,temail,tsal,tdesignation;
    JLabel teid;
    JDateChooser tdob;

    JButton add,back;

    JComboBox Boxeducation;

    AddEmployee(){

        getContentPane().setBackground(Color.PINK);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name= new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("sant_serif",Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname= new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("sant_serif",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,200,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob= new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("sant_serif",Font.BOLD,18));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel sal= new JLabel("Salary");
        sal.setBounds(400,200,150,30);
        sal.setFont(new Font("sant_serif",Font.BOLD,20));
        add(sal);

        tsal = new JTextField();
        tsal.setBounds(600,200,200,30);
        tsal.setBackground(new Color(177,252,197));
        add(tsal);

        JLabel address= new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("sant_serif",Font.BOLD,20));
        add(address);

        taddress =  new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone= new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("sant_serif",Font.BOLD,20));
        add(phone);

        tphone =  new JTextField();
        tphone.setBounds(600,250,200,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email= new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("sant_serif",Font.BOLD,20));
        add(email);

        temail =  new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel education= new JLabel("Qualification");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("sant_serif",Font.BOLD,20));
        add(education);

        String items[] =  {"BBA","B.Tech","BCA","B.COM","MBA","MCA","MA","M.Tech","MSC","PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,300,200,30);
        add(Boxeducation);

        JLabel aadhaar = new JLabel("Aadhaar Number");
        aadhaar.setBounds(400,350,200,30);
        aadhaar.setFont(new Font("sant_serif",Font.BOLD,20));
        add(aadhaar);

        taadhaar = new JTextField();
        taadhaar.setBounds(600,350,200,30);
        taadhaar.setBackground(new Color(177,252,197));
        add(taadhaar);

        JLabel eid = new JLabel("Employee Id");
        eid.setBounds(50,400,150,30);
        eid.setFont(new Font("sant_serif",Font.BOLD,20));
        add(eid);

        teid = new JLabel(""+number);
        teid.setBounds(200,400,250,30);
        teid.setFont(new Font("sant_serif",Font.BOLD,27));
        teid.setForeground(Color.RED);
        add(teid);

        JLabel desig = new JLabel("Designation");
        desig.setBounds(50,350,200,30);
        desig.setFont(new Font("sant_serif",Font.BOLD,20));
        add(desig);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        add = new JButton("ADD");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(200,45);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String sal = tsal.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String desig = tdesignation.getText();
            String aadhaar = taadhaar.getText();
            String eid = teid.getText();

            try{
                comm conn = new comm();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+sal+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+desig+"','"+aadhaar+"','"+eid+"')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();

    }
}
