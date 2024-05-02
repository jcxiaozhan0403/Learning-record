<template>
  <div id="app">
    <el-button type="primary" @click="clear()" size="small">清除token</el-button>
    <el-button type="primary" @click="admin()" size="small">Admin</el-button>
    <el-button type="primary" @click="wangwu()" size="small">王五财务经理</el-button>
    <el-button type="primary" @click="lisi()" size="small">李四人事经理</el-button>
    <el-button type="primary" @click="zhangsan()" size="small">张三研发经理</el-button>
    <el-button type="primary" @click="zhaoliu()" size="small">赵六员工</el-button>
    <router-view />

    <el-dialog title="绑定手机" :visible.sync="dialogVisible" width="80%" >
      <el-form ref="dataForm" :model="bindPhoneVo" size="small">
        <h4>绑定你的手机号，建立JC办公系统关联关系</h4>
        <el-form-item label="手机号码">
          <el-input v-model="bindPhoneVo.phone"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" icon="el-icon-check" @click="saveBind()" size="small">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import userInfoApi from '@/api/userInfo'
export default {
  data() {
    return {
      show: true,
      dialogVisible: false,
      bindPhoneVo: {
        openId: '',
        phone: ''
      }
    };
  },

  created() {
    // 处理微信授权登录
    // this.wechatLogin();
  },

  methods: {
    clear(){
      window.localStorage.setItem('token','')
      this.bindPhoneVo = {}
    },
    admin() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDewNDM0Nzcz0lEqLU4t8kwBikGYeYm5qSAtKbmZeUq1ABR5xLRCAAAA.ta7yc8J6kUufFxtOaW2Au5o5u8LILocQ0k6DwFrMFqmldefCb8iwFNSsYxkEEeQeOvOQu3DtOgPlN7Mwswykpw'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    lisi() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDewNDMyNbQ00VEqLU4t8kxRsoIy8xJzU4FafDKDM5VqAVE97BFBAAAA.tDaSLWSBIftPFpA4ZtBYF4DI7RCoLIRmVD3pn9096KHU4LLQXIRERI9sk4AYou30euvtXWj17ouk7FOTrNCMaw'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    zhangsan() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDewNDM0tzAz1lEqLU4t8kxRsjKHMPMSc1OBWqIyEvPSgxPzlGoB9OjiiEUAAAA.PsnYt8CqjkuMZLbZqd0NM2D9HkMIpz1t0WzWgC1nDQzqsDM_sPEuQUA4OGrRz5Nb5fBj6NW5NbXduaNrrnhtEA'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    wangwu() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDc0NjYxMjO11FEqLU4t8kxRsjKGMPMSc1OBWsIT89LDS5VqAQLl7-tDAAAA.WJKEf0Zp9TWuX59Ogao0rmfh5VSNZu0Wss_V4I_OtOPYeCneDTR3xaWnLnjor0Mrw1cSw_RcXg1-CIrs6RJMeQ'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    zhaoliu() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDc0NjYxMjcy11EqLU4t8kxRsjKCMPMSc1OBWqIyEvN9MkuVagGYb0OWRAAAAA.PzXRMOXMXG-6Yg_0f9sY4urTyJFOxpRXE5YtU8aJl6ZOTZttm-4lNFHmnTbob1dj7FuDhC6zen2K-6z8aIiqQA'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },
    wechatLogin() {
      // 处理微信授权登录
      let token = this.getQueryString('token') || '';
      let openId = this.getQueryString('openId') || '';
      // token === '' && openId != '' 只要这种情况，未绑定账号
      if(token === '' && openId != '') {
        // 绑定账号
        this.bindPhoneVo.openId = openId
        this.dialogVisible = true
      } else {
        // 如果绑定了，授权登录直接返回token
        if(token !== '') {
          window.localStorage.setItem('token', token);
        }
        token = window.localStorage.getItem('token') || '';
        if (token == '') {
          let url = window.location.href.replace('#', 'jc_oa')
          // window.location = 'http://oa.jcxiaozhan.top:8200/admin/wechat/authorize?returnUrl=' + url
          window.location = 'http://java.jcxiaozhan.top:8200/admin/wechat/authorize?returnUrl=' + url
        }
      }
    },

    saveBind() {
      if(this.bindPhoneVo.phone.length != 11) {
        alert('手机号码格式不正确')
        return
      }
      userInfoApi.bindPhone(this.bindPhoneVo).then(response => {
        window.localStorage.setItem('token', response.data);
        this.dialogVisible = false
        // window.location = 'http://oa.jcxiaozhan.top:9090'
        window.location = 'http://vue.jcxiaozhan.top:9090'
      })
    },

    getQueryString (paramName) {
      if(window.location.href.indexOf('?') == -1) return '';

      let searchString = window.location.href.split('?')[1];
      let i, val, params = searchString.split("&");

      for (i=0;i<params.length;i++) {
        val = params[i].split("=");
        if (val[0] == paramName) {
          return val[1];
        }
      }
      return '';
    }
  }
};
</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
