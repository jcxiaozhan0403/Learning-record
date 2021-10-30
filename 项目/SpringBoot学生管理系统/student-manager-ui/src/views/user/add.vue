<template>
  <el-form ref="form" :model="form" label-width="80px" style="width:50%;margin-top:20px" >
    <el-form-item label="用户名">
      <el-input v-model="form.username"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="form.password"></el-input>
    </el-form-item>
    <el-form-item label="姓名">
      <el-input v-model="form.name"></el-input>
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
      <el-button type="primary" @click="onSubmit">添加</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
import {addUser} from '@/api/user'
  export default {
    data() {
      return {
        classVisible:false,
        grade: '',
        imageUrl: '',
        form: {
          username: '',
          password: '',
          name: '',
          avatar: ''
        },
        imgData: {
          name: '',
          key: '',
          token: "3kocW5kfDuNBJshMGSrqAPy_D83zHk3x0PU3-XKY:uhZVy4HiCiH9ZdbYgcJ8DQO8TW8=:eyJzY29wZSI6InVzZXItcG9ydHJhaXQiLCJkZWFkbGluZSI6MTY2NjY2NDMzOX0="
        }
      }
    },
    methods: {
      onSubmit() {
        var username = this.form.username;
        var password = this.form.password;
        var name = this.form.name;
        var avatar = this.form .avatar;
        var data = {
          username: username,
          password: password,
          name: name,
          avatar: avatar
        }

        let _this = this;
        addUser(data).then(
          response => {
            _this.$message({
              message: response.message,
              type: 'success'
            })
            this.$router.go(0)
          }
        )

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
