// import { createApp } from 'vue'
// import App from './App.vue'
// import router from './router'
// import InputText from 'primevue/inputtext'; 
// import PrimeVue from 'primevue/config';
// import Password from 'primevue/password';
// import InlineMessage from 'primevue/inlinemessage';
// import 'primevue/resources/themes/md-light-indigo/theme.css';

import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config';
import Button from 'primevue/button';
import 'primeicons/primeicons.css'
import router from './router'
import Password from 'primevue/password';
import InlineMessage from 'primevue/inlinemessage';
import Divider from 'primevue/divider';
import InputText from 'primevue/inputtext';
import Textarea from 'primevue/textarea';
import Calendar from 'primevue/calendar';
import InputSwitch from 'primevue/inputswitch';
import 'primevue/resources/themes/md-light-indigo/theme.css';
import 'primevue/resources/themes/saga-orange/theme.css';

// app.use(PrimeVue);
//  app.component('InputText', InputText);
// app.component('Password',Password);
// app.component('InLineMessage',InlineMessage);


// createApp(App).use(router).mount('#app')
const app=createApp(App).use(router)
app.use(PrimeVue);
app.component('Button',Button);
app.component('Divider',Divider);
 app.component('InputText',InputText);
app.component('Textarea',Textarea);
app.component('Calendar',Calendar);
app.component('InputSwitch',InputSwitch);
app.component('Password',Password);
app.component('InLineMessage',InlineMessage);

app.mount('#app')
