import Vue from "vue";
import VueRouter from "vue-router";
import Main from "../components/Main";
import Login from "../components/Login";
import Profile from "../components/user/Profile";
import List from "../components/user/List";

//安装路由
Vue.use(VueRouter);

//配置导出路由
export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/main',
      component: Main,
      //路由嵌套
      children: [
        {
          path: '/user/profile/:id',
          name: 'Profile',
          component: Profile,
          props:true
        },
        {path: '/user/list',component: List}
      ]
    },
    {
      path: '/login',
      component: Login
    }
  ]
})