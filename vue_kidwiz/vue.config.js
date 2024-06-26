const path = require('path')

module.exports = {
  configureWebpack: {
    resolve: {
      alias: {
        '@public': path.join(__dirname, 'public/')
      }
    },
  },
  outputDir: "../src/main/resource/static",
  pages: {
    index: {
      // 일반 사용자 페이지 설정
      entry: 'src/main.js',
      template: 'public/index.html',
      filename: 'index.html',
      title: 'Main Page',
    },
    admin: {
      // 관리자 페이지 설정
      entry: 'src/admin/main.js',
      template: 'public/admin.html',
      filename: 'admin.html',
      title: 'Admin Page',
    }
  },
  indexPath: "index.html",
  devServer: {
    historyApiFallback: true,
    // npm run serve 개발 진행시 포트가 다르기 때문에 프록시 설정을 해줘야 함
    proxy: {
      '/': {
        "target": 'http://localhost:3000', // Spring boot의 주소 및 포트
        pathRewrite: { '^/': '' },
        "changeOrigin": true, // CORS 에러 막는 옵션
        ws: false,
      },
      "/api": {
        target: "http://localhost:3000", // Spring boot의 주소 및 포트
        changeOrigin: true, // CORS 에러 막는 옵션
        ws: false,
        pathRewrite: { '^/api': '' }
      },
      '/admin': {
        target: 'http://localhost:3000',
        changeOrigin: true,
        ws: false
      }
    }
  }
}

