<template>
    <form action="https://www.google.com/search" method="GET" target="_blank">
        <label for="searchQuery" style="font-size: larger;color: rgb(82, 159, 221);margin-left: 800px;">Search:</label>
        <InputText type="text" id="searchQuery" name="q" size="small" required style="margin-left: 20px;"/>
        <btn type="submit" size="normal" style="margin-bottom: 3px; margin-left: 10px;color: #435cdb;"></btn>
    </form>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        
        <meta http-equiv="wlkefn" content="dvnwklw">
        <link name="viewPort" content="jkbqkj">
        
        <title>Lexi,your personal assistant</title>
        <link rel="stylesheet" href="styles.css">
        <link rel="icon" href="icon 1.png" type="image/x-icon">
        <link rel="shortcut icon" href="icon 1.png" type="image/x-icon"> 
        <!-- <script src="https://kit.fontawesome.com/cc58d8d11f.js" crossorigin="anonymous"></script> -->
    </head>
    <body>
        <label id="titre" style="color: #f76540;">
        </label>
        <!-- <a href="http://127.0.0.1:5500/index.html"> -->
        <router-link to="/">
        <img :src="require('@/assets/istockphoto-1312128591-612x612.jpg')" style="left:2%;top: 20px;  position: relative;width: 60px; height: 60px; ">
        <button id="homepage" style="width: 25px; height: 5px; font-size: 30px; font-family: 'Courier New', Courier, monospace;">
            <span id="additionalText">Move to homepage</span>
        </button>
    </router-link>
        <!-- </a> -->
        <div id="welcome">
            <label style="right:-40%;bottom:-40px; position: relative;font-size: 30px;color: #f76540;"><b>Welcome to dashboard</b></label>
            <br><br>
            <label style="right:-30%;bottom:-50px; position: relative;font-size: 50px;color: #0065ff;"><b>Hi,I'm Lexi How Can I Help You</b></label>
        </div>
        <br><br><br><br><br><br><br>
        <div id="board">
            <img :src="require('@/assets/WhatsApp Image 2023-11-11 at 6.13.35 AM.jpeg')" style="position: relative; right: -25% ; width:200px ;height:200px ;">
            <img :src="require('@/assets/WhatsApp Image 2023-11-11 at 6.13.49 AM.jpeg')" style="right:-50%;  position: relative;width:200px ;height:200px ;">
        </div>
    <div id="elementContainer">
        <div id="underlined1">Daily Activities Section</div>
        <router-link to="/mainboard">
        <!-- <router-link to="/leftbar">    -->
        <div id="underlined2">Work/Education Section</div>
    <!-- </router-link>  -->
    </router-link>
    <!-- <router-link to="/mainboard">
  <div id="underlined2">Work/Education Section</div>
</router-link>

<router-link to="/leftbar">
  <div id="underlined2">Leftbar Section</div>
</router-link>

<router-view></router-view> -->
    </div>
    </body>
    </html>  
    </template>
    <script>
    export default {
      name: 'dashboard'
    }
    </script>
    <style>
    #elementContainer {
        margin-left: 22%;
    }
    #underlined1,
    #underlined2 {
        display: inline-block;
        margin-right: 24%;
        text-decoration: underline;
        font-size: 30px;
        font-weight: bold;
    }
    </style>