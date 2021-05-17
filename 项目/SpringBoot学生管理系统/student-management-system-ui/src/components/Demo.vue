<template>
<div>
    <form>
        <input type="text" name="id" v-model="text">
        <input type="password" name="pwd" v-model="pwd">
        <button type="submit" @click="handleSubmit">提交</button>
    </form>
</div>
</template>

<script>
export default {
    data(){
        return {
            text: "",
            pwd: ""
        }
    },
    methods: {
       handleSubmit(e) {
            e.preventDefault();
            let _this = this;
            this.$http.post("http://localhost:8989/" + this.text).then((res)=>{
                console.log(res.data);
            });
       }
    }
};
</script>

<style>

</style>
