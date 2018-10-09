import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

public class ShowShapeApp extends JFrame implements ActionListener, ItemListener{
    private JButton changeColor, changeColor2, changeColor3;
    private Container c, c1, c2;
    private JPanel p1, p2, p3;
    private JFrame f1, f2;
    private JTextField textX, textY, textT, textSize;
    private JRadioButton oval, rect, roundrect;
    private JCheckBox bold, italic;
    private int s1 = 0, s2 = 0;

    //--------------- ShowShape variables -----------------------
    private String s = "Hello";
    private String shape = "OVAL";
    private Color color = Color.black;
    private Color bgColor = Color.white;
    private Color fgColor = Color.black;
    private int x = 250;
    private int y = 120;
    private String ftStyle = "REGULAR";
    private int ftSize = 30;
    private int shapeX = 0;
    private int shapeY = 0;
    private int nx = 0;
    private int ny = 0;
    private ArrayList<String> shapeList = new ArrayList<>(Arrays.asList("OVAL", "RECT", "ROUNDRECT"));
    private ArrayList<String> styleList = new ArrayList<>(Arrays.asList("REGULAR", "BOLD", "ITALIC", "BOLD ITALIC"));
    private int[] errors = new int[11];
    //--------------- End -----------------------

    ShowShapeApp(){
        super("ShowShapeApp");

        p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setPreferredSize(new Dimension(150,0));

        p2 = new JPanel();

        f1 = new JFrame();
        c1 = f1.getContentPane();

        f2 = new JFrame();
        c2 = f2.getContentPane();

        p3 = new JPanel();
        p3.setBackground(Color.white);
        p3.setPreferredSize(new Dimension(0,60));

        c = getContentPane();
        c.add(c1, BorderLayout.WEST);
        c.add(c2, BorderLayout.CENTER);
        c1.add(p1);
        c2.add(p2, BorderLayout.CENTER);
        c2.add(p3, BorderLayout.NORTH);


        changeColor = new JButton("BackGround Color");
        changeColor.addActionListener(this);
        p1.add(changeColor);

        JTextField dsctext_shape = new JTextField("Shape Setting", 10);
        dsctext_shape.setFont(new Font("TimesRoman", Font.BOLD, 14));
        dsctext_shape.setEditable(false);
        p1.add(dsctext_shape);

        JTextField dsctext_x = new JTextField("Width", 5);
        dsctext_x.setEditable(false);
        p1.add(dsctext_x);
        JTextField dsctext_y = new JTextField("Height", 5);
        dsctext_y.setEditable(false);
        p1.add(dsctext_y);

        textX = new JTextField("250",5);
        textX.addActionListener(this);
        p1.add(textX);

        textY = new JTextField("120",5);
        textY.addActionListener(this);
        p1.add(textY);

        oval = new JRadioButton("OVAL", true);
        oval.addActionListener(this);
        p1.add(oval);
        rect = new JRadioButton("RECT", false);
        rect.addActionListener(this);
        p1.add(rect);
        roundrect = new JRadioButton("ROUND RECT", false);
        roundrect.addActionListener(this);
        p1.add(roundrect);

        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(oval);
        shapeGroup.add(rect);
        shapeGroup.add(roundrect);

        changeColor2 = new JButton("Shape Color");
        changeColor2.addActionListener(this);
        p1.add(changeColor2);

        JTextField dsctext_t = new JTextField("Text", 3);
        dsctext_t.setEditable(false);
        p3.add(dsctext_t);

        textT = new JTextField("Hello", 25);
        textT.addActionListener(this);
        p3.add(textT);

        changeColor3 = new JButton("Font Color");
        changeColor3.addActionListener(this);
        p3.add(changeColor3);

        bold = new JCheckBox("Bold");
        bold.addItemListener(this);
        p3.add(bold);

        italic = new JCheckBox("Italic");
        italic.addItemListener(this);
        p3.add(italic);

        JTextField dsctext_s = new JTextField("Size", 3);
        dsctext_s.setEditable(false);
        p3.add(dsctext_s);

        textSize = new JTextField("30", 5);
        textSize.addActionListener(this);
        p3.add(textSize);

        setSize(500, 300);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == changeColor){
            bgColor = JColorChooser.showDialog(ShowShapeApp.this, "choose a color", bgColor);
            if(bgColor == null) {
                bgColor = Color.white;
            }
        }
        else if(obj == textX){
            x = Integer.parseInt(e.getActionCommand());
        }
        else if(obj == textY){
            y = Integer.parseInt(e.getActionCommand());
        }
        else if(obj == oval){
            shape = "OVAL";
        }
        else if(obj == rect){
            shape = "RECT";
        }
        else if(obj == roundrect){
            shape = "ROUNDRECT";
        }
        else if(obj == changeColor2){
            color = JColorChooser.showDialog(ShowShapeApp.this, "choose a color", color);
            if(color == null){
                color = Color.black;
            }
        }
        else if(obj == textT){
            s = e.getActionCommand();
        }
        else if(obj == changeColor3){
            fgColor = JColorChooser.showDialog(ShowShapeApp.this, "choose a color", fgColor);
            if(fgColor == null){
                fgColor = Color.black;
            }
        }
        else if(obj == textSize){
            ftSize = Integer.parseInt(e.getActionCommand());
        }
        init();
        appPaint();
    }

    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == bold){
            if(e.getStateChange() == ItemEvent.SELECTED){
                s1 = Font.BOLD;
            }
            else{
                s1 = Font.PLAIN;
            }
        }
        if(e.getSource() == italic){
            if(e.getStateChange() == ItemEvent.SELECTED){
                s2 = Font.ITALIC;
            }
            else{
                s2 = Font.PLAIN;
            }
        }
        ftStyle = styleList.get(s1+s2);
        init();
        appPaint();
    }

    public void init(){
        nx = p2.getWidth();
        ny = p2.getHeight();

        if(x > nx){
            x = nx;
            errors[4] = 1;
        }
        else if(x < 0){
            x = 0;
            errors[4] = 1;
        }
        else{
            errors[4] = 0;
        }

        if(y > ny){
            y = ny;
            errors[5] = 1;
        }
        else if(y < 0){
            y = 0;
            errors[5] = 1;
        }
        else{
            errors[5] = 0;
        }
    }

    private void appPaint(){
        Graphics g = p2.getGraphics();

        g.clearRect(0,0,nx,ny);

        g.setColor(bgColor);
        g.fillRect(0, 0, nx, ny);

        drawShape(g);

        drawCentreString(g);

        showErrors(g);

    }

    private void drawCentreString(Graphics g)
    {
        g.setColor(fgColor);
        int flag = 0;
        int textX = 0;
        int textY = 0;
        while(flag == 0 || flag == 1){
            switch (styleList.indexOf(ftStyle)){
                case 0:
                    g.setFont( new Font( s, Font.PLAIN, ftSize ) );
                    break;
                case 1:
                    g.setFont( new Font( s, Font.BOLD, ftSize));
                    break;
                case 2:
                    g.setFont( new Font( s, Font.ITALIC, ftSize));
                    break;
                case 3:
                    g.setFont( new Font( s, Font.BOLD + Font.ITALIC, ftSize));
                    break;
                default:
                    break;
            }
            FontMetrics fm   = g.getFontMetrics(g.getFont());
            java.awt.geom.Rectangle2D rect = fm.getStringBounds(s, g);
            int textHeight = (int)(rect.getHeight());
            int textWidth  = (int)(rect.getWidth());

            // Center text horizontally and vertically within provided rectangular bounds
            textX = shapeX + (x - textWidth)/2;
            textY = shapeY + (y - textHeight)/2 + fm.getAscent();
            if(textX < shapeX || textY < shapeY){
                errors[7] = 1;
                flag++;
            }
            else{
                errors[7] = 0;
                flag = 2;
            }
        }

        g.drawString(s, textX, textY);
    }

    private void drawShape(Graphics g)
    {
        g.setColor(color);

        //centre shapes
        shapeX = (nx - x)/2;
        shapeY = (ny - y)/2;

        switch (shapeList.indexOf(shape)){
            case 0:
                g.drawOval(shapeX, shapeY, x, y);
                break;
            case 1:
                g.drawRect(shapeX, shapeY, x, y);
                break;
            case 2:
                g.drawRoundRect(shapeX, shapeY, x, y, 20, 20);
                break;
            default:
                break;
        }
    }

    private void showErrors(Graphics g)
    {
        int ey = 0;
        if(errors[0] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "Message error!", 10, ey+=10 );
        }
        if(errors[1] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "Shape error!", 10, ey+=10 );
        }
        if(errors[2] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "Color error!", 10, ey+=10 );
        }
        if(errors[3] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "BGColor error!", 10, ey+=10 );
        }
        if(errors[4] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "X error!", 10, ey+=10 );
        }
        if(errors[5] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "Y error!", 10, ey+=10 );
        }
        if(errors[6] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "FTStyle error!", 10, ey+=10 );
        }
        if(errors[7] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "FTSize error!", 10, ey+=10 );
        }
        if(errors[8] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "FGColor error!", 10, ey+=10 );
        }

        // New code starts here

        if(errors[9] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "Applet New Size(X) error!", 10, ey+=10 );
        }
        if(errors[10] == 1){
            g.setColor(fgColor);
            g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
            g.drawString( "Applet New Size(Y) error!", 10, ey+=10 );
        }

        // New code ends here
    }

    public static void main(String[] args) {
        new ShowShapeApp();
    }
}
