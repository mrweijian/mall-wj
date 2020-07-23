<template>
  <div class="hello">
    Hello VUE
  </div>
</template>

<script>
  import Qs from 'qs';
  import {Test} from '@/service/Test.js';
  export default {
    name: 'test',
    data () {
      return {
        msg: 'Welcome to Your Vue.js App'
      }
    },
    mounted() {
      this.Test = new Test();
      let data = '{"userid":"1234"}';
      let userid = 'userid';
      this.Test.TestTwo().then((res)=>{

      }).catch((err)=>{
        alert(err)
        console.log(err)
      });
    },
    methods:{
      toDetail(item) {
        this.$router.push({
          path: JSON.parse(item.ActionPara).Url1,
          query: {
            workId: item.WorkID,
            taskName: item.TaskName,
            id: item.MainParaIn.Value
          }
        });
      },
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
</style>
