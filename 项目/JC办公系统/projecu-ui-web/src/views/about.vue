<template>
  <div class="container">
    <van-nav-bar
      title="关于我们"
    />
    <div class="detail-wrap">
      <div class="item">
        本项目使用了多种技术和框架来实现功能，包括Vue-Admin-Template框架、ElementUI组件库、SpringSecurity安全框架、JWT身份验证、Redis缓存、Activiti工作流引擎等。
        前端采用了Vue.js框架，使用Vue-Admin-Template框架和ElementUI组件库完成了界面开发，界面友好易用；
        后端使用SpringBoot框架，采用SpringSecurity框架进行权限验证，并使用Redis缓存保存用户登录状态，保证了系统的安全性。
        通过使用Activiti工作流引擎，系统实现了审批流程自动化处理，提高了工作效率。
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "process",

  data() {
    return {
    };
  },

  created(){
  },

  methods: {

  }
}
</script>

<style lang="scss" scoped>
.container {
  padding: 20px;
  .detail-wrap {
    .item {
      color: #838485;
    }
  }
}
</style>
