<template>
  <!-- <div class="mode-toggle">
    <input type="checkbox" id="darkmode-toggle" v-model="darkMode" @change="toggleDarkMode" />
    <label class="darkmode-slider" :for="'darkmode-toggle'"></label>
  </div> -->
  <div class="mode-toggle">
    <input type="checkbox" id="darkmode-toggle" v-model="darkMode" @change="toggleDarkMode" />
    <label class="darkmode-slider" :for="'darkmode-toggle'">
      <span class="toggle-icon" :class="{ 'sun': !darkMode, 'moon': darkMode }"></span>
    </label>
    <div class="emoji-label">
      <span class="sun-emoji">☀️</span>
      <span class="moon-emoji">🌙</span>
    </div>
  </div>
  <div>
    <Index />
    <!-- <router-link to="/"></router-link> | -->
    <!-- <router-link to="/dashboard">DashBoard</router-link>
    <router-link to="/about">About</router-link>
    <router-link to="/about">About</router-link>  -->
  </div>
  <router-view/>
</template>
<script>
import login from './views/Login.vue'
export default {
  data() {
    return {
      darkMode: false,
    };
  },
  methods: {
    toggleDarkMode() {
      document.documentElement.setAttribute('data-theme', this.darkMode ? 'dark' : 'light');
      localStorage.setItem('theme', this.darkMode ? 'dark' : 'light');
    },
  },
  mounted() {
    // Check local storage for user preference
    const storedTheme = localStorage.getItem('theme');
    if (storedTheme) {
      this.darkMode = storedTheme === 'dark';
      this.toggleDarkMode();
    }
  },
  name: 'App',
    components: {
      login,
    }
};
</script>


<style>
#titre{
    margin-left: 10px;
    font-family:cursive;
    font-size: xx-large;
}
#div1{
    text-align:left;
    font-size:larger;
    font-family: sans-serif;
    background-size:cover;
}
#desc{

    margin-left: 110px;
}
     #dashboard {
         color: white;
         font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
         background-color: #f76540;
         right: -1250px;
         top: 30px;
         position: relative;
         width: 5px;
         size: 50px;
         border-top-left-radius: 10px;
         border-top-right-radius: 10px;
         border-bottom-left-radius: 10px;
         border-bottom-right-radius: 10px;
     }
     #homepage{
         color: white;
         font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
         background-color: rgb(0, 0, 0);
         top: 3px;
         position: relative;
         width: 30px;
         size: 30px;
         border-top-left-radius: 4px;
         border-top-right-radius: 4px;
         border-bottom-left-radius: 4px;
         border-bottom-right-radius: 4px;

     }
     #additionalText {
        display: none;
        position: absolute;
        top: 100%;
        left: 50%;
        transform: translateX(-50%);
        background-color: black;
        color: white;
        padding: 5px;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
    }
#dashboard:hover #additionalText {
    display: block;
}
#homepage:hover #additionalText {
    display: block;
}
#vision{
   text-align: center; 
   width: 500px;
   right:-500px;
   position: relative;
}
#mission{
   text-align: center;
   position: relative;
   right:-500px;
   width: 500px;    
}
#dashboard:hover{
        color: black;
            background-color: #f8f3f0;
            border-top-left-radius: 200px;
            border-top-right-radius: 200px;
            border-bottom-left-radius: 200px;
            border-bottom-right-radius: 200px;
        }
#p1{

    text-align: left;
    font-size:xx-large;
    font-family: sans-serif;
    width: 400px;
    position: relative;
    left: 50%;
    top: 100px;

}

#contacts{
    text-align: left;
    bottom: 0;
    left: 2%;

    position:relative;
    font-size: 25px;
}
.fa-github{
color:black;
}
.fa-x-twitter{
color: black;
}
.fa-instagram{
color:rgb(254, 117, 222);
}
.fa-facebook{
color:blue;
}
.box{
background-color: #116A7B;
height: 200px;
width: 200px;
}
.vl {
border-left: 6px solid #dd7b17;
height: 550px;
position: absolute;
left: 45%;
margin-left: -3px;
top: 30%;
border-top-left-radius: 10px;
border-top-right-radius: 10px;
border-bottom-left-radius: 10px;
border-bottom-right-radius: 10px;
background-attachment: fixed;
background-size: cover;
}
.img {
   width: 500px;
   height: 300px;
   left: 10%;
top: -100px;
  
   position: relative;
   background-attachment: fixed;
   border-top-left-radius: 10px;
   border-top-right-radius: 10px;
   border-bottom-left-radius: 10px;
   border-bottom-right-radius: 10px;
   max-width: 100%;
   height: auto;
}
    #slogan {
        font: 1em sans-serif;
        font-weight: 900;
        font-size: 5.2ch;
        width: 500px;
        height: 100px;
        left: 10%;
        top: -240px;
        /*   bottom:100px; */
        position: relative;
    }

#footer {
  color:black;
  text-align: center;
  padding: 1em 0;
  width: 100%;
}
#slide3MainText {
  text-align: center;
  font-weight: 300;
  font-size: 5ch;
}

#slide-3 {
  text-align: center;
  font-family: cursive;
}

.slide3Icons {
  background-color: #f8f3f0;
  position: relative;
  text-align: left;
  height: 900px;
}

.icon1 {
  left: 15%;
  position: relative;
  font-family: cursive;
  font-weight: 400;
}
 /* css for the dark mode button */
.mode-toggle {
  display: flex;
  align-items: center;
}

.darkmode-toggle {
  cursor: pointer;
}

.toggle-icon {
  font-size: 1.5em;
  display: inline-block;
}
/* #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  } */
/* Add your dark mode styles here */
[data-theme='dark'] {
  background-color: #121212;
  color: #ffffff;
}
.darkmode-slider::before {
  content: '';
  width: 24px;
  height: 24px;
  background-color: #fff;
  border-radius: 50%;
  position: absolute;
  top: 1px;
  left: 1px;
  transition: transform 0.3s; /* This line specifies the transition effect */
}

#darkmode-toggle:checked + .darkmode-slider::before {
  transform: translateX(24px); /* This line moves the slider to the right when dark mode is enabled */
}

.darkmode-slider {
  position: relative;
  width: 50px;
  height: 26px;
  background-color: #ccc;
  border-radius: 13px;
  cursor: pointer;
  display: inline-block;
}

.toggle-icon {
  font-size: 1.5em;
  display: inline-block;
}

.darkmode-slider::before {
  content: '';
  width: 24px;
  height: 24px;
  background-color: #fff;
  border-radius: 50%;
  position: absolute;
  top: 1px;
  left: 1px;
  transition: transform 0.3s;
}

#darkmode-toggle:checked + .darkmode-slider::before {
  transform: translateX(24px);
}

[data-theme='dark'] .mode-toggle {
  background-color: #333; /* Adjust as needed */
}

[data-theme='dark'] .darkmode-slider {
  background-color: #555; /* Adjust as needed */
}

[data-theme='dark'] .darkmode-slider::before {
  background-color: #fff;
}
</style>
