import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GUI {
    Control c;
    private JPanel mainpanel;
    private JButton addButton;
    private JButton viewButton;
    private JButton searchButton1;
    private JButton deletButton;
    private JPanel AllCards;
    private JPanel c1;
    private JPanel c2;
    private JPanel c3;
    private JPanel c4;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JButton addNewTravelButton;
    private JTextArea textArea1;
    private JTextField t5;
    private JTextField t6;
    private JLabel arr_date;
    private JTextField textField1;
    private JButton searchButton;
    private JTextArea textArea2;
    private JTextField textField2;
    private JButton deletButton1;
    private JTextArea textArea3;

    public GUI() throws FileNotFoundException {
        c =new Control();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c1);
                AllCards.repaint();
                AllCards.revalidate();
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c2);
                AllCards.repaint();
                AllCards.revalidate();
                String n="";
                Flights[] f= c.allflights;
                for (Flights x:f){
                    if(x!=null)
                    n=n+x+"\n";
                }
                textArea1.setText(n);
            }
        });
        searchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllCards.removeAll();
                AllCards.add(c3);
                AllCards.repaint();
                AllCards.revalidate();
            }
        });
        addNewTravelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String f=t1.getText();
                String t=t2.getText();
                String d=t3.getText();
                String a=t4.getText();
                int n=Integer.parseInt(t5.getText());
                int p=Integer.parseInt(t6.getText());
                boolean added=c.addflight(f,t,d,a,n,p);
                if(added)JOptionPane.showMessageDialog(null,"added successfully");
                else JOptionPane.showMessageDialog(null,"you have problem");

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=Integer.parseInt(textField1.getText());
                Flights x= c.searchFlight(i);
                if (x!=null)
                    textArea2.setText(x.toString());
                else textArea2.setText("not found");
            }
        });
        deletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n=Integer.parseInt(textField2.getText());
                Flights x=c.searchFlight(n);
                boolean deleted= c.deleteflight(n);
                if(x!=null)
                    x=null;
                    textArea3.setText(deleted+"deleted successfully");
                textArea3.setText("no numOfTrip with this number");

            }
        });
    }

    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(700,400);
        frame.setVisible(true);
    }
}
