import Vue from 'vue'
import Router from 'vue-router'
import axios from 'axios'
import Login from "../components/Login"
import Home from "../components/Home"

Vue.use(Router)
Vue.prototype.$http=axios

export default new Router({
  routes: [
    {path: '/',component: Login},
    {path: '/login',component: Login},
    {path: '/home',component: Home}
  ]
})
