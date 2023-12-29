<template>
    <div class="page">
      <div class="firstHalf">
        <div class="margaining">
          <h1>Sign up</h1>
          <p>
            We're thrilled to have you on board as we embark on a journey of
            enhanced productivity and collaboration. This group is your go-to
            space for seamless communication, quick updates, and shared victories
            as we conquer our tasks and goals together.
          </p>
          <div class="texts">Username</div>
          <div v-if="userempty" id="Agreement">fill this section</div>
          <InputText
            v-model="Username"
            size="normal"
            placeholder="Enter Username"
          />
          <InlineMessage v-if="usercheck">{{ returnedstatement }}</InlineMessage>
          <div>
            <div class="texts">
              <label for="phone">Phone Number </label>
              <label for="dropdow" style="margin-left: 130px">Gender</label>
              <div id="Agreement" v-if="phempty">fill this section</div>
            </div>
  
            <InputText
              type="text"
              id="phone"
              v-model="phonenumber"
              placeholder="Enter number"
            />
  
            <Dropdown
              v-model="ChoosenGender"
              :options="genders"
              id="dropdow"
              optionLabel="name"
              placeholder="male"
              style="margin-left: 50px"
            />
          </div>
          <div class="texts">Date of Birth</div>
          <div v-if="dobempty" id="Agreement">fill this section</div>
          <Calendar
            v-model="date"
            dateFormat="dd/mm/yy"
            placeholder="Choose Date"
          />
          <div class="texts">Email</div>
          <div v-if="emempty" id="Agreement">fill this section</div>
          <InputText type="text" v-model="email" placeholder="Enter Email" />
          <div class="texts">Password</div>
          <Password
            v-model="password"
            toggleMask
            id="password"
            placeholder="Enter Password"
          >
            <template #header>
              <h6>Pick a password</h6>
            </template>
            <template #footer>
              <Divider />
              <p class="mt-2">Suggestions</p>
              <ul class="pl-2 ml-2 mt-0" style="line-height: 1.5">
                <li>At least one lowercase</li>
                <li>At least one uppercase</li>
                <li>At least one numeric</li>
                <li>Minimum 8 characters</li>
                <li>One special character</li>
              </ul>
            </template>
          </Password>
          <InlineMessage v-if="passcheck">{{ returnedstatement }}</InlineMessage>
  
          <form action="">
            <br />
            <Checkbox
              v-model="checked"
              :binary="true"
              id="check"
              @change="ischecked"
            />
            <label for="check" class="texts" style="margin-left: 20px"
              >By clicking this you agree to </label
            ><a href="">terms and Conditions</a>
          </form>
          <br />
          <div v-if="warning" id="Agreement" class="texts">
            You must Agree to terms and Conditions
          </div>
          <!-- <router-link to="/dashboard"> -->
          <btn label="Sign up" id="signbutton" @click="SubmitInfo" />
          <!-- </router-link> -->
        </div>
      </div>
  
      <div class="secondHalf">
        <img src="@\assets\siup.png" class="image" />
      </div>
    </div>
  </template>
  
  <script>
  import Calendar from "primevue/calendar";
  import AutoComplete from "primevue/autocomplete";
  import Password from "primevue/password";
  import Checkbox from "primevue/checkbox";
  import btn from "primevue/button";
  import Dropdown from "primevue/dropdown";
  import InputText from "primevue/inputtext";
  import Divider from "primevue/divider";
  import InlineMessage from "primevue/inlinemessage";
  import Slider from "primevue/slider";
  import axios from "axios";
  
  export default {
    name: "HelloWorld",
    components: {
      Calendar,
      AutoComplete,
      Password,
      Checkbox,
      btn,
      Dropdown,
      InputText,
      Divider,
      InlineMessage,
      Slider,
    },
    data() {
      return {
        Username: "",
        date: "",
        password: "",
        checked: true,
        genders: [{ name: "male" }, { name: "female" }],
        ChoosenGender: "male",
        phonenumber: "",
        email: "",
        warning: false,
        passcheck: false,
        usercheck: false,
        userempty: false,
        dobempty: false,
        genempty: false,
        emempty: false,
        phempty: false,
        returnedstatement: "",
      };
    },
    methods: {
      WriteUserName() {
        if (this.Username === "") {
          this.userempty = true;
        } else {
          this.userempty = false;
        }
        return this.userempty;
      },
      Writephonenumber() {
        if (this.phonenumber === "") {
          this.phempty = true;
        } else {
          this.phempty = false;
        }
        return this.phempty;
      },
      WriteGender() {
        if (this.ChoosenGender === "") {
          this.genempty = true;
        } else {
          this.genempty = false;
        }
      },
      ChDateofBirth() {
        if (this.date === "") {
          this.dobempty = true;
        } else {
          this.dobempty = false;
        }
      },
      WriteEmail() {
        if (this.email === "") {
          this.emempty = true;
        } else {
          this.emempty = false;
        }
      },
      writePassword() {
        const requestData = {
          userName: this.Username,
          password: this.password,
        };
        axios
          .post("http://localhost:8085/signup", requestData)
          .then((response) => {
            this.returnedstatement = response.data;
            this.checkedpassAndUser(this.returnedstatement);
          })
          .catch((error) => {
            console.error("There was an error!", error);
            reject(error);
          });
      },
      checkedpassAndUser(value) {
        console.log(value);
        if (value === "Welcome") {
          this.usercheck = false;
          this.passcheck = false;
        } else {
          if (value === "Username already in use") {
            this.usercheck = true;
            this.passcheck = false;
          } else {
            this.passcheck = true;
            this.usercheck = false;
          }
        }
      },
      ischecked() {
        if (this.checked) {
          this.warning = false;
        }
      },
      SubmitInfo() {
      if (this.checked) {
        this.WriteUserName();
        this.Writephonenumber();
        this.WriteGender();
        this.ChDateofBirth();
        this.WriteEmail();
        this.writePassword();

        // Check if data is correct before navigating to "/dashboard"
        if (!this.userempty && !this.phempty && !this.genempty && !this.dobempty && !this.emempty && !this.passcheck && !this.usercheck) {
          this.$router.push("/dashboard");
          this.warning = false;
        } else {
          this.warning = false; // If the data is not correct, you may want to handle this differently
        }
      } else {
        this.warning = true;
      }
    },
  },
};
</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  .page {
    width: 100%;
    height: 775px;
    background-color: #f3f3f3;
  }
  .firstHalf {
    width: 50%;
    height: 775px;
    background-color: #f3f3f3;
    float: left;
  }
  .secondHalf {
    width: 50%;
    height: 770px;
    background-color: #f3f3f3;
    float: left;
    align-content: center;
    text-align: center;
  }
  .texts {
    font-size: large;
    font: 700;
    margin-bottom: 10px;
    margin-top: 10px;
  }
  /* #signbutton{
  } */
  #check:checked {
    background-color: #f76540;
  }
  .image {
    height: 400px;
    width: 400px;
    margin-top: 25%;
  }
  #password:active {
    border: #f3f3f3;
    border-block: 5px;
  }
  .margaining {
    margin-left: 20px;
  }
  #Agreement {
    color: red;
  }
  #younes {
    color: red;
  }
  </style>
  