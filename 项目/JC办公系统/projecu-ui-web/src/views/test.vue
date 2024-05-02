<template>
  <div>
    <div>账号切换</div>
    <button @click="admin()" type="default" size="mini">Admin</button>
    <button @click="wangwu()" type="default" size="mini">王五财务经理</button>
    <button @click="lisi()" type="default" size="mini">李四人事经理</button>
    <button @click="zhangsan()" type="default" size="mini">张三研发经理</button>
    <button @click="zhaoliu()" type="default" size="mini">赵六员工</button>
    <div>当前token：{{ token }}</div>
  </div>
</template>

<script>
export default {
  name: "Test",

  data() {
    return {
      token: '',
      authority: ''
    };
  },

  created(){
    this.token = window.localStorage.getItem('token');
  },

  methods: {
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
  }
}
</script>
