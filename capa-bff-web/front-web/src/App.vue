
<template>
  <div class="box-shadow">
    <el-row>
      <template v-for="(item,index) in app.resultList">
        <el-button @click="showRequest(item.info)">{{item.name}}</el-button>
      </template>
    </el-row>
    <el-row>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          <div class="input-box" style="display: block;width: 100%;height:640px;position: relative">
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
      <el-col :span="10" style="margin-top: -10px;">
        <div class="box" style="height: 640px;background: #eee;padding:20px;">
          <pre>{{app.output}}</pre>
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
        output : '响应请求结果',
        resultList : []
      }
    }
  },
  created() {
    var simple = '{' + '\n'
        + '        "20725.gscontentcenterservice":  [' + '\n'
        + '                "getaccounttype":(' + '\n'
        + '                    request:  {' + '\n'
        + '                        "uid":  "wwwwww"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "ResponseStatus.Ack":  "user.forawegag"' + '\n'
        + '                }' + '\n'
        + '  )' + '\n'
        + '        ]' + '\n'
        + '}'; + '\n'
    var simple2 = '{' + '\n'
        + '        "20725.gscontentcenterservice":  [' + '\n'
        + '                "getaccounttype":(' + '\n'
        + '                    request:  {' + '\n'
        + '                        "uid":  "wwwwww"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "accountTypeName":  "user.code"' + '\n'
        + '                }' + '\n'
        + '  )' + '\n'
        + '        ],' + '\n'
        + '        "21754.ibumarketingemailgatewayservice":  [' + '\n'
        + '                "checkhealth":(' + '\n'
        + '                    request:  {},' + '\n'
        + '                response:  {' + '\n'
        + '                        "ResponseStatus.Ack":  "user.id"' + '\n'
        + '                }' + '\n'
        + '  )' + '\n'
        + '        ]' + '\n'
        + '}'; + '\n'
    var simple3 = '{' + '\n'
        + '        "20725.gscontentcenterservice":  [' + '\n'
        + '                "getaccounttype":(' + '\n'
        + '                    request:  {' + '\n'
        + '                        "uid":  "${user.id}"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "ResponseStatus.Ack":  "user.code"' + '\n'
        + '                }' + '\n'
        + '  )' + '\n'
        + '        ],' + '\n'
        + '        "21754.ibumarketingemailgatewayservice":  [' + '\n'
        + '                "checkhealth":(' + '\n'
        + '                    request:  {},' + '\n'
        + '                response:  {' + '\n'
        + '                        "ResponseStatus.Ack":  "user.id"' + '\n'
        + '                }' + '\n'
        + '  )' + '\n'
        + '        ]' + '\n'
        + '}'; + '\n'
    var simple4 = '{' + '\n'
        + '    "20725.gscontentcenterservice": [' + '\n'
        + '        "getkolapplydetail":(' + '\n'
        + '            request: {' + '\n'
        + '                "kolApplyNo" : "1",' + '\n'
        + '                "head" : {' + '\n'
        + '                    "extension" : [{' + '\n'
        + '                        "name" : "passKolPermission",' + '\n'
        + '                        "value" : "true"' + '\n'
        + '                    }]' + '\n'
        + '                }' + '\n'
        + '            },' + '\n'
        + '            response: {' + '\n'
        + '                "kolOrderDetail.demandType" : "kol.id",' + '\n'
        + '                "kolOrderDetail.orderStatus" : "kol.statusName",' + '\n'
        + '                "personalInformationDetail.placeOfDeparture" : "kol.placeOfDeparture",' + '\n'
        + '                "personalInformationDetail.travelNumber" : "kol.travelNumber"' + '\n'
        + '            }' + '\n'
        + '        )' + '\n'
        + '    ],' + '\n'
        + '    "22812.tieyouflightjupiterservice":[' + '\n'
        + '            "commonFlightPolicyDetailSearch":(' + '\n'
        + '                 request: {' + '\n'
        + '                        "context": {' + '\n'
        + '                              "vendor":  "test",' + '\n'
        + '                              "timestamp":   1634999443509,' + '\n'
        + '                              "sign":"82c6271609524bb1f20f0ad9a530bb45",' + '\n'
        + '                              "source":  "vendorPlatform"' + '\n'
        + '                        },' + '\n'
        + '                        "data":{' + '\n'
        + '                              "startIndex":  1,' + '\n'
        + '                              "pageSize":10,' + '\n'
        + '                              "policyId":"",' + '\n'
        + '                              "searchCondition": {' + '\n'
        + '                                    "airline": "",' + '\n'
        + '                                    "state":   ""' + '\n'
        + '                              }' + '\n'
        + '                        }' + '\n'
        + '            },' + '\n'
        + '            response:  {' + '\n'
        + '                  "resultCode":  "user.code"' + '\n'
        + '            }' + '\n'
        + '        )' + '\n'
        + '      ]' + '\n'
        + '}' + '\n'
    this.app.resultList.push({
      name : '简单单个请求',
      info : simple
    });
    this.app.resultList.push({
      name : '简单多个请求',
      info : simple2
    });
    this.app.resultList.push({
      name : '相互依赖请求',
      info : simple3
    });
    this.app.resultList.push({
      name : '非常复杂请求',
      info : simple4
    });

  },
  methods : {
    jsonStr() {
      this.app.input = JSON.parse(this.app.input);
    },
    showRequest(info) {
      this.app.input = info;
    },
    async requestHttp() {
      try {
        let data = (
            await axios.post(`/api/capabff`, this.app.input, {
              headers: { 'Content-Type' : 'text/plain' }
            })
        );
        this.app.output = JSON.stringify(data.data, 0, "\t");
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
