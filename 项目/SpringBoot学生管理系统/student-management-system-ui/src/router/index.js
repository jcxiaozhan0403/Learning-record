import Vue from 'vue'
import Router from 'vue-router'
import axios from 'axios'
import Login from "../components/Login"
import Demo from "../components/Demo"

Vue.use(Router)
Vue.prototype.$http=axios

export default new Router({
  routes: [
    {path: '/',component: Login},
    {path: '/login',component: Login},
    {path: '/demo',component: Demo}
  ]
})
