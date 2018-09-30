public class Params {
    private String _msg;
    private String _shape;
    private String _color;
    private String _bgcolor;
    private String _fgcolor;
    private String _x;
    private String _y;
    private String _ftstyle;
    private String _ftsize;

    // New variables
    private String _nx;
    private String _ny;

    public String getMessage() {
        return this._msg;
    }

    public void setMessage(String s) {
        this._msg = s;
    }

    public String getShape() {
        return this._shape;
    }

    public void setShape(String s) {
        this._shape = s;
    }

    public String getColor() {
        return this._color;
    }

    public void setColor(String s) {
        this._color = s;
    }

    public String getBgColor() {
        return this._bgcolor;
    }

    public void setBgColor(String s) {
        this._bgcolor = s;
    }

    public String getFgColor() {
        return _fgcolor;
    }

    public void setFgColor(String s) {
        this._fgcolor = s;
    }

    public String getX() {
        return this._x;
    }

    public void setX(String s) {
        this._x = s;
    }

    public String getY() {
        return this._y;
    }

    public void setY(String s) {
        this._y = s;
    }

    // New code starts here
    public String getNX() {
        return this._nx;
    }

    public void setNX(String s) {
        this._nx = s;
    }

    public String getNY() {
        return this._ny;
    }

    public void setNY(String s) {
        this._ny = s;
    }
    // New code ends here

    public String getFtStyle() {
        return this._ftstyle;
    }

    public void setFtStyle(String s) {
        this._ftstyle = s;
    }

    public String getFtSize() {
        return _ftsize;
    }

    public void setFtSize(String s) {
        this._ftsize = s;
    }
}