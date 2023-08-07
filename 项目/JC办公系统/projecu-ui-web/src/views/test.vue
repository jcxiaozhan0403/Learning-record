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
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLM0NDEwNDI21VEqLU4t8kwBikGYeYm5qSAtKbmZeUq1ADofo5tCAAAA.mEl7hl0KmywujTDbCo_WK3F3CNObQmyozUzxgoenQFtKKegSOUS3aGszkjA84CrfZ7xS_j9u_pVc3yznAw8eQg'
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
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLM0NDEwNLQ01VEqLU4t8kxRsjKHMPMSc1OBWqIyEvPSgxPzlGoBp0kbpkUAAAA.mcTfppqTivUpohM_nuAvPAMg_tR6BS_CrzFkmi06p6OB1UiVHGt15X97-WLlxq0TW132eS9hC3ax1CCHgGtv7A'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },
  }
}
</script>
