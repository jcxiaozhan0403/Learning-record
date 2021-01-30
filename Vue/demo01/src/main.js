// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'

Vue.use(ElementUI)

Vue.prototype.$http=axios

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requireLogin)){  // 判断该路由是否需要登录权限
    if (sessionStorage.getItem('token') == "001219") {  // 判断当前用户的登录信息loginInfo是否存在
      next();
    } else {
      next({
        path: '/'
      })
    }
  }else {
    next();
  }
})
