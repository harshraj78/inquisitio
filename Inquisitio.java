import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Inquisitio extends Frame {

    public static void main(String[] args) {
        new WelcomePage();
    }
}

// WELCOME PAGE

class WelcomePage implements ActionListener{
    Frame f;
    Button b;
    Label start, info, contact;

    WelcomePage() {
        f = new Frame("Welcome to INQUISITIO");
        f.setVisible(true);
        f.setLocation(250, 0);
        f.setSize(1000, 1000);
        start = new Label("INQUISITIO");
        b = new Button("START QUIZ");
        f.setLayout(null);
        f.setBackground(Color.GRAY);
        info = new Label("A Java Knowledge Quiz");
        contact = new Label("Developed by:  Harsh Raj");

        b.addActionListener(this);
        
        info.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        start.setFont(new Font("TimesRoman", Font.BOLD, 60));
        b.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        contact.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        start.setBounds(300, 300, 400, 60);
        info.setBounds(370, 370, 400, 30);
        b.setBounds(325, 500, 300, 70);
        contact.setBounds(150, 800, 800, 20);
        b.setBackground(Color.white);
    
        f.add(start);
        f.add(b);
        f.add(info);
        f.add(contact);

    }

    public void actionPerformed(ActionEvent e){
        f.setVisible(false);
        new EnterDetailsPage();
    }
}

//PAGE TO ENTER DETAILS

class EnterDetailsPage extends Frame implements ActionListener{
    Checkbox checkbox;
    
    public EnterDetailsPage() {
        setTitle("Details");
        setLocation(250, 0);
        setSize(1000,1000);    

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
            
        Label label1 = new Label("Enter Your Name");
        label1.setBounds(260,270,600,48);
        Font myFont3 = new Font("TimesRoman", Font.BOLD,60);            
        label1.setFont(myFont3);
        
        Label label2 = new Label("This will be used as your name through out the game");
        label2.setBounds(300,295,600,80);
        Font myFont4 = new Font("TimesRoman", Font.ITALIC,16);            
        label2.setFont(myFont4);
        
        Label label4 = new Label("Terms and Conditions of the Quiz");
        label4.setBounds(150,445,250,80);
        Font myFont6 = new Font("TimesRoman", Font.ITALIC,13);            
        label4.setFont(myFont6);

        checkbox = new Checkbox();
        checkbox.setBounds(150,750,25,25);
        
        Label label5 = new Label("I Agree with the terms and condition of the game");
        label5.setBounds(180,750,280,30);
        Font myFont7 = new Font("TimesRoman", Font.ITALIC,13);            
        label5.setFont(myFont7);
        
        Button button1 = new Button("SUBMIT");
        button1.setBounds(550,400,80,40);
        Font myFont2 = new Font("TimesRoman", Font.BOLD,13);            
        button1.setFont(myFont2);
        button1.addActionListener(this);
        
        Button button2 = new Button("CLEAR");
        Font myFont1 = new Font("TimesRoman", Font.BOLD,13);            
        button2.setBounds(350,400,80,40);
        button2.setFont(myFont1);   
        
        TextArea textarea = new TextArea
        ("1. This quiz is only open to the students, faculty and staff of AMITY UNIVERSITY."
                + "\n2. This quiz is has 2 levels and the levels are decided by the difficulty of the questions."
                + "\n3. This quiz does not have any prize."
                + "\n4. The result of the quiz would be shown at the end of the quiz."
                + "\n5. The result will be based on your performance, during the quiz."
                + "\n6. You will be attempting the quiz by your own, any external help should be prohibited."
                + "\n7. This quiz do not takes any personal details expect the name."
                + "\n8. During the Quiz you cannot restart the quiz or go back to any previous question."
                + "\n9. Participants shall submit their answers through this webpage, according "
                + "\n to the submission instructions."
                + "\n10. This quiz is free and no participation fess is charged."
                + "\n11. You can only start the quiz after agreeing to these terms and conditions.");

        textarea.setEnabled(false);
        Font myFont5 = new Font("TimesRoman", Font.PLAIN,15);
        textarea.setBounds(150,500,700,250);
        textarea.setFont(myFont5);       
          
        TextField textfield = new TextField("Enter your Name here");
        // String x = textfield.getText();

        Font myFont = new Font("TimesRoman", Font.PLAIN ,16);
        textfield.setBounds(300,350,380,30);
        textfield.setFont(myFont);
        setBackground(Color.gray);
        
        button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           textfield.setText("");
       }
    });
        
        add(textfield);
        add(label1);
        add(label2);
        add(button1);
        add(button2);
        add(textarea);
        add(checkbox);
        add(label4);
        add(label5);
        
        
        add(new ImageComponent("filepath"));
        setVisible(true);  
    }

    public void actionPerformed(ActionEvent e){

        if(checkbox.getState()){
            setVisible(false);
            new DifficultyLevelPage();
        }

        else {
            JOptionPane.showMessageDialog(this, "Please agree to the terms and conditions before proceeding");
        }
    }   
}

//PAGE TO SELECT DIFFICULTY LEVEL

class DifficultyLevelPage extends Frame {
    
