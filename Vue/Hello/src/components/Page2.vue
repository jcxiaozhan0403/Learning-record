<template>
  <div>
    {{msg}}
    <a href="#/page2/child">子页面</a>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data(){
      return{
          msg:"页面2"
      }
  }
}
</script>

<style>

</style>