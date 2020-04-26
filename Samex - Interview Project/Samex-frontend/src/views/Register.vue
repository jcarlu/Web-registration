<template>
  <div id="register" class="text-center">
    <form id="form-register" @submit.prevent="register">
      <img id="samexLogo" src="../assets/images/samexLogo.png"/>
      <h1 id="formHeader">Add your contact info to be informed about our latest business solutions</h1>
      <div id="errorAlert" role="alert" v-if="registrationErrors">
        <p>Please enter your information in the proper format;</p>
        <p>- Names consist of letters / hyphens / apostrophes only</p>
        <p>- Phone number examples: (313)123-4567, 248-123-4567</p>
        <p>- Email: janedoe@example.com, johndoe@example.io, etc...</p>
      </div>
      <label for="firstName" class="labels">First Name</label>
      <input
        type="text"
        id="firstName"
        name="firstName"
        class="form-control"
        placeholder="First Name - Required"
        v-model="subscriber.firstName"
        required
        autofocus
      />
      <label for="lastName" class="labels">Last Name</label>
      <input
        type="text"
        id="lastName"
        class="form-control"
        placeholder="Last Name"
        v-model="subscriber.lastName"
        autofocus
      />
      <label for="email" class="labels">Email</label>
      <input
        type="email"
        id="email"
        class="form-control"
        placeholder="Email Address - Required"
        v-model="subscriber.email"
        required
        autofocus
      />
      <label for="phoneNumber" class="labels">Phone Number</label>
      <input
        type="tel"
        id="phoneNumber"
        class="form-control"
        placeholder="Phone Number xxx-xxx-xxxx"
        v-model="subscriber.phoneNumber"
        autofocus
      />
     
      <button id="submitButton" type="submit">
        Click here to join our contact list
      </button>
      <img id="samexLogo" src="../assets/images/samexLogo.png"/>
    </form>
  </div>
</template>

<script>
export default {
  name: 'register',
  data() {
    return {
      subscriber: {
        firstName: null,
        lastName: null,
        email: null,
        phoneNumber: null
      },
      registrationErrors: false,
    }    
  },
  methods: {
    register() {
      fetch(`http://localhost:8080/SamexInterviewProject/api/register`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.subscriber),
      })
         .then((response) => {
          if (response.ok) {
            this.$router.push({ path: '/registration/success'});
          } else {
            this.registrationErrors = true;
          }
        })
    },
  },
};
</script>

<style>
#register {
  display:flex;
  justify-content: center;
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  height: 1200px;
}
#form-register {
  display:flex;
  flex-direction: column;
  width: 600px;
  align-items: center;
  color:blue;
  margin: 50px 0 0 0;
  text-align: center;
}
.form-control {
  margin: 0 0 20px 0;
  font-size: 18px;
  width: 260px;
}
.labels {
  text-align: left;
  font-weight: bold;
  font-size: 20px;
  
}
#submitButton {
  margin: 0 0 20px 0;
  font-size: 14px;
  width: 260px;
  height: 34px;
  border-radius: 6px;
  border:blue;
  border-width: 5px;
  border-style: solid;
  font-weight: 600;
  color: #4d4a4a;
  background-color: white;
  transition: all 0.4s ease 0s;
}
#submitButton:hover {
  transform: scale(1.1);
}
#errorAlert {
  font-size: 20px;
  font-weight: bold;
  color: red;
}
@media (max-width: 500px) {
#formHeader {
  color:blue;
  font-size: 18px;
}
#register {
  display:flex;
  justify-content: center;
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  height: 794px;
}
#errorAlert {
  font-size: 20px;
  font-weight: bold;
  color: red;
  width: 320px;
}
}
</style>
