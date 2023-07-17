<template>
  <div class="app-container">
    <el-button type="success" icon="el-icon-plus" size="mini" @click="add" :disabled="$hasBP('bnt.sysDept.add')  === false">添 加</el-button>
    <!-- 列表 -->
    <el-table
      :data="list"
      stripe
      border
      :header-cell-style="{'text-align':'center'}"
      :cell-style="{'text-align':'center'}"
      style="width: 100%;margin-top: 10px;"
    >
      <el-table-column label="序号" width="70" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="name" label="部门名称" />
      <el-table-column prop="leader" label="负责人" />
      <el-table-column prop="phone" label="电话" />

      <el-table-column label="操作" width="120" align="center">
        <template slot-scope="scope">
          <el-button
            type="primary"
            icon="el-icon-edit"
            size="mini"
            @click="edit(scope.row)"
            :disabled="$hasBP('bnt.sysDept.update')  === false"
            title="修改"
          />
          <el-button
            type="danger"
            icon="el-icon-delete"
            size="mini"
            @click="removeDataById(scope.row.id)"
            :disabled="$hasBP('bnt.sysDept.remove')  === false"
            title="删除"
          />
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center;"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />

    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="40%">
      <el-form ref="dataForm" :model="dept" label-width="100px" size="small" style="padding-right: 40px;">
        <el-form-item label="部门名称" prop="name">
          <el-input v-model="dept.name" :disabled="dept.editing" />
        </el-form-item>
        <el-form-item label="负责人" prop="leader">
          <el-input v-model="dept.leader" :disabled="dept.editing" />
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="dept.phone" :disabled="dept.editing" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small" icon="el-icon-refresh-right">取 消</el-button>
        <el-button type="primary" icon="el-icon-check" @click="saveOrUpdate" size="small">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import api from '@/api/system/sysDept';

const defaultForm = {
  id: null,
  name: '',
  leader: '',
  phone: '',
  editing: false
};

export default {
  data() {
    return {
      list: [],
      total: 0, // 数据库中的总记录数
      page: 1, // 默认页码
      limit: 10, // 每页记录数
      dialogVisible: false, // 弹窗可见性
      dept: { ...defaultForm } // 当前编辑的部门
    };
  },

  // 生命周期函数：内存准备完毕，页面尚未渲染
  created() {
    this.fetchData();
  },

  methods: {
    // 当页码发生改变的时候
    changeSize(size) {
      this.limit = size;
      this.fetchData(1);
    },

    // 加载部门列表数据
    fetchData(page = 1) {
      this.page = page;

      api.getPageList(this.page, this.limit).then(response => {
        this.list = response.data.records;
        this.total = response.data.total;
      });
    },

    // 根据id删除部门数据
    removeDataById(id) {
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          api.removeById(id).then(() => {
            this.fetchData(this.page);
            this.$message.success('删除成功');
          });
        })
        .catch(() => {
          this.$message.info('取消删除');
        });
    },

    add() {
      this.dialogVisible = true;
      this.dept = { ...defaultForm };
    },

    edit(dept) {
      this.dialogVisible = true;
      this.dept = { ...dept };
    },

    saveOrUpdate() {
      if (this.dept.id) {
        this.updateData();
      } else {
        this.saveData();
      }
    },

    // 新增部门
    saveData() {
      this.dept.editing = true;
      api.save(this.dept).then(response => {
        this.$message.success('添加成功');
        this.dialogVisible = false;
        this.fetchData(this.page);
      });
    },

    // 更新部门信息
    updateData() {
      this.dept.editing = true;
      api.updateById(this.dept).then(response => {
        this.$message.success('修改成功');
        this.dialogVisible = false;
        this.fetchData(this.page);
      });
    }
  }
};
</script>