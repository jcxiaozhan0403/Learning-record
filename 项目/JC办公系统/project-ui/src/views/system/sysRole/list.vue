<template>
  <div class="app-container">
    <!--查询表单-->
    <div class="search-div">
        <el-form label-width="70px" size="small">
            <el-row>
                <el-col :span="24">
                    <el-form-item label="角色名称">
                    <el-input style="width: 100%" v-model="searchObj.roleName" placeholder="角色名称"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
                <el-row style="display:flex">
                <el-button type="success" icon="el-icon-plus" size="mini" @click="add" :disabled="$hasBP('bnt.sysRole.add')  === false">添加</el-button>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="fetchData()">搜索</el-button>
                <el-button type="danger" icon="el-icon-delete" size="mini"  @click="batchRemove()">删除</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetData">重置</el-button>
            </el-row>
        </el-form>
    </div>

    <!-- 表格 -->
    <!-- :data="list" 使用list渲染表格 -->
    <el-table
      :data="list"
      stripe
      border
      :header-cell-style="{'text-align':'center'}"
      :cell-style="{'text-align':'center'}"
      style="width: 100%;margin-top: 10px;"
      @selection-change="handleSelectionChange">

        <el-table-column type="selection"/>

        <!-- 根据page和limit两个值,在前端计算生成新的id值进行渲染,避免后台传入的id值不连续的问题 -->
        <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
            {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
        </el-table-column>

        <el-table-column prop="roleName" label="角色名称" />
        <el-table-column prop="roleCode" label="角色编码" />
        <el-table-column prop="createTime" label="创建时间" width="160"/>
        <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
            <el-button type="primary" icon="el-icon-edit" size="mini" @click="edit(scope.row.id)" title="修改"/>
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="removeDataById(scope.row.id)" title="删除"/>
            <el-button type="warning" icon="el-icon-baseball" size="mini" @click="showAssignAuth(scope.row)" title="分配权限"/>
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

    <!-- 添加/修改 弹出层 -->
    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="40%" >
        <el-form ref="dataForm" :model="sysRole" label-width="150px" size="small" style="padding-right: 40px;">
            <el-form-item label="角色名称">
                <el-input v-model="sysRole.roleName"/>
            </el-form-item>
            <el-form-item label="角色编码">
                <el-input v-model="sysRole.roleCode"/>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small" icon="el-icon-refresh-right">取 消</el-button>
        <el-button type="primary" icon="el-icon-check" @click="saveOrUpdate()" size="small">确 定</el-button>
        </span>
    </el-dialog>
  </div>
</template>
<script>
import api from '@/api/system/sysRole'
export default {
    // 定义数据模型
    data() {
        return {
            list: [], // 列表
            total: 0, // 总记录数
            page: 1, // 页码
            limit: 10, // 每页记录数
            searchObj: {}, // 查询条件
            multipleSelection: [],// 批量删除选中的记录列表

            dialogVisible: false,
            sysRole: {},
            saveBtnDisabled: false
        }
    },
    // 页面渲染成功后获取数据
    created() {
        this.fetchData()
    },
    // 定义方法
    methods: {
        // 当页码发生改变的时候
        changeSize(size) {
            this.limit = size
            this.fetchData(1)
        },
        fetchData(current=1) {
            this.page = current;
            // 调用api
            api.getPageList(this.page, this.limit, this.searchObj).then(response => {
              this.list = response.data.records;
              this.total = response.data.records.length;
            })
        },
        // 重置表单
        resetData() {
            console.log('重置查询表单');
            this.searchObj = {};
            this.fetchData();
        },
        // 根据id删除数据
        removeDataById(id) {
            // debugger
            this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => { // promise
                // 点击确定，远程调用ajax
                return api.removeById(id).then((response) => {
                    this.fetchData(this.page);
                    this.$message.success(response.message || '删除成功');
                })
            })
        },
        add(){
            this.dialogVisible = true
        },
        saveOrUpdate() {
            // 防止表单重复提交
            this.saveBtnDisabled = true;
            if (!this.sysRole.id) {
                this.saveData()
            } else {
                this.updateData()
            }
        },
        // 新增
        saveData() {
            api.save(this.sysRole).then(response => {
                this.$message.success(response.message || '操作成功')
                this.dialogVisible = false
                this.fetchData(this.page)
            })
        },
        edit(id) {
            this.dialogVisible = true
            this.fetchDataById(id)
        },

        fetchDataById(id) {
            api.getById(id).then(response => {
                this.sysRole = response.data
            })
        },

        updateData() {
            api.updateById(this.sysRole).then(response => {
                this.$message.success(response.message || '操作成功')
                this.dialogVisible = false
                this.fetchData(this.page)
            })
        },
        showAssignAuth(row) {
            this.$router.push('/system/assignAuth?id='+row.id+'&roleName='+row.roleName);
        },
        // 当多选选项发生变化的时候调用
        handleSelectionChange(selection) {
            this.multipleSelection = selection
        },
        // 批量删除
        batchRemove() {
            if (this.multipleSelection.length === 0) {
                this.$message.warning('请选择要删除的记录！')
                return
            }
            this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                // 点击确定，远程调用ajax
                // 遍历selection，将id取出放入id列表
                var idList = []
                this.multipleSelection.forEach(item => {
                    idList.push(item.id)
                })
                // 调用api
                return api.batchRemove(idList)
            }).then((response) => {
                this.fetchData()
                this.$message.success(response.message)
            })
        }
    }
}
</script>
