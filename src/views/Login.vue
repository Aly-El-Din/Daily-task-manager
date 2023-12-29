<template>
  <div class="login-cont">
    <InlineMessage class="mess1" v-if="this.usernameerror">Incorrect username</InlineMessage>
    <InlineMessage class="mess2" v-if="this.passworderror">Incorrect password</InlineMessage>
   <div class="LoginPage">
    <div :style="{ width: '10%' }">
    <div class="login-container" @click="check">
      <div class="text">Login to your account</div>
      <div class="username-container">
        <InputText type="text" v-model="username" />
  
        <label for="path" v-if="!isusernameNotEmpty">Username</label>
      </div>
  
  
  
      <div class="password-container">
        <Password v-model="password" :feedback="false" />
        <label v-if="!ispasswordNotEmpty">Password</label>
      </div>
      <!-- <router-link to="/dashboard"> -->
      <button class="button" @click="login">Login</button>
    <!-- </router-link> -->
      <div class="forgot">Forgot password?</div>
    </div>
    <div class="vertical-line"></div>
    <div class="signin-container">
      <div class="signin">New to LEXI?</div>
      <div class="signup">
        Sign up now and<br />
        &nbsp;&nbsp;&nbsp; manage your tasks
      </div>
      <router-link to="/signup">
      <button class="button2">Sign up</button>
    </router-link>
    </div>
</div>
</div>
</div>

  </template>
  
  <script>
   import InputText from "primevue/inputtext";
  import Password from "primevue/password";
  import InlineMessage from "primevue/inlinemessage";
  
  export default {
    components: {
      InputText,
      Password,
      InlineMessage,
    },
    data() {
      return {
        username: "",
        password: "",
        usernameerror: false,
        passworderror: false,
        request: "",
        widthPercentage: 50,
  
      };
    },
    computed: {
      isusernameNotEmpty() {
        return this.username.trim() !== "";
      },
      ispasswordNotEmpty() {
        return this.password.trim() !== "";
      },
    },
    methods: {
      login() {
        console.log("Request Data:", this.username, this.password);
  
        const requestData = {
          userName: this.username,
          password: this.password,
        };
        this.usernameerror = false;
        this.passworderror = false;
  
        fetch("http://localhost:8085/login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(requestData),
        })
          .then((response) => {
            console.log("Response Status:", response.status);
  
            if (response.ok) {
              return response.text(); // Assuming the server sends a plain string
            } else {
              throw new Error("Network response was not ok");
            }
          })
          .then((data) => {
            console.log("Response Data:", data);
  
            // Check the response and handle errors here
            if (data === "Wrong username") {
              this.usernameerror = true; 
            } else if (data === "Wrong password") {
              this.passworderror = true;
                          
            } else {
          // Successful login, navigate to "/dashboard"
          this.$router.push("/dashboard");
        }
          })
          .catch((error) => {
            console.error("Fetch Error:", error);
          });
      },
    },
    created() {
    // Check if the parameter is provided in the route
    if (this.$route.params.widthPercentage) {
      // Update the widthPercentage based on the parameter
      this.widthPercentage = parseInt(this.$route.params.widthPercentage);
    }
  },
  };
  </script>
  
  <style scoped>
  .login-cont {
  widows: 100000px; /* Set a static width (e.g., 50%) */
  /* You can still have other scoped styles here */
}
  .login-container {
    margin: 0 auto;
    width: 1000px; 
    height: 1300px;
    font-size: 20px;
    left: 10%;
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    grid-auto-rows: minmax(50px, auto);
    border-radius: 25px;
    user-select: none;
    position: absolute; /* Add position relative for absolute positioning of children */
  }
  .signin-container {
    margin: 0 auto;
    width: 1000px; /* Increased width for better visibility */
    height: 1300px;
    font-size: 20px;
    left: 63%;
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    grid-auto-rows: minmax(50px, auto);
    border-radius: 25px;
    user-select: none;
    position: absolute; /* Add position relative for absolute positioning of children */
  }
  .button {
    width: 480px; /* Add specific width for the button */
    height: 100px; /* Add specific height for the button */
    border-radius: 35px;
    font-size: 50px;
    background-color: #0076ff;
    border: 7px solid #025abf;
    color: white;
    position: absolute; /* Position the button */
    bottom: 20px; /* Adjust this value for desired vertical positioning */
    left: 58%; /* Center horizontally */
    bottom: 32%;
    transform: translateX(-50%); /* Center horizontally */
  }
  .button2 {
    width: 380px; /* Add specific width for the button */
    height: 100px; /* Add specific height for the button */
    border-radius: 35px;
    font-size: 50px;
    color: white;
    background-color: #f76540;
    border: 7px solid #c73e2c;
    position: absolute; /* Position the button */
    bottom: 20px; /* Adjust this value for desired vertical positioning */
    left: 50%; /* Center horizontally */
    bottom: 32%;
    transform: translateX(-50%); /* Center horizontally */
  }
  .button:hover {
    background-color: rgb(0, 100, 200);
  }
  .button2:hover {
    background-color: rgb(220, 65, 41);
  }
  
  .username-container {
    position: absolute; /* Position the container */
    scale: 2;
    left: 69%; /* Center horizontally */
    top: 45%; /* Center vertically */
    transform: translate(
      -50%,
      -50%
    ); /* Center both horizontally and vertically */
  }
  .mess1{
    position: absolute; /* Position the container */
    scale: 2;
    font-size: 40px;
    left:47.5%; /* Center horizontally */
    top: 45.5%; /* Center vertically */
    transform: translate(
      -50%,
      -50%
    );
  }
  .mess2{
    position: absolute; /* Position the container */
    scale: 2;
    font-size: 40px;
    left:47.5%; /* Center horizontally */
    top: 54.55%;/* Center vertically */
    transform: translate(
      -50%,
      -50%
    );
  }
  
  .username-container label {
    position: absolute;
    top: 5px;
    left: 8px;
    pointer-events: none;
    color: #333;
    font-size: 12px;
    opacity: 40%;
  }
  .password-container {
    position: absolute; /* Position the container */
    scale: 2;
    left: 69%; /* Center horizontally */
    top: 55%; /* Center vertically */
    transform: translate(
      -50%,
      -50%
    ); /* Center both horizontally and vertically */
  }
  
  .password-container label {
    position: absolute;
    top: 5px;
    left: 8px;
    pointer-events: none;
    color: #333;
    font-size: 12px;
    opacity: 40%;
  }
  .text {
    position: absolute;
    font-size: 70px;
    top: 30%;
    left: 25%;
    color: black;
    -webkit-text-stroke: 2px black;
  }
  .forgot {
    position: absolute;
    font-size: 30px;
    top: 70%;
    left: 35%;
    color: black;
    opacity: 50%;
  }
  .signin {
    position: absolute;
    font-size: 70px;
    top: 35%;
    left: 30%;
    color: black;
    -webkit-text-stroke: 2px black;
  }
  .signup {
    position: absolute;
    font-size: 45px;
    top: 47%;
    left: 26.5%;
    color: black;
    -webkit-text-stroke: 1px black;
  }
  
  .vertical-line {
    margin: 0 auto;
    width: 5px; /* Increased width for better visibility */
    height: 1416px;
    font-size: 5px;
    top: 0;
    left: 60%;
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    grid-auto-rows: minmax(50px, auto);
    border-radius: 25px;
    background-color: #f76540;
    user-select: none;
    position: absolute; /* Add position relative for absolute positioning of children */
  }
  #LoginPage {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
  
  </style>
  