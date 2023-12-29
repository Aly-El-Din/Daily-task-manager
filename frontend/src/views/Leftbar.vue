<template>
    <div class="leftbar">
     <Button class="button" label="Tasks" icon="pi pi-angle-right"  iconPos="right" :class="{ 'icon-large': true }" />
     <Button class="button routines" label="Routines" icon="pi pi-angle-right"  iconPos="right" :class="{ 'icon-large': true }" />
    </div>
    <!-- <div class="spacer"></div> -->
 </template>
 
   
   <script>
 import Button from 'primevue/button';
//  import 'primeicons/primeicons.css'
 
   
   export default {
     components: {
     Button,
   },
     data() {
       return {
         username: "",
         password: "",
         usernameerror: "",
         passworderror: "",
         request: "",
       };
     },
     
     methods: {
       
    } };
 
 
 
   </script>
   
   <style>
   
 
 
   .leftbar {
   margin: 0 auto;
   width: 20%; /* Increased width for better visibility */
   height: 100%;
   font-size: 20px;
   top: 0%;
   left: 0%;
   background-color:#e2e2e2;
   display: grid;
   border-radius: 0px;
   user-select: none;
   position: absolute; /* Add position relative for absolute positioning of children */
 }
 .spacer{
     width: 2%;
     height: 100%;
     left:20%;
     top: 0%;
     background-color: #adadad;
     position: absolute;
 
 }
 .button{
     position: absolute;
     top: 10%;
     width: 100%;
     height: 10%;
     font-size: 40px;
     color: white;
     background-color: #f76540;
     letter-spacing: 2px;
     border: 3px solid black;
 }
 .routines{
     top:20%;
 }
 .button:hover{
     background-color:#c84626 ;
 }
 .icon-large .pi {
   font-size: 50px; /* Adjust the font-size to your preferred size */
 }
 
 
   </style>
   