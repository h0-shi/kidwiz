module.exports = {
  outputDir: "../src/main/resource/static",
  indexPath: "../static/index.html",
  devServer: {
    historyApiFallback: true,
    proxy: {
        '/':{
            "target":'http://localhost:3000', // Spring boot의 주소 및 포트
            "pathRewrite":{'^/':''},
            "changeOrigin":true,
            ws: false
        }
    }
  }
}
