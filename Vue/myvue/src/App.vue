<template>
  <div id="app">
    <router-link to="/login">login</router-link>
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  name: 'App',
}
</script>