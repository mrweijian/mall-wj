<template>
  <div id="Index">
   hello index vue
  </div>

</template>

<script>
    export default {
        name: "Index",
        data(){
          return{
            index:1,
          }
        },
        mounted() {
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

    }
</script>

<style scoped>

</style>
