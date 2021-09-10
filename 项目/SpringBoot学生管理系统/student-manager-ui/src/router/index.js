import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'home' }
    }]
  },

  {
    path: '/student',
    component: Layout,
    redirect: '/student/table',
    name: 'student',
    meta: { title: '学生信息管理', icon: 'student' },
    children: [
      {
        path: 'list',
        name: 'studentList',
        component: () => import('@/views/student/list'),
        meta: { title: '查看学生信息', icon: 'table' }
      },
      {
        path: 'add',
        name: 'studentAdd',
        component: () => import('@/views/student/add'),
        meta: { title: '添加学生信息', icon: 'add' }
      },
      {
        path: 'search',
        name: 'studentSearch',
        component: () => import('@/views/student/search'),
        meta: { title: '查询学生信息', icon: 'search' }
      }
    ]
  },

  {
    path: '/teacher',
    component: Layout,
    redirect: '/teacher/manage',
    name: 'teacher',
    meta: { title: '教师信息管理', icon: 'teacher' },
    children: [
      {
        path: 'list',
        name: 'teacherList',
        component: () => import('@/views/teacher/list'),
        meta: { title: '查看教师信息', icon: 'table' }
      },
      {
        path: 'add',
        name: 'teacherAdd',
        component: () => import('@/views/teacher/add'),
        meta: { title: '添加教师信息', icon: 'add' }
      },
      {
        path: 'search',
        name: 'teacherSearch',
        component: () => import('@/views/teacher/search'),
        meta: { title: '查询教师信息', icon: 'search' }
      }
    ]
  },
  {
    path: '/clazz',
    component: Layout,
    redirect: '/class/table2',
    name: 'clazz',
    meta: { title: '班级信息管理', icon: 'clazz' },
    children: [
      {
        path: 'list',
        name: 'clazzList',
        component: () => import('@/views/clazz/list'),
        meta: { title: '查看班级信息', icon: 'table' }
      },
      {
        path: 'add',
        name: 'clazzAdd',
        component: () => import('@/views/clazz/add'),
        meta: { title: '添加班级信息', icon: 'add' }
      }
    ]
  },
  {
      path: '/form',
      component: Layout,
      redirect: '/user/',
      name: 'user',
      meta: { title: '个人中心', icon: 'user' },
      children: [
        {
          path: 'index',
          name: 'userInfo',
          component: () => import('@/views/user/update'),
          meta: { title: '修改个人信息', icon: 'setting' }
        },
        {
          path: 'add',
          name: 'UpdatePassword',
          component: () => import('@/views/user/updatePassword'),
          meta: { title: '修改密码', icon: 'setting' }
        }
      ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
