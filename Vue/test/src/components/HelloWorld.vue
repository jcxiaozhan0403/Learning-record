<template>
  <div>
    <button @click="getxxx">点击</button>
    <span>{{ msg }}</span>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: ''
    }
  },
  methods:{
    getxxx:function(){
      var _this = this;
      this.$http.get("http://localhost:8080/api/test?name=111").then((res)=>{
        _this.msg = res.data;
      });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
