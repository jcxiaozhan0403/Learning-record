<template>
<el-container>
  <el-aside width="200px">
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      background-color="#343a40"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="2" >
        <a href="#/queryPage"></a>
        <i class="el-icon-search"></i>
        <span slot="title">信息查询</span>
      </el-menu-item>
      <el-menu-item index="1" >
        
        <i class="el-icon-user"></i>
        <span slot="title">个人中心</span>
      </el-menu-item>
    </el-menu>
  </el-aside>
  
  <el-container id="main">
    <el-header style="text-align: right;">
      <span id="title">学生信息管理系统</span>
      <span class="userName">你好，王小虎</span>
      <el-link type="primary" :underline="false" id="logout">注销</el-link>
    </el-header>
    <queryPage id="subpage"></queryPage>
  </el-container>
</el-container>
</template>

<script>
import queryPage from './QueryPage.vue';
import personalCenter from './PersonalCenter.vue';
  export default {
    data() {
      return {
      }
    },
    methods:{
      onload() {
        console.log(sessionStorage.getItem("demo"));
      },
      pageToggle() {
        const pqueryPage = document.getElementById('subpage');
        const parent = pqueryPage.parentNode;
        const personalCenter = document.createElement('personalcenter');
        personalCenter.id = pqueryPage.id;
        parent.removeChild(pqueryPage);
        parent.appendChild(personalCenter);
      }
    },
    created() {
      this.onload();
    },
    components: {queryPage,personalCenter}
  };
</script>

<style>
.el-header {
    background-color: #343a40;
    color: rgba(255,255,255,.5);
    line-height: 60px;
    position: relative;
    width: 100.95%;
    height: 60px;
    bottom: 9px;
    right: 10px;
}
  
.el-aside {
    background-color: #343a40;
    display: block;
    position: absolute;
    left: 0;
    top: 59px;
    bottom: 0;
}

.el-menu {
    border-right: none;
    color: #fff;
}

.el-main {
    position: absolute;
    left: 200px;
    right: 0;
    top: 60px;
    bottom: 0;
    overflow: hidden;
}

.el-main div.el-table {
  height: 100%;
  overflow-y: scroll;
}

#title {
  position: absolute;
  left: 40px;
  color: #fff;
}

div.search {
  margin-bottom: 10px;
}

#logout {
  position: relative;
  left: 5px;
  color: rgba(255,255,255,.5);
}

#logout:hover {
  color: rgba(255,255,255,.7);
}

.userName {
  color: #fff;
}
</style>