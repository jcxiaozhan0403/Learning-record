import Vue from 'vue'
import Router from 'vue-router'
import Home from "../components/Home"
import Page1 from "../components/Page1"
import Page2 from "../components/Page2"
import Page2Child from "../components/Page2Child"

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/',redirect: "/home"},
    {path: '/home',component: Home},
    {path: '/page1',component: Page1},
    {
      path: '/page2',
      component: Page2,
      // 子页面
      children:[
        {path: 'child',component: Page2Child}
      ]
    }
  ]
})
