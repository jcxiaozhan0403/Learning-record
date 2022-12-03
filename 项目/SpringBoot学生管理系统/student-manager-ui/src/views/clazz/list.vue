<template>
  <div class="">
    <el-table
        :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
        border
        style="width: 100%">
        <el-table-column
          label="序号"
          width=""
          align="center">
            <template slot-scope="scope">
              {{ scope.row.id }}
            </template>
        </el-table-column>
        <el-table-column
          label="年级"
          width=""
          align="center">
            <template slot-scope="scope">
              {{ scope.row.grade }}
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column
          label="班级"
          width=""
          align="center">
            <template slot-scope="scope">
              {{ scope.row.clazz }}
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column
          label="班主任"
          width=""
          align="center">
            <template slot-scope="scope">
              {{ scope.row.headTeacher }}
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column
          label="限定人数"
          width=""
          align="center">
            <template slot-scope="scope">
              {{ scope.row.totalStudent }}
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column
          label="当前人数"
          width=""
          align="center">
            <template slot-scope="scope">
              {{ scope.row.currentTotalStudent }}
            </el-popover>
          </template>
        </el-table-column>

        <el-table-column
          label="操作"
          align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
    </el-table>

    <el-pagination
    @current-change="handleCurrentChange"
    :current-page="currentPage"
    :page-size="pagesize"
    background
    layout="prev, pager, next"
    :total="tableData.length">
    </el-pagination>

    <el-dialog title="编辑班级信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-input v-model="form.id" autocomplete="off" v-show="false"></el-input>
        <el-form-item label="年级" :label-width="formLabelWidth">
          <el-input v-model="form.grade" autocomplete="off" oninput="value=value.replace(/[^\u4e00-\u9fa5]/g, '')" :maxlength="6" placeholder="最大长度6个中文字符" @blur="form.grade = $event.target.value"></el-input>
        </el-form-item>
        <el-form-item label="班级" :label-width="formLabelWidth">
          <el-input v-model="form.clazz" autocomplete="off" :maxlength="6" placeholder="最大长度6个字符"></el-input>
        </el-form-item>
        <el-form-item label="班导师" :label-width="formLabelWidth">
          <el-input v-model="form.headTeacher" autocomplete="off" oninput="value=value.replace(/[^\u4e00-\u9fa5]/g, '')" :maxlength="6" placeholder="最大长度6个中文字符" @blur="form.headTeacher = $event.target.value"></el-input>
        </el-form-item>
        <el-form-item label="限定人数" :label-width="formLabelWidth">
          <el-input v-model="form.totalStudent" autocomplete="off" oninput="value=value.replace(/^\.+|[^\d.]/g,'')" placeholder="请输入数字" :maxlength="3"></el-input>
        </el-form-item>
        <el-form-item label="当前人数" :label-width="formLabelWidth">
          <el-input v-model="form.currentTotalStudent" autocomplete="off" oninput="value=value.replace(/^\.+|[^\d.]/g,'')" placeholder="请输入数字" :maxlength="3"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleUpdateClazz()">确 定</el-button>
      </div>
    </el-dialog>
  </div>


</template>

<script type="text/javascript">
import { listClazz,updateClazz,deleteClazz } from '@/api/clazz'
export default {
  data () {
    return {
      currentPage:1, //初始页
      pagesize:15,    //    每页的数据
      dialogFormVisible: false,
      formLabelWidth:'100px',
      tableData: [],
      form: {
        index: '',
        id: '',
        grade: '',
        clazz: '',
        headTeacher: '',
        totalStudent: '',
        currentTotalStudent: ''
      }
    }
  },
  created() {
    this.loadData();
  },
  methods: {
      handleCurrentChange: function(currentPage){
        this.currentPage = currentPage;
        console.log(this.currentPage)  //点击第几页
      },
      loadData(){
        var response = listClazz().then(
          response => {
            this.tableData = response.data.data
          }
        )

      },
      handleEdit(index, row) {
        this.dialogFormVisible = true;
        this.form.index = index;
        var id = row.id;
        var grade = row.grade;
        var clazz = row.clazz;
        var headTeacher = row.headTeacher
        var totalStudent = row.totalStudent
        var currentTotalStudent = row.currentTotalStudent
        this.form.id = id;
        this.form.grade = grade;
        this.form.clazz = clazz;
        this.form.headTeacher = headTeacher;
        this.form.totalStudent = totalStudent;
        this.form.currentTotalStudent = currentTotalStudent;
      },
      handleDelete(index, row) {
        var id = row.id;
        this.$confirm('此操作将永久删除该条数据, 是否继续?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
        }).then(() => {
          deleteClazz(id).then(
            response => {
              this.tableData.splice(index, 1);
              this.$message({
                  message: response.message,
                  type: 'success'
                });
            }
          )
         }).catch(() => {
           this.$message({
             type: 'info',
             message: '已取消删除'
           });
         });

      },
      handleUpdateClazz(){
        var id = this.form.id;
        var grade = this.form.grade;
        var clazz = this.form.clazz;
        var headTeacher = this.form.headTeacher
        var totalStudent = this.form.totalStudent
        var currentTotalStudent = this.form.currentTotalStudent
        if(id===null || id === ""
          || grade===null || grade === ""
          || clazz===null || clazz === ""
          || headTeacher===null || headTeacher === ""
          || totalStudent===null || totalStudent === ""
          || currentTotalStudent===null || currentTotalStudent === ""
        ){
          this.$message({
              message: '请填写完整的信息',
              type: 'warning'
            });
        }else{
          //提交修改请求
          var data = {
            id:id,
            grade:grade,
            clazz:clazz,
            headTeacher:headTeacher,
            totalStudent:totalStudent,
            currentTotalStudent:currentTotalStudent
          }
          updateClazz(data).then(
            response => {
              var i = this.form.index;
              this.tableData[i].grade = grade;
              this.tableData[i].clazz = clazz;
              this.tableData[i].headTeacher = headTeacher;
              this.tableData[i].totalStudent = totalStudent;
              this.tableData[i].currentTotalStudent = currentTotalStudent;
              this.dialogFormVisible = false;
              this.$message({
                  message: response.message,
                  type: 'success'
                });
            }
          );
        }
      },
    },
    mounted: function() {
      this.loadData()
    }
}
</script>
<style scoped>
.el-pagination {
  float: right;
  margin-top: 15px;
}
</style>
