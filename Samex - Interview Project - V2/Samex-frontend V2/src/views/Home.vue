<template>
  <div id="home">
    <img id="samexLogo" src="../assets/images/samexLogo.png"/>
    <p>Click the button to sign up to hear the latest news about our technology offerings</p>
    <button @click="$router.push('register')">SIGN UP</button>

  </div>
</template>

<script>
export default {
  name: 'home'
}
</script>

<style scoped>
#home {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 50px 0 0 0;
  
}
#samexLogo {
  width: auto;
  height:45px;
  justify-content: center;
}
#home>p {
  font-size: 26px;
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  font-weight: 600;
    color: #585656;
}
#home>button {
color: #fff;
text-decoration: none;
background: linear-gradient(to right,#136ef7, #58b35c);
padding: 16px;
border-radius: 5px;
display: inline-block;
border: none;
transition: all 0.4s ease 0s;
font-size: 22px;
font-family: "Montserrat", Helvetica, Arial, sans-serif;
}
#home>button:hover {
transform: scale(1.1);
}
@media (max-width: 500px) {
#home>p {
  font-size: 24px;
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  font-weight: 600;
  color: #6b6868;
  text-align: center;
}
}
</style>
