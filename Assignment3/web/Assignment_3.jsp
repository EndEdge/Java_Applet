<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Interactive System Design --- Assignment 3</title>
</head>
<body>

<style>

    body {
        font-family: Arial;
    }

    .left_side {
        height: 86%;
        width: 30%;
        position: fixed;
        top: 0;
        overflow-x: hidden;
        padding-top: 60px;
        left: 0;
        background-color: #D3D3D3;
    }

    .right_side {
        height: 86%;
        width: 70%;
        position: fixed;
        top: 0;
        overflow-x: hidden;
        padding-top: 60px;
        right: 0;
        background-color: 00FFFF;
        color: #282828;
    }

    .top {
        position: fixed;
        left: 0;
        top: 0;
        width: 100%;
        background-color: #484848;
        color: white;
        text-align: center;
        box-shadow: 0 2px 2px -2px rgba(0,0,0,.2);
    }

    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        height: 6%;
        background-color: #484848;
        color: white;
        text-align: center;
        opacity: 0.6;
        filter: alpha(opacity=50);
        padding: 0;
        margin: 0;
    }

    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #484848;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #606060;
    }

    .selection {
        width: 87%;
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
        left: 10px;
        margin-left: 9px;
        margin-bottom: 9px;
    }

</style>

<div class="left_side">

    <h3 align="center">Selection Menu</h3>

    <div class="selection">

        <form action="BadgeServlet" method="get">

            <h4 align="center">Shape Options</h4>

            <label for="shape">Shape</label><br>
            <select id="shape" name="shape">
                <option value="" disabled selected>Select (Default: Rectangle)</option>
                <option value="RECT">Rectangle</option>
                <option value="OVAL">Oval</option>
                <option value="ROUNDRECT">Round Rectangle</option>
            </select>

            Width<input type="text" id="X" name="X" placeholder="Enter Width Here.. (Default: 250)"><br>

            Height<input type="text" id="Y" name="Y" placeholder="Enter Height Here.. (Default: 120)"><br>

            <label for="color">Shape Color</label><br>
            <select id="color" name="color">
                <option value="" disabled selected>Select (Default: Black)</option>
                <option value="black">Black</option>
                <option value="blue" style="color: blue">Blue</option>
                <option value="cyan" style="color: cyan">Cyan</option>
                <option value="darkGrey" style="color: darkgrey">Dark Grey</option>
                <option value="grey" style="color: grey">Grey</option>
                <option value="green" style="color: green">Green</option>
                <option value="lightGrey" style="color: lightgrey">Light Grey</option>
                <option value="magenta" style="color: magenta">Magenta</option>
                <option value="orange" style="color: orange">Orange</option>
                <option value="pink" style="color: pink">Pink</option>
                <option value="red" style="color: red">Red</option>
                <option value="white" style="color: black">White</option>
                <option value="yellow" style="color: yellow">Yellow</option>
            </select>

            <label for="BGColor">Background Color</label><br>
            <select id="BGColor" name="BGColor">
                <option value="" disabled selected>Select (Default: White)</option>
                <option value="black">Black</option>
                <option value="blue" style="color: blue">Blue</option>
                <option value="cyan" style="color: cyan">Cyan</option>
                <option value="darkGrey" style="color: darkgrey">Dark Grey</option>
                <option value="grey" style="color: grey">Grey</option>
                <option value="green" style="color: green">Green</option>
                <option value="lightGrey" style="color: lightgrey">Light Grey</option>
                <option value="magenta" style="color: magenta">Magenta</option>
                <option value="orange" style="color: orange">Orange</option>
                <option value="pink" style="color: pink">Pink</option>
                <option value="red" style="color: red">Red</option>
                <option value="white" style="color: black">White</option>
                <option value="yellow" style="color: yellow">Yellow</option>
            </select>

            <h4 align="center">Text Options</h4>

            Message<input type="text" id="message" name="message" placeholder="Your Message... (Default: Hello)"><br>

            <label for="FGColor">Font Color</label><br>
            <select id="FGColor" name="FGColor">
                <option value="" disabled selected>Select (Default: Black)</option>
                <option value="black">Black</option>
                <option value="blue" style="color: blue">Blue</option>
                <option value="cyan" style="color: cyan">Cyan</option>
                <option value="darkGrey" style="color: darkgrey">Dark Grey</option>
                <option value="grey" style="color: grey">Grey</option>
                <option value="green" style="color: green">Green</option>
                <option value="lightGrey" style="color: lightgrey">Light Grey</option>
                <option value="magenta" style="color: magenta">Magenta</option>
                <option value="orange" style="color: orange">Orange</option>
                <option value="pink" style="color: pink">Pink</option>
                <option value="red" style="color: red">Red</option>
                <option value="white" style="color: black">White</option>
                <option value="yellow" style="color: yellow">Yellow</option>
            </select>

            <label for="FTStyle">Font Style</label><br>
            <select id="FTStyle" name="FTStyle">
                <option value="" disabled selected>Select (Default: Regular)</option>
                <option value="PLAIN">Regular</option>
                <option value="BOLD" style="font-weight: bold";>Bold</option>
                <option value="ITALIC" style="font-style: italic">Italic</option>
                <option value="BOLD ITALIC" style="font-weight: bold; font-style: italic;">Bold Italic</option>
            </select>

            Font Size<input type="text" id="FTSize" name="FTSize" placeholder="Enter Font Size Here.. (Default: 15)"><br>

            <h4 align="center">Applet Options</h4>
            <h5 align="center">Width(max): 300 & Height(max): 150</h5>

            Applet New Width<input type="text" id="NX" name="NX" placeholder="Default: 300"><br>
            Applet New Height<input type="text" id="NY" name="NY" placeholder="Default: 150"><br><br><br>

            <input type="submit" value="Submit">

        </form>
    </div>

</div>


<div class="right_side">

    <h1 align="center">Applet View Area</h1>

    <div align="center">
        <applet code="ShowShape.class" width="${Params.getNX()}" height="${Params.getNY()}">
            <param name="MESSAGE"   value="${Params.getMessage()}">
            <param name="SHAPE"   value="${Params.getShape()}">
            <param name="COLOR"   value="${Params.getColor()}">
            <param name="BGCOLOR"   value="${Params.getBgColor()}">
            <param name="FGCOLOR"   value="${Params.getFgColor()}">
            <param name="X"   value="${Params.getX()}">
            <param name="Y"   value="${Params.getY()}">
            <param name="FTSTYLE"   value="${Params.getFtStyle()}">
            <param name="FTSIZE"   value="${Params.getFtSize()}">
            <param name="NX"   value="${Params.getNX()}">
            <param name="NY"   value="${Params.getNY()}">
        </applet>
    </div>

</div>

<div class="top">

    <h2>Interactive Applet Viewer</h2>

</div>


<div class="footer">

    <h5>Developed By: Gaurav & Jiakai</h5>

</div>

</body>
</html>