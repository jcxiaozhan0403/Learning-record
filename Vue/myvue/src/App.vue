<template>
  <div id="app">
    <h1>Vue-Router</h1>

    <router-link to="/page1">子页1</router-link>
    <router-link to="/page2">子页2</router-link>
    <router-view></router-view>

  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>