    Button button1, button2;
    public DifficultyLevelPage() {
        setTitle("Difficulty Level");
        setLocation(250, 0);
        setSize(1000,1000);                
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
            
        Label label1 = new Label("Choose Difficulty level");
        label1.setBounds(260,370,600,50);
        Font myFont3 = new Font("TimesRoman", Font.BOLD,50);            
        label1.setFont(myFont3);
        
        Button button1 = new Button("LEVEL 2");
        button1.setBounds(550,500,80,40);
        Font myFont2 = new Font("TimesRoman", Font.BOLD,13);            
        button1.setFont(myFont2);
        
        Button button2 = new Button("LEVEL 1");
        Font myFont1 = new Font("TimesRoman", Font.BOLD,13);            
        button2.setBounds(350,500,80,40);
        button2.setFont(myFont1);   

        button1.addActionListener(e -> {
            setVisible(false);
            new QuestionsPage(2);
        });

        button2.addActionListener(e -> {
            setVisible(false);
            new QuestionsPage(1);
        });
    
        setBackground(Color.gray);
        
        Checkbox checkbox = new Checkbox();
        checkbox.setBounds(150,750,25,25);
        
        add(label1);
        add(button1);
        add(button2);
        add(checkbox);
        checkbox.setVisible(false);
        setVisible(true);  

    }
}

// PAGE OF THE QUESTIONS

class QuestionsPage extends Frame implements ActionListener {

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0, ch;
    int m[] = new int[10];

    QuestionsPage(int c) {
        ch = c;

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        setTitle("Quiz");
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();

        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            radioButton[i].setBackground(Color.gray);
            bg.add(radioButton[i]);
        }

        btnNext = new JButton("Next");
        btnNext.addActionListener(this);
        add(btnNext);
        
        set(ch);
        label.setBounds(30, 300, 700, 30);
        label.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        radioButton[0].setBounds(80, 350, 300, 40);
        radioButton[1].setBounds(80, 400, 300, 40);
        radioButton[2].setBounds(80, 450, 300, 40);
        radioButton[3].setBounds(80, 500, 300, 40);
        btnNext.setBounds(100, 650, 100, 50);
        setBackground(Color.gray);
        setLayout(null);
        setLocation(250, 0);
        setVisible(true);
        setSize(1000, 1000);

        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count = count + 1;
            current++;
            set(ch);
            if (current == 2) {
                btnNext.setText("Result");
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            setVisible(false);
            new ThankYouPage(count);
        }
    }

    void set(int ch) {
        radioButton[4].setSelected(true);
        if(ch == 1){
            if (current == 0) {
                label.setText("1:  Identify the modifier which cannot be used for a constructor.");
                radioButton[0].setText("Public");
                radioButton[1].setText("Protected");
                radioButton[2].setText("Private");
                radioButton[3].setText("Static");
            }
            if (current == 1) {
                label.setText("2:  Identify the return type of a method that doesn't return any value");
                radioButton[0].setText("int");
                radioButton[1].setText("void");
                radioButton[2].setText("String");
                radioButton[3].setText("None of the above");
            }
            if (current == 2) {
                label.setText("3: Exception created in try block is caught in which block?");
                radioButton[0].setText("catch");
                radioButton[1].setText("final");
                radioButton[2].setText("throw");
                radioButton[3].setText("None of the above");
            }
        }

        if(ch == 2){
            if (current == 0) {
                label.setText("1:  When is the finalize() method called");
                radioButton[0].setText("Before garbage collection");
                radioButton[1].setText("Before an object goes out of scope");
                radioButton[2].setText("Before a variable goes out of scope");
                radioButton[3].setText("None of the above");
            }
            if (current == 1) {
                label.setText("2:  Identify the incorrect Java feature");
                radioButton[0].setText("Object oriented");
                radioButton[1].setText("Use of Threads");
                radioButton[2].setText("Dynamic");
                radioButton[3].setText("Use of pointers");
            }
            if (current == 2) {
                label.setText("3: To which of the following does the class String belong to?");
                radioButton[0].setText("java.lang");
                radioButton[1].setText("java.awt");
                radioButton[2].setText("java.applet");
                radioButton[3].setText("java.string");
            }
        }
    }

    boolean check() {
        if (current == 0)
            return (radioButton[3].isSelected());
        if (current == 1)
            return (radioButton[1].isSelected());
        if (current == 2)
            return (radioButton[0].isSelected());
        return false;
    }
}

//THANK YOU PAGE

class ThankYouPage {

    Frame frame = new Frame("Thank You");
  
    ThankYouPage(int ans) {
      frame.setSize(1000, 1000);
      frame.setLocation(250, 0);
      frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          frame.dispose();
        }
      });
      frame.setBackground(Color.gray);
      frame.setLayout(null);
  
      Label thx = new Label("Thank you for taking our quiz!");
      Label score = new Label("Your score: " + ans);
      Button button = new Button("Click here to take the quiz again");
      Button button2 = new Button("Click here to exit the quiz");
  
      thx.setBounds(215, 250, 600, 60);
      score.setBounds(407, 350, 400, 60);
      button.setBounds(290, 550, 400, 60);
      button2.setBounds(290, 650, 400, 60);
  
      thx.setFont(new Font("TimesRoman", Font.BOLD, 40));
      score.setFont(new Font("TimesRoman", Font.PLAIN, 30));
      button.setFont(new Font("TimesRoman", Font.PLAIN, 20));
      button2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
  
      frame.add(thx);
      frame.add(score);
      frame.add(button);
      frame.add(button2);
  
      button2.addActionListener(e -> {
        frame.dispose();
      });
  
      button.addActionListener(e -> {
        frame.setVisible(false);
        new WelcomePage();
      });
  
      frame.setVisible(true);
     
    }
  }

//ADDING THE LOGO

class ImageComponent extends Component {
    BufferedImage img;
    @Override
    public void paint(Graphics g) {
        Image im1;
        im1 = img.getScaledInstance(275, 275, Image.SCALE_DEFAULT);
        g.drawImage(im1,350, 20, null);    
    }
    public ImageComponent(String path) {
        try {
            img = ImageIO.read(new File(path));            
        } catch (IOException e) {}        
    }
 }