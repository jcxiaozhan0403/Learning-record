import Vue from 'vue'
import Router from 'vue-router'
import Admin from '../components/Admin'
import Hello from '../components/Hello'

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/',redirect: "/admin"},
    {path: '/admin',component: Admin},
    {
      path: '/hello',
      component: Hello,
      meta:{
        requireLogin:true // 当前路由需要校验，不需要就不用写
      }
    }
  ],
})
