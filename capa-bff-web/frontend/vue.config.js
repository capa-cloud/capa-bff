module.exports = (options = {}) => ({
  devServer: {
    // host: env=='uat'?'test.ctrip.uat.qa.nt.ctripcorp.com':'test.ctrip.fws.qa.nt.ctripcorp.com',
    proxy: {
      '/api/': {
        targerrrt: 'http://www.baidu.com',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    },
  },
});
