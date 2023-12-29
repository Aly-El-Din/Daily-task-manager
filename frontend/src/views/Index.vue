<template>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
        
        <meta http-equiv="wlkefn" content="dvnwklw">
        <link name="viewPort" content="jkbqkj">
        
        <title>Lexi,your personal assistant</title>
        <link rel="stylesheet" href="styles.css">
        <link rel="icon" href="istockphoto-1312128591-612x612.jpg" type="image/x-icon">
        <link rel="shortcut icon" href="istockphoto-1312128591-612x612.jpg" type="image/x-icon">  
        <!-- <script src="https://kit.fontawesome.com/cc58d8d11f.js" crossorigin="anonymous"></script> -->
    </head>
    <body>
        <div id="div1">
            <div>
                Products &nbsp; &nbsp; Services &nbsp; &nbsp; Contact us
            </div>
    
            <label id="titre" style="color: #f76540;">
            </label>
            <!-- C:\Users\elkarnk\hci\src\components\dashboard.vue -->
            <router-link :to="{ name: 'login', params: { widthPercentage: 50 } }">
                <button id="dashboard" style="width: 250px; height: 50px; font-size: 30px; margin-left: 20%; font-family: 'Courier New', Courier, monospace;">
            Get started<span id="additionalText">Move to Login</span>
            </button>
            </router-link>
            <!-- <a href="C:\Users\elkarnk\hci\src\components\dashboard.vue" target="_blank">
                <button id="dashboard" style="width: 250px; height: 50px; font-size: 30px; font-family: 'Courier New', Courier, monospace;">
                    Get started<span id="additionalText">Move to DashBoard</span>
                </button>
            </a> -->
        </div>
    
    <label id="desc"></label>
    <br><br>
    <p id="p1">Best user-friendly website that can help you manage you daily plans and monitor your tasks efficiently
    </p>
    <img :src="require('@/assets/icons8-checked-checkbox.gif')" style="position: relative; left: 60%; top: 200px; width: 100px; height: 100px;">
    <div id="vision" style="text-align: center;">
    </div>
    <br>
    <div id="mission">
    </div>
    <!-- <script src="index.js"> </script>  -->
    <img :src="require('@/assets/photo_2023-11-10_22-08-25.jpg')" class="img" style="top: -250px;">
    <div id="slogan">One tool for doing it all together</div>
    
    <div class="vl"></div>
    <!--Slide 2-->
    <div style="text-align: center; font-weight: 900; font-size: 10ch;">
        <label style="text-align: center;">Boost your
          <span :style="{ color: '#f76540' }">Productivity</span> with Lexi
        </label>
      </div>
    <img :src="require('@/assets/icon 1.png')" style="left:20%; position: relative; ">
    <img :src="require('@/assets/icon 2.png')" style="left:38%; position: relative; ">
    <img :src="require('@/assets/icon 3.png')" style="left:57%; position: relative; ">
    <br>
    <br>
    <div id="elementContainer">
        <div id="underlined1">Tasks</div>
        <div id="underlined2">Deadlines</div>
        <div id="underlined3">Time Tracking</div>
    </div>
    <!--Slide 3-->
    <br><br><br><br>
    <div class="slide3Icons">
        <div id="slide3MainText">
            <br><br>
          
            <label id="slide-3">
                Make work more 
                <span style="color:silver;"> transparent</span>
                <b> efficient</b>
                <span style="color: #f76540;"> accounted for</span>
                with Lexi
            </label>
        </div>
        <br>
        <div icon1 class="icon1">
            <img :src="require('@/assets/icon 4.png')" style="width:150px ;height:150px ;">
            <img :src="require('@/assets/photo_5940767776094403437_m - Copy.jpg')" style="right: -50%; bottom:-20px; position: relative;width:150px ;height:150px ;">
            <label style="right:-37%;bottom:-40px; position: relative;"><b>Analyze Work Efficiency</b></label>
            <label style="right:-15%;bottom:-85px; position: relative;">Documenting your workflow and following tasks
                through each stage</label>
            <h3><b>Get out of outdated spreadsheets</b></h3>
            <p>With a single source of truth, you can check in on any task at any time<br>
                and get the most up-to-date information available</p>
            <img :src="require('@/assets/icon 7.png')" style="width:150px ;height:150px ;">
            <img :src="require('@/assets/i8.png')" style="right: -50%; bottom:-20px; position: relative;width:150px ;height:150px ;">
            <label style="right:-37%;bottom:-40px; position: relative;"><b>Easy sort and priortize work</b></label>
            <label style="right:-15%;bottom:-85px; position: relative;">using one system you can priortize
                your task according to different keys </label>
            <h3><b>Reduce App switching</b></h3>
            <p>All features needed will be included<br>you can track your daily life activites
                <br>in parallel to work tasks
            </p>
        </div>
    </div>
    <!--Slide 4-->
    <div style="height: 150px;"></div>
    <div style="text-align: center;">
        <div style="position: relative;">
        <img :src="require('@/assets/Capture.png')" width="100%;">
        </div>
        <div style="height: 200px;"></div>
        <div id="contacts" align:center style="color: white;height: 70px;width: 95%; top: 40px;position: relative;">
            <a href="HTTP://www.facebook.com">
                <i class="fa-brands fa-facebook"></i>
            </a>
            <a href="HTTP://www.x.com">
                <i class="fa-brands fa-x-twitter"></i>
            </a>
            <a href="HTTP://www.instagram.com">
                <i class="fa-brands fa-instagram"></i>
            </a>
            <a href="HTTP://www.github.com">
                <i class="fa-brands fa-github"></i>
            </a>
            <label  id="footer" style="right: -67%;position: relative;">© 2023 Lexi. All rights reserved.</label>
        </div>
    </div>
    </body>
    </html> 
    </template>
    <script>
    export default {
      name: 'index'
    }
    </script>
    <style>
        #elementContainer {
            margin-left: 20%;
        }
        #underlined1,
        #underlined2,
        #underlined3 {
            display: inline-block;
            margin-right: 20%;
            /* Adjust the margin as needed for spacing */
            text-decoration: underline;
            font-size: 30px;
            font-weight: bold;
        }
    </style>