<html>
<head>
    <meta charset="UTF-8">
    <title>JavaProHW04</title>
    <style>
        <%@include file="/style/w3.css" %>
    </style>
</head>
<body>
<div class="w3-container w3-padding">
    <% if (request.getSession().getAttribute("wrong") != null) {
        out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                "<span onclick=\"this.parentElement.style.display='none'\"\n" +
                "class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                "<h5>'" + request.getSession().getAttribute("wrong") + "'</h5>\n</div>");
        request.getSession().removeAttribute("wrong");
    }
    %>
    <form method="post" action= "/" class="w3-selection w3-light-grey w3-padding">
        <label>Enter your login:
            <input type="text" name="login" class="w3-input  w3-border w3-round-large"
                   style="width: 30%"><br/>
        </label>
        <label>Enter your password:
            <input type="password" name="password" class="w3-input  w3-border w3-round-large"
                   style="width: 30%"><br/>
        </label>
        <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Sign in</button>
    </form>
    <p class="w3-dropdown-hover">Click me for testing!
        <span class="w3-dropdown-content w3-green w3-padding">
            Login: client
            Pass: client
            Login: manager
            Pass: manager
        </span>
    </p>
</div>
</body>
</html>