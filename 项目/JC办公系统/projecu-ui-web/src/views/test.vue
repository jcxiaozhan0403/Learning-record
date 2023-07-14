<template>
  <div>
    <div>账号切换</div>
    <button @click="admin()" type="default" size="mini">Admin</button>
    <button @click="lisi()" type="default" size="mini">李四</button>
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
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLOwNDQ2NjS11FEqLU4t8kwBikGYeYm5qSAtKbmZeUq1AIRCcuVCAAAA.Yx30MFCe5biGlq4JpNVZN2f2Zn1jRnyZjro7VmMn7B7XHYZzJYaU1fwvjB-IyI8CI0V3gMYM6fbueVye1PxNOA'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    lisi() {
      window.localStorage.setItem('token', '');
      let token = 'OiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLOwMDM3MrS00FEqLU4t8kxRsjKBMPMSc1OBWnwygzOVagFVzd-cQQAAAA.O7HFhZ2h4q1ZtRzxWoK9HEqqtVxPRynHQ4gmb1mq1NWt4T39l5iCHffNe32tKAIt6kSTNi1JxZKYFIM6d6ecOg'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    zhangsan() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLOwNDQ2tTA20FEqLU4t8kxRsjKHMPMSc1OBWqIyEvPSgxPzlGoBI4HWR0UAAAA.8YvvNSexpWp9HUob9DDeaRdO-QfwMj5nS1HYB8dcAEmEE953vb7AmJAJVZtQ9WV86a_LT0QjdmoJa93nSHrJ-Q'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },
  }
}
</script>
