import Vue from 'vue'
import App from './App'
import router from './router'
import VueLazyload from 'vue-lazyload'
import 'styles/reset.css'
import 'styles/border.css'
import 'styles/iconfont.css'
import 'lib-flexible/flexible.js'
import 'vant/lib/vant-css/index.css';
import '@/assets/styles/override.css'
import store from './store'

Vue.use(VueLazyload, {
  loading: '/static/images/loading.gif'
})

import { Button, AddressList, AddressEdit } from 'vant';
Vue.use(Button).use(AddressList).use(AddressEdit)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
