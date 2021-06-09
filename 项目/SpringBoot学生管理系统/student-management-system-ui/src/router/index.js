import Vue from 'vue'
import Router from 'vue-router'
import axios from 'axios'
import Login from "../components/Login"
import Home from "../components/Home"
import QueryPage from "../components/QueryPage"
import PersonalCenter from "../components/PersonalCenter"

Vue.use(Router)
Vue.prototype.$http=axios

export default new Router({
  routes: [
    {path: '/',redirect: '/login'},
    {path: '/login',component: Login},
    {
      path: '/home',
      component: Home,
      children:[
        {path: 'personalCenter',component: PersonalCenter},
        {path: 'queryPage',component: QueryPage}
      ]
    }
  ],
  mode: 'history'
})
