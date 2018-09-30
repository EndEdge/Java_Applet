import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ShowShape extends JApplet
{
    private static final long serialVersionUID = 1L;

    private String s = "Hello";
    private String shape = "RECT";
    private Color color = Color.black;
    private Color bgColor = Color.red;
    private Color fgColor = Color.black;
    private int x = 250;
    private int y = 120;
    private String ftStyle = "REGULAR";
    private int ftSize = 15;

    private int shapeX = 0;
    private int shapeY = 0;

    // New Variables
    private int nx = 300;
    private int ny = 150;

    private ArrayList<String> colorList = new ArrayList<>(Arrays.asList("black", "blue", "cyan", "darkGray", "gray", "green", "lightGray", "magenta", "orange", "pink", "red", "white", "yellow"));
    private ArrayList<String> shapeList = new ArrayList<>(Arrays.asList("OVAL", "RECT", "ROUNDRECT"));
    private ArrayList<String> styleList = new ArrayList<>(Arrays.asList("REGULAR", "BOLD", "ITALIC", "BOLD ITALIC"));

    private int[] errors = new int[11];

    public void init()
    {
        String ts = this.getParameter("Message");
        String tshape = this.getParameter("Shape");
        String tcolor = this.getParameter("Color");
        String tbgColor = this.getParameter("BGColor");
        String tfgColor = this.getParameter("FGColor");
        String tx = this.getParameter("X");
        String ty = this.getParameter("Y");
        String tftstyle = this.getParameter("FTStyle");
        String tftsize = this.getParameter("FTSize");

        // New Variables
        String tnx = this.getParameter("NX");
        String tny = this.getParameter("NY");

        if(ts!=null && !ts.equals("")){
            this.s = ts;
        }
        else{
            this.errors[0] = 1;
        }

        if(tshape != null && shapeList.contains(tshape)){
            this.shape = tshape;
        }
        else{
            this.errors[1] = 1;
        }

        if(tcolor != null && colorList.contains(tcolor)){
            this.color = findColor(tcolor);
        }
        else{
            this.errors[2] = 1;
        }

        if(tbgColor != null && colorList.contains(tbgColor)){
            this.bgColor = findColor(tbgColor);
        }
        else{
            this.errors[3] = 1;
        }

        if(tfgColor != null && colorList.contains(tfgColor)){
            this.fgColor = findColor(tfgColor);
        }
        else{
            this.errors[8] = 1;
        }

        // New code starts here
        if(tnx != null && !tnx.equals("")){
            this.nx = Integer.parseInt(tnx);
            if(nx > 300 || nx <= 0){
                nx = 300;
                this.errors[9] = 1;
            }
        }
        else{
            this.errors[9] = 1;
        }

        if(tny != null && !tny.equals("")){
            this.ny = Integer.parseInt(tny);
            if(ny > 150 || ny <= 0){
                ny = 150;
                this.errors[10] = 1;
            }
        }
        else{
            this.errors[10] = 1;
        }
        // New code ends here

        if(tx != null && !tx.equals("")){
            this.x = Integer.parseInt(tx);
            if(x > nx || x <= 0){
                x = nx;
                this.errors[4] = 1;
            }
        }
        else{
            if(x > nx || x <= 0){
                x = nx;
            }
            this.errors[4] = 1;
        }

        if(ty != null && !ty.equals("")){
            this.y = Integer.parseInt(ty);
            if(y > ny || y <= 0){
                y = ny;
                this.errors[5] = 1;
            }
        }
        else{
            if(y > ny || y <= 0) {
                y = ny;
            }
            this.errors[5] = 1;
        }


        if(tftstyle != null && styleList.contains(tftstyle)){
            this.ftStyle = tftstyle;
        }
        else{
            this.errors[6] = 1;
        }

        if(tftsize != null && !tftsize.equals("")){
            this.ftSize = Integer.parseInt(tftsize);
        }
        else{
            this.errors[7] = 1;
        }

        // New code starts here
        resize(nx, ny);
        setBackground(bgColor);
        // New code ends here
    }

    public void paint(Graphics g)
    {
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
                ftSize = 12;
                flag++;
            }
            else{
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

    private Color findColor(String c)
    {
        switch(colorList.indexOf(c)){
            case 0:
                return Color.black;
            case 1:
                return Color.blue;
            case 2:
                return Color.cyan;
            case 3:
                return Color.darkGray;
            case 4:
                return Color.gray;
            case 5:
                return Color.green;
            case 6:
                return Color.lightGray;
            case 7:
                return Color.magenta;
            case 8:
                return Color.orange;
            case 9:
                return Color.pink;
            case 10:
                return Color.red;
            case 11:
                return Color.white;
            case 12:
                return Color.yellow;
            default:
                return Color.white;
        }
    }
}
