<template>
<div>


  <el-dropdown>
    <i class="el-icon-setting" style="margin-right: 15px"></i>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item>个人信息</el-dropdown-item>
      <el-dropdown-item>
        <router-link to="/login" style="text-decoration: none">退出</router-link>
      </el-dropdown-item>

    </el-dropdown-menu>
  </el-dropdown>
  <span>王小虎</span>
</div>
</template>

<script>
export default {
  name: "Header",
  props:{

  }
}
</script>

<style scoped>

</style>