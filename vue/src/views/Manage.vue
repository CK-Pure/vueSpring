<template>
  <div >
    <el-container  >
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <Aside></Aside>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px;border-bottom: 1px solid #ccc;line-height: 60px">
          <Header></Header>
        </el-header>

        <el-main>

          <!--当前页面的子路由会在router-view里展示  -->
          <router-view></router-view>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

import Aside from "@/components/Aside";
import Header from "@/components/Header";
export default {
  name: 'HomeView',
  components: {
    Aside,
    Header
  },
  data(){

    return{

    }
  },
  created() {


  },
  methods:{

  },

}
</script>

<style>

</style>