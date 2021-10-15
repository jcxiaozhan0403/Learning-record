<template>
  <div class="app-container" >
    <el-form ref="form" :model="form" label-width="80px" style="width:50%;margin-top:20px" >
      <el-form-item label="账号">
        <el-input v-model="form.username" :disabled="true"/>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.name"/>
      </el-form-item>
      <el-form-item label="头像">
        <el-upload
          class="avatar-uploader"
          action="https://upload-z0.qiniup.com/"
          :data="imgData"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item label="头像地址" hidden>
        <el-input v-model="form.avatar"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
        <el-button @click="onCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {updateUserInfo} from '@/api/user'
export default {
  data() {
    return {
      imageUrl: '',
      form: {
        username: '',
        name: '',
        avatar: '',
        id: ''
      },
      imgData: {
        name: '',
        key: '',
        token: "3kocW5kfDuNBJshMGSrqAPy_D83zHk3x0PU3-XKY:uhZVy4HiCiH9ZdbYgcJ8DQO8TW8=:eyJzY29wZSI6InVzZXItcG9ydHJhaXQiLCJkZWFkbGluZSI6MTY2NjY2NDMzOX0="
      }
    }},
    methods: {
    onSubmit() {
      if(this.form.username === null || this.form.username === ""){
        this.$message.error("请填写完整的信息");
        return
      }
      var data = {
        id: this.$store.getters.id,
        username : this.form.username,
        name: this.form.name,
        avatar: this.form.avatar
      }

      updateUserInfo(data).then(
        response=>{
            this.$message.success(response.message)
            this.$router.go(0)
        }
        
      )
      console.log(data);
    },
    onCancel() {
      this.$message({
        message: 'cancel!',
        type: 'warning'
      })
    },
    handleAvatarSuccess(res, file) {
      // this.imageUrl = URL.createObjectURL(file.raw);
      this.imageUrl = "http://r0zy8iurz.hd-bkt.clouddn.com/" + res.key;
      this.form.avatar = this.imageUrl;
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg' || file.type === 'image/jpg' || file.type === 'image/png';
      const isLt2M = file.size / 1024 / 1024 < 5;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
        return false
      }
      if (!isLt2M) {
        return false
        this.$message.error('上传头像图片大小不能超过 5MB!');
      }

      // 给上传参数赋值
      this.imgData.name = file.name;
      this.imgData.key = file.name;

      return isJPG && isLt2M;
      return false
    }
  },
  mounted: function() {
    this.form.username = this.$store.getters.username;
    this.form.name = this.$store.getters.name;
    this.form.avatar = this.$store.getters.avatar;
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}

.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>