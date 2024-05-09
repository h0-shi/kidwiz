<template>
  <div class="login-container">
    <h1>Login</h1>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="username">Username:</label>
        <input id="username" v-model="username" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required>
      </div>
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    login() {
      axios.post('/login', {
        username: this.username,
        password: this.password
      }, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(() => {
        this.$router.push('/');  // Redirect to home on success
      })
      .catch(error => {
        console.error('Login error: 안됩니다', error);
      });
    }
  }
}
</script>

<style>
.login-container {
  max-width: 300px;
  margin: auto;
  padding-top: 50px;
}
.form-group {
  margin-bottom: 15px;
}
label {
  display: block;
}
input {
  width: 100%;
  padding: 8px;
}
button {
  width: 100%;
  padding: 10px;
  background-color: blue;
  color: white;
  border: none;
}
button:hover {
  background-color: darkblue;
}
</style>