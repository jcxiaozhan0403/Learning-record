<template>
    <el-main>
      <div class="search">
        <el-select v-model="value" placeholder="请选择" style="width: 80px;margin-right: 15px">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <el-input v-model="input" placeholder="请输入内容" style="width: 110px;margin-right: 15px"></el-input>
        <el-button type="primary">查询</el-button>
      </div>
      <el-table :data="tableData">
        <el-table-column prop="date" label="日期" width="140">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="120">
        </el-table-column>
        <el-table-column prop="address" label="地址">
        </el-table-column>
      </el-table>
    </el-main>
</template>

<script>
  export default {
    data() {
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
      return {
        tableData: Array(20).fill(item),
                options: [{
          value: '学号',
          label: '学号'
        }, {
          value: '姓名',
          label: '姓名'
        }, {
          value: '班级',
          label: '班级'
        }, {
          value: '专业',
          label: '专业'
        }],
        value: '学号',
        input: ''
      }
    }
  };
</script>

<style>
div.el-table {
  height: 100%;
  overflow-y: scroll;
}

#title {
  position: absolute;
  left: 40px;
}

div.search {
  margin-bottom: 10px;
}
</style>