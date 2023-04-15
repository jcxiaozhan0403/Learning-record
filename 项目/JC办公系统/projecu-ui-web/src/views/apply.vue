<template>
  <div>
    <van-nav-bar
      title="发起审批"
      left-text="返回"
      left-arrow
      @click-left="() => $router.back()"
    />
    <div style="margin: 10px 10px 0 0;border: 0px solid red;">
    <form-create
      :rule="rule"
      :option="option"
      @submit="onSubmit"
    ></form-create>
    </div>
  </div>
</template>

<script>
import api from "@/api/process";

export default {
  name: "process",

  data() {
    return {
      processTemplateprocessTemplate: null,
      rule: [],
      option: {}
    };
  },

  created() {
    //获取到传入的模板id，查询模板信息
    let processTemplateId = this.$route.params.processTemplateId;
    this.fetchData(processTemplateId);
  },

  methods: {
    fetchData(processTemplateId) {
      api.getProcessTemplate(processTemplateId).then(response => {
        console.log(response.data);
        this.processTemplate = response.data;

        this.rule = JSON.parse(this.processTemplate.formProps);
        this.option = JSON.parse(this.processTemplate.formOptions);
      });
    },

    //提交表单信息
    onSubmit(formData) {
      console.log(formData)
      let formShowData = {};
      this.rule.forEach(item => {
        for (let key in formData) {
          if (key === item.field) {
            console.log(item.title, formData[key]);
            formShowData[item.title] = formData[key];
          }
        }
      });
      let DATA = {
        formData: formData,
        formShowData: formShowData
      };
      console.log(DATA);
      let processFormVo = {
        "processTemplateId": this.processTemplate.id,
        "processTypeId": this.processTemplate.processTypeId,
        "formValues": JSON.stringify(DATA)
      };
      console.log(processFormVo)
      //调用接口开启流程
      api.startUp(processFormVo).then(response => {
        //跳转到审批列表
        this.$router.push({ path: "/list/2" });
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.el-form {
  .el-form-item {
    /deep/ .el-form-item__label {
      font-size: 18px;
      font-weight: 800;
      color: blue;
    }
  }
}
</style>
