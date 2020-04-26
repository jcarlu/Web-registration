<template>
    <body>
        <h1>Congrats!  We will be in touch with our latest business solutions.</h1>
        <button @click="$router.push({ name: 'home' })">Back To Home</button>
    </body>
</template>

<script>
export default {
    
}
</script>

<style scoped>
body {
    display: flex;
    flex-direction: column;
    align-items: center;
}
h1 {
    margin: 50px 0 30px 0;
}
button {
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
button:hover {
transform: scale(1.1);
}
@media (max-width: 950px) {
h1 {
  font-size: 23px;
  text-align: center;
}
#register {
  display:flex;
  justify-content: center;
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  height: 794px;
}
}
</style>