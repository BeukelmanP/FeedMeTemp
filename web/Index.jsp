<%-- 
    Document   : Index
    Created on : Sep 13, 2017, 9:30:55 AM
    Author     : piete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FeedMe</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <!--Import materialize.css-->
            <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/></link>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    </head>
    <body style="background-image: url('images/LoginBack2.jpg'); background-size: cover;">

        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('.parallax').parallax();
            });
        </script>
        <nav>
            <div class="nav-wrapper">
                <a href="#" class="brand-logo">FeedMe</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="sass.html">Help</a></li>
                    <li><a href="badges.html">Request Account</a></li>
                    <li><a href="collapsible.html">Contact</a></li>
                </ul>
            </div>
        </nav>

        
        <div class="row">
            <div class="row" style="height:130px"></div>
            <form class="col s6 offset-s3" style=" background-color: rgba(250, 250, 250, 0.99);">
                <p class="logo-Login">FeedMe</p>
                
                <div class="row">
                    <div class="input-field col s6 offset-s3">
                        <input id="email" type="email" class="validate"></input>
                        <label for="email">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6 offset-s3">
                        <input id="password" type="password" class="validate"></input>
                        <label for="password">Password</label>
                    </div>
                </div>
                <div class="row">
                    <div class=" col s12">
                        <p style="text-align:center" ><a class="btn btn-floating pulse"><i class="material-icons">navigate_next</i></a></p>
                    </div>
                </div>
            </form>
        </div>


        <!--        <div class="parallax-container">
                    <div class="parallax"><img src="images/FrontImage.jpg"></img></div>
                </div>-->



    </body>
</html>
