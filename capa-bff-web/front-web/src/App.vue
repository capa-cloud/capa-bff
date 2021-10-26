
<template>
  <div class="box-shadow">
    <el-row>
      <el-col :span="12">
        <el-row>
          <template v-for="(item,index) in app.resultList">
            <el-button @click="showRequest(item.info)">{{item.name}}</el-button>
          </template>
        </el-row>
        <div class="grid-content bg-purple">
          <div class="input-box" style="display: block;width: 100%;height:740px;position: relative">
            <el-input
                type="textarea"
                :rows="36"
                placeholder="请输入请求内容"
                v-model="app.input"
            >
            </el-input>
          </div>
        </div>
      </el-col>
      <el-col :span="2" style="text-align: center">
        <el-button style="margin-top: 100px;" type="primary" size="medium" @click="requestHttp">请求</el-button>
      </el-col>
      <el-col :span="10" style="margin-top: 70px;">
        <div class="box" style="height: 740px;background: #eee;padding:20px;">
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
        + '                        "ResponseStatus.Ack":  "user.jdjdjdjdj"' + '\n'
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
    var simple5 = '{' + '\n'
        + '        "20392.imageService":  [' + '\n'
        + '                "getImageInfo":(' + '\n'
        + '                    request:  {' + '\n'
        + '                        "imageId":  "${image.id}"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "imageInfo.imageId":  "${image.id}"' + '\n'
        + '                }' + '\n'
        + '  )' + '\n'
        + '        ]' + '\n'
        + '}' + '\n';
    var simple6 = '{' + '\n'
        + '        "20173.userService":  [' + '\n'
        + '            "getUserInfo":(' + '\n'
        + '                    request:  {' + '\n'
        + '                        "imageId":  "${d.field1}"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "userInfo.name":  "b.field"' + '\n'
        + '                }' + '\n'
        + '  			)' + '\n'
        + '        ],' + '\n'
        + '        "22423.accountService":  [' + '\n'
        + '            "getUserInfo":(' + '\n'
        + '                    request:  {' + '\n'
        + '                        "accountId":  "${b.field}"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "accountInfo.id":  "c.field"' + '\n'
        + '                }' + '\n'
        + '			)' + '\n'
        + '        ],' + '\n'
        + '        "11933.articleService":  [' + '\n'
        + '            "getArticleInfo":(' + '\n'
        + '                request:  {' + '\n'
        + '                        "articleId":  "${c.field}"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "articleInfo.id":  "d.field1",' + '\n'
        + '                        "articleInfo.name":  "d.field2"' + '\n'
        + '                }' + '\n'
        + '			)' + '\n'
        + '        ],' + '\n'
        + '        "83920.liveService":  [' + '\n'
        + '            "getLiveInfo":(' + '\n'
        + '                request:  {' + '\n'
        + '                        "liveInfo.id":  "${d.field1}",' + '\n'
        + '                        "liveInfo.liveUserId":  "${d.field2}"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "liveResult.liveId" : "e.field" ' + '\n'
        + '                }' + '\n'
        + '			)' + '\n'
        + '        ],' + '\n'
        + '        "18394.dintctServcide" : [' + '\n'
        + '	        "getOtherInfo":(' + '\n'
        + '                request:  {' + '\n'
        + '                        "other.id":  "${e.field}"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "otherInfo.result" : "f.field" ' + '\n'
        + '                }' + '\n'
        + '			)' + '\n'
        + '        ]' + '\n'
        + '}' + '\n';
    var simple7 = '{' + '\n'
        + '        "20725.gscontentcenterservice":  [' + '\n'
        + '            "getUserInfo":(' + '\n'
        + '                    request:  {' + '\n'
        + '                        "uid":  "wwwwww"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "userInfo.identityTypeName":  "#{base64}userInfo.identityTypeName"' + '\n'
        + '                }' + '\n'
        + '			)' + '\n'
        + '        ]' + '\n'
        + '}' + '\n'
    var simple8 = '{' + '\n'
        + '        "20725.gscontentcenterservice":  [' + '\n'
        + '            "getUserInfo":(' + '\n'
        + '                    request:  {' + '\n'
        + '                        "uid":  "wwwwww"' + '\n'
        + '                },' + '\n'
        + '                response:  {' + '\n'
        + '                        "userInfo.userId":  "#{toString}userInfo.userId"' + '\n'
        + '                }' + '\n'
        + '			)' + '\n'
        + '        ]' + '\n'
        + '}' + '\n';
    var simple9 = '{ ' + '\n'
        + '        "20725.gscontentcenterservice":  [ ' + '\n'
        + '            "getUserInfo":( ' + '\n'
        + '                    request:  { ' + '\n'
        + '                        "uid":  "wwwwww" ' + '\n'
        + '                }, ' + '\n'
        + '                response:  { ' + '\n'
        + '                        "*" : "resultInfo" ' + '\n'
        + '                } ' + '\n'
        + '	    ) ' + '\n'
        + '        ] ' + '\n'
        + '} ' + '\n'
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
    this.app.resultList.push({
      name : '简单循环依赖请求检查',
      info : simple5
    });
    this.app.resultList.push({
      name : '复杂循环依赖请求检查',
      info : simple6
    });
    this.app.resultList.push({
      name : 'function(#encode)返回值',
      info : simple7
    });
    this.app.resultList.push({
      name : 'function(#toString)返回值',
      info : simple8
    });
    this.app.resultList.push({
      name : '返回全部数据(*)',
      info : simple9
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
