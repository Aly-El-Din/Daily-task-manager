<template>
    <div class="how">
      <div class="text">Today</div>
      <div class="taskno">{{ tasks.length }} tasks</div>
      <div class="text2" @click="add">Add task</div>
  
      <hr class="spacer">
      <button class="add" @click="add">+</button>
      
      <div class="task-container" > 
      <div v-for="(task, index) in tasks" :key="index" class="task" >
        <h3 class="task-text">{{ task.name }}</h3>
        <p class="task-text second">{{ task.description }}</p>
        <button class="flag-btn" v-if="task.priority"><i class="pi pi-flag"></i></button>
        <button class="view-btn" @click="view(index)"><i class="pi pi-eye"></i></button>
        <button  @click="editTask(index)" class="edit-btn"  ><i class="pi pi-pencil"></i></button>
        <button class="delete-btn" @click="deleteTask(index)"><i class="pi pi-trash"></i> </button>
        <hr :style="{ 'top': getTopPosition(index) + '%', 'border-color': '#d0cdcd', 'height': '2px', 'border-width': '0 0 2px 0'}">
  
        
  
      </div>
    </div> 
    <div class="modal" v-if="show">
        <p style="font-size: 50px; color: black; font-weight: bold;" >Create a new task</p>
        <p class="popup name">Task's name:</p>
        <InputText class="input bar1" type="text" v-model="taskname" :disabled="viewer"/>
        <p class="popup desc">Task's description:</p>
        <Textarea  class="input bar2"  v-model="text" rows="5" cols="30" :disabled="viewer"/>
        <p class="popup date">Task's due date:</p>
        <Calendar class="input bar3"  v-model="date" showIcon :disabled="viewer"/>
        <p class="popup pri">Task's priority:</p>
        <InputSwitch  class=" slider"   v-model="slider" @change="handleChange" :disabled="viewer"/>
        <button class="save" @click="save" v-if="saver">Save and exit</button>
        <button class="save" @click="exit" v-if="viewer">Exit</button>
  
      </div>
  
      
     
    </div>
  </template>
  
  <script>
  import Divider from 'primevue/divider';
  import InputText from 'primevue/inputtext';
  import Textarea from 'primevue/textarea';
  import Calendar from 'primevue/calendar';
  import InputSwitch from 'primevue/inputswitch';
  
  
  
  export default {
    components:{
      Divider,
      InputText,
      Textarea,
      Calendar,
      InputSwitch,
    },
   
    handleChange(){
      slider=!this.slider;
      this.importance=slider;
  
    },
    computed: {
      // Compute the top position based on index
      getTopPosition() {
        return (index) => {
  
          return 14 + index*14+this.increment;
          this.increment+=index;
        };
      },
    },
    data() {
      return {
        tasks:[],
        show:false,
        slider:false,
        taskname:'',
        date:'',
        text:'',
        importance:false,
        increment:0,
        edit:false,
        taskindex:null,
        viewer:false,
        saver:true,
      };
    },
    methods: {
      view(index){
        this.saver=false;
        this.show=true;
        this.viewer=true;
      },
      exit(){
        this.show=false;
        this.viewer=false;
        this.saver=true;
  
      },
  
      
      deleteTask(index) {
        this.tasks.splice(index, 1); // Removes the task at the given index
      },
      editTask(index) {
        this.viewer=false;
        this.saver=true;
        this.taskindex=index;
        this.edit=true;
        this.taskname = this.tasks[index].name;
        this.date = this.tasks[index].dueDate;
        this.text = this.tasks[index].description;
        this.slider=this.tasks[index].priority;
        this.show = true;
      },
  
      save(index){
        this.show=false;
        if(this.edit===true)
        {
          this.tasks[this.taskindex].name=this.taskname;
          this.tasks[this.taskindex].dueDate=this.date;
          this.tasks[this.taskindex].description=this.text;
          this.tasks[this.taskindex].priority=this.slider;
        }
        else{
        const newTask = {
          name: this.taskname,
          dueDate: this.date,
          description: this.text,
          priority: this.slider,
        };
        this.tasks.push(newTask);}
        this.edit=false;
      },
      add(){
        this.show=true;
        this.taskname='';
        this.text='';
        this.date='';
        this.slider=false;
        
      }
  
    }
  };
  </script>
  
  <style scoped>
  /* Styles for the task component */
  .task-container{
    user-select: none;
    top: 22%;
    width: 85%;
    left:8%;
    background-color: rgb(246, 243, 243);
    margin-bottom: 10px;
    height: 75%;
    position: absolute;
    border-radius: 30px;
    overflow: auto;
    border: 1px solid black;
  
  }
  .flag-btn{
    position: relative;
    left: 38%;
    top: 10%;
    height: 50px;
    width: 50px;
    background-color: transparent;
    border: none;
  }
  
  .view-btn{
    position: relative;
    left: 40%;
    top: 10%;
    height: 50px;
    width: 50px;
    background-color: transparent;
    border: none;
  }
  .edit-btn{
    position: relative;
    left: 42%;
    top: 10%;
    height: 50px;
    width: 50px;
    background-color: transparent;
    border: none;
    
  }
  .delete-btn{
    position: relative;
    left: 44%;
    top: 10%;
    height: 50px;
    width: 50px;
    background-color: transparent;
    border: none;
  }
  .pi {
    font-size: 3rem; /* Adjust the size of the icon */
    color: black;
  }
  
  .task{
  
    margin-bottom: 10px; /* Adjust as needed */
    padding: 10px; /* Adjust as needed */
  
  
  }
  
  
  .spacer{
    width: 85%;
    height: 5px;
    top: 2%;
    left: 0.5%;
    position: relative;
    border-width: 0px;
    opacity: 75%;
  }
  
  
  .how{
    user-select: none;
    top: 0%;
    width: 78%;
    left:22%;
    background-color: white;
    margin-bottom: 10px;
    height: 100%;
    position: absolute;
  }
  .text{
  position:relative;
  top:2%;
  font-size: 75px;
  font-weight: bold;
  }
  .text2{
  position:absolute;
  left: 15%;
  top:15.5%;
  font-size: 50px;
  font-weight: bold;
  }
  .task-text{
  position:relative;
  left: 0%;
  font-size: 50px;
  font-weight: bold;
  text-align: left;
  }
  .second{
    font-size: 25px;
    font-weight: lighter;
  }
  .taskno{
  position: relative;
  top:2.5%;
  font-size: 40px;
  
  }
  .divider{
    position: relative;
  }
  .modal{
    top: 10%;
    bottom: 10%;
    width: 1400px;
    left:20%;
    background-color: #93cdea;
    margin-bottom: 10px;
    height: 1200px;
    position: absolute;
    border-radius: 40px;
    border: 3px solid black; /* Change 'blue' to your desired border color */
  
  }
  .popup{
    position: absolute;
    left: 2%;
    font-size: 40px;
    color: black;
    font-weight: 650;
  }
  .name{
    top: 9%;
  }
  .desc{
    top:23%;
  }
  .date{
    top: 43%;
  }
  .pri{
    top: 57%;
  }
  .input{
    position: absolute;
    left: 1.8%;
    font-size: 40px;
    color: black;
    border-radius: 6px;
  
  }
  .bar1{
    top: 18%;
    
  }
  .bar2{
    width: 500px;
    height: 150px;
    top: 32%;
    font-size: 25px;
    font-weight: 400;
  }
  .bar3{
    top: 52%;
    left: 1.8%;
    width: 500px;
    height: 80px;
  }
  .slider{
    scale: 2;
    right: 44.5%;
    top: 53%;
    position: absolute;
  }
  .save
  {
  
    width: 800px;
    height: 100px;
    top: 80%;
    left: 20%;
    position: absolute;
    font-size: 50px;
    font-weight: 700;
    border-radius: 10px;
    background-color: #f7b93d;
  }
  .save:hover{
    background-color: #c89530;
  
  }
  .add{
    position: absolute;
    top: 14%;
    left: 10%;
    width: 100px;
    height: 100px;
    font-size: 75px;
    border-radius: 50%;
    background-color: transparent;
    border-width: 8px;
    font-weight: 700;
  }
  </style>
  