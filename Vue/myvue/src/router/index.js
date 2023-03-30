import Vue from "vue";
import VueRouter from "vue-router";
import Page1 from "../components/Page1";
import Page2 from "../components/Page2";

//安装路由
Vue.use(VueRouter);

//配置导出路由
export default new VueRouter({
  routes: [
    {
      //路由路径
      path: '/page1',
      name: 'page1',
      //跳转的组件
      component: Page1
    },
    {
        //路由路径
        path: '/page2',
        name: 'page2',
        //跳转的组件
        component: Page2
    }
  ]
})