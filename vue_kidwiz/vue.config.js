module.exports = {
  devServer: {
    proxy: {
        '/':{
            "target":'http://localhost:3000', // Spring boot의 주소 및 포트
            "pathRewrite":{'^/':''},
            "changeOrigin":true,
        }
    }
  }
}
// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })
module.exports = {
  devServer: {
      proxy: {
          '/api': {
              target: 'http://localhost:3000',
              ws: false
          }
      }
  }
}
