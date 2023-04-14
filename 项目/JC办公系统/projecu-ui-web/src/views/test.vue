<template>
  <div>
    <div>账号切换</div>
    <button @click="admin()" type="default" size="mini">Admin</button>
    <button @click="wangjingli()" type="default" size="mini">王经理</button>
    <button @click="zhangsan()" type="default" size="mini">张三人事</button>
    <div>当前token：{{ token }}</div>
  </div>
</template>

<script>
export default {
  name: "Test",

  data() {
    return {
      token: ''
    };
  },

  created(){
    this.token = window.localStorage.getItem('token')
  },

  methods: {
    admin() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLMwsjSxMDG10FEqLU4t8kwBikGYeYm5qSAtKbmZeUq1ADq5KplCAAAA.OQ6eITFWfjCtXmA2Ljb6coCu3Za_Yk_ECNMzY34kMmm-TrwfPMU6lbQxrS7NkzKkHDzwbgd6Xk7sloLMImFP2A'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    wangjingli() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLMwsjSxMDMx0VEqLU4t8kxRsjKCMPMSc1OBWsIT89K9MvPSfTKVagHFFo2zRwAAAA.AKvaV1FVs5KnR5yGRQcFNtXbSxBPo0WvQtH-kJkeWnWhHqmWcOmoz4ORRzj0yAm5IEo-PTIYIMYp-imf9SJUTQ'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    zhangsan() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLMwsjSxMDUx01EqLU4t8kxRsjKHMPMSc1OBWqIyEvPSgxPzlGoBl1BhAkUAAAA.ZD5AvYsooadKtJ1eLhLQ55wkRGvkJmwo1g5iWso61x198d9Psx3mtXtS8PXIRPJzFYwtylOdmZMG01o47zS-TA'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },
  }
}
</script>
