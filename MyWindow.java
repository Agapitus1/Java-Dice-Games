import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
public class MyWindow extends JFrame
{
    private MyPanel panel = new MyPanel();  

    public MyWindow()
    {
        super("This is my Window");
        setup();
        build();
        setVisible(true);   
    }

    public void setup()
    {
        setSize(400, 200);
        setLocation(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void build()
    {
        add(panel);
    }
    private class MyPanel extends JPanel implements MyObserver//all panels inherit from MyObserver
    {
        private JButton button = new JButton("Roll");
        private JLabel label = new JLabel();
        private Dice dice = new Dice();
        public MyPanel()
        {
            setup();
            build(); 
            dice.attach(this);//MyPanel registers itself as an observer of Dice
        } 

        private void setup()
        {
            button.addActionListener(new Listener());
        }

        private void build()
        {
            add(button);
            add(label);
        }

        public void update()//refreshes the data on the panel
        {
            label.setText("" + dice.getRoll());
        }
        private class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                dice.roll();
                //model procedure changes the data and call updateViews(), 
                //which call update() on each panel, which refreshes the data
            }
        }
    }

}
