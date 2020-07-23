import Vue from 'vue'
import Router from 'vue-router'
import Index from "../components/Index";
import test from "../components/test";

Vue.use(Router)

export default new Router(
  {
    mode: 'history',
  routes: [

    {
      path: '/index',
      name: 'index',
      component: Index
    },

    {
      path: '/test',
      name: 'test',
      component: test
    }
  ]
})
