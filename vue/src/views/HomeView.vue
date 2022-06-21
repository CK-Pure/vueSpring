<template>
  <div >
    <el-container  >
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['1', '3']"
                 style="min-height: 100vh;
                 height: 100%;
                        "
        >
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>导航一</template>

            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>导航二</template>

            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>导航三</template>

            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px;border-bottom: 1px solid #ccc;line-height: 60px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>王小虎</span>
        </el-header>

        <el-main>
          <div style="margin-bottom: 30px">
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item>用户管理</el-breadcrumb-item>

            </el-breadcrumb>
          </div>

          <div style="margin: 10px 0">
            <el-input style=" width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="username"></el-input>
<!--            <el-input style="width: 200px" placeholder="请输入邮箱" suffix-icon="el-icon-message" class="ml-5"></el-input>-->
<!--            <el-input style="width: 200px" placeholder="请输入地址" suffix-icon="el-icon-position" class="ml-5"></el-input>-->
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
          </div>

          <div style="margin: 10px 0">
            <el-button type="primary">新增 <i class="el-icon-circle-plus-outline"></i> </el-button>
            <el-button type="danger">批量删除 <i class="el-icon-circle-remove-outline"></i> </el-button>
            <el-button type="primary">导入 <i class="el-icon-bottom"></i> </el-button>
            <el-button type="primary">导出 <i class="el-icon-top"></i> </el-button>
          </div>
          <el-table :data="tableData" border stripe >
            <el-table-column prop="id" label="ID" width="70">
            </el-table-column>
            <el-table-column prop="username" label="用户名" width="140">
            </el-table-column>
            <el-table-column prop="nickname" label="昵称" width="120">
            </el-table-column>
            <el-table-column prop="address" label="地址"></el-table-column>
            <el-table-column prop="email" label="邮箱"></el-table-column>
            <el-table-column prop="phone" label="电话"></el-table-column>


            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button type="success">编辑 <i class="el-icon-edit"></i> </el-button>
                <el-button type="danger">删除 <i class="el-icon-remove-outline"></i> </el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="padding: 10px 0">
            <el-pagination
                @size-change = "handleSizeChange"
                @current-change = "handleCurrentChange"
                :current-page="pageNum"
                :page-sizes="[2, 5, 10, 20]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
            </el-pagination>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

export default {
  name: 'HomeView',
  components: {

  },
  data(){

    return{
      tableData: [],
      total:0,
      pageNum:1,
      pageSize:2,

      username:"",
    }
  },
  created() {

    this.load()
  },
  methods:{
    handleSizeChange(pageSize){

      this.pageSize = pageSize
      this.load()
    },

    handleCurrentChange(pageNum){

      this.pageNum = pageNum
      this.load()
    },
    load(){
      fetch("http://localhost:8088/user/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&username="+this.username)
          .then(res=>res.json()).then(res=>{
        console.log(res)
        this.tableData = res.data;
        this.total = res.total;
      })
    }
  },

}
</script>

<style>

</style>