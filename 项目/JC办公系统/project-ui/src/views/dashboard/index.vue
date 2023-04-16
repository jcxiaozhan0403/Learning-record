<template>
  <div class="dashboard-container">
    <div class="mytitle">JC办公管理系统</div>
    <!-- <div class="dashboard-text">name: {{ name }}</div> -->
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
// .dashboard {
//   &-container {
//     margin: 30px;
//   }
//   &-text {
//     font-size: 30px;
//     line-height: 46px;
//   }
// }

.mytitle{
  padding: 20px 40px;
  margin: 0 auto;
  text-align: center;
  line-height: 300px;
  width: 400px;
  height: 300px;
  margin-top: 200px;
  font-size: 40px;
  color: #999;
}
</style>
