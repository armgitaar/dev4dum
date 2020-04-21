import Vue from 'vue'
import axios from 'axios'

window.axios = axios
window.axios.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest'

Vue.component('welcome', require('./components/Welcome').default)
Vue.component('video-tiles', require('./components/VideoTiles').default)
Vue.component('highlight-video', require('./components/HighlightVideo').default)

new Vue({
    el: '#app'
})