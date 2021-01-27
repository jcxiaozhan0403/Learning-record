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
          msg:"你好Vue"
      }
  },
  methods:{
    findAll(){
      this.$http.get("地址").then((res)=>{
        console.log(res);
        if(res.data.success){
          this.$router.push("/page2");//切换路由
        }
      });
    }
  },
  components:{},
  created(){
    this.findAll();
  },
  // 监听路由
  watch: {
    $route: {
      handler:function(val,oldVal){
        console.log(val);
        if(val.path=='/user'){
          this.findAll();
        }
      },
      //深度监听
      deep:true
    }
  }
}
</script>

<style>

</style>