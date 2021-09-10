<template>
  <div class="dashboard-container">
    <div class="text">学生信息管理系统</div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}

.text {
  width: 100%;
    height: 865px;
    text-align: center;
    padding-top: 400px;
    font-size: 30px;
    color: #808080;
}
</style>
