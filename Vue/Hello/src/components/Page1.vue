<template>
  <div>
    {{msg}}
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data(){
      return{
          msg:"页面1"
      }
  }
}
</script>

<style>

</style>