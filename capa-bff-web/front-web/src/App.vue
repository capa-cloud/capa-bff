
<template>
  <div class="box-shadow">
    <el-row>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          <div class="input-box" style="display: block;width: 100%;position: relative">
            <el-input
                type="textarea"
                :rows="30"
                placeholder="请输入请求内容"
                v-model="app.input"
            >
            </el-input>
            <!--            <el-button style="position: absolute;right:0" @click="jsonStr">JSON格式化</el-button>-->
          </div>
        </div>
      </el-col>
      <el-col :span="2" style="text-align: center">
        <el-button style="margin-top: 100px;" type="primary" size="medium" @click="requestHttp">请求</el-button>
      </el-col>
      <el-col :span="10">
        <div class="grid-content bg-purple-light">
          <el-input
              type="textarea"
              :rows="30"
              placeholder="响应结果"
              :disabled="true"
              v-model="app.output"
              clearable>
          </el-input>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>

import Vue from 'vue';
import Element from 'element-ui';
import axios from "axios";

Vue.use(Element, {size: 'small', zIndex: 3000});

export default {
  name: 'app',
  data() {
    return {
      app : {
        input : null,
        output : null
      }
    }
  },
  methods : {
    jsonStr() {
      this.app.input = JSON.parse(this.app.input);
    },
    async requestHttp() {
      try {
        let data = (
            await axios.post(`/api/capabff`, this.app.input, {
              headers: { 'Content-Type' : 'text/plain' }
            })
        );
        this.app.output = JSON.stringify(data.data);
        console.log(data.data);
      } catch (e) {
        this.$alert(e.message, "提示");
      } finally {
      }
    }
  }
}

</script>

<style>
.box-shadow {
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
  padding: 20px;
  margin:20px;
  margin-top: 30px;
}
</style>
