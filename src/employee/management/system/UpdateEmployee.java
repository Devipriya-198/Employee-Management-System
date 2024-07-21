package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener{

    JTextField teducation,tfname,taddress,tphone,taadhaar,temail,tsal,tdesignation;
    JLabel teid;
    JButton add,back;
    String number;
    UpdateEmployee(String number){

        this.number = number;

        getContentPane().setBackground(Color.PINK);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name= new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("sant_serif",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
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
        dob.setFont(new Font("sant_serif",Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,18));
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

        teducation =  new JTextField();
        teducation.setBounds(600,300,200,30);
        teducation.setBackground(new Color(177,252,197));
        add(teducation);

        JLabel aadhaar = new JLabel("Aadhaar Number");
        aadhaar.setBounds(400,350,200,30);
        aadhaar.setFont(new Font("sant_serif",Font.BOLD,20));
        add(aadhaar);

        JLabel taadhaar = new JLabel();
        taadhaar.setBounds(600,350,200,30);
        taadhaar.setBackground(new Color(177,252,197));
        add(taadhaar);

        JLabel eid = new JLabel("Employee Id");
        eid.setBounds(50,400,150,30);
        eid.setFont(new Font("sant_serif",Font.BOLD,20));
        add(eid);

        teid = new JLabel();
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

        try{
            comm c= new comm();
            String query="select * from employee where eid = '"+number+"'";
            ResultSet resultSet =c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsal.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhaar.setText(resultSet.getString("aadhaar"));
                teid.setText(resultSet.getString("eid"));
                tdesignation.setText(resultSet.getString("designation"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        add = new JButton("UPDATE");
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
            String fname = tfname.getText();
            String sal = tsal.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try{
                comm c= new comm();
                String query = "update employee set fname = '"+fname+"',salary = '"+sal+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where eid = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new ViewEmployee();
        }


    }

    public static void main(String[] args) {
        new UpdateEmployee("");

    }
}
