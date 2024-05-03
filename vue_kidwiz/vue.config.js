module.exports = {
  devServer: {
    proxy: {
        '/':{
            "target":'http://localhost:3000', // Spring boot의 주소 및 포트
            "ws": true, //websocket 프록시 활성화 - 이문희
            "pathRewrite":{'^/':''},
            "changeOrigin":true,
        }
    }
  }
}
