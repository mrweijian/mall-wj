const path = require('path');
const webpack = require('webpack');
let url = '';
function resolve(dir) {
  return path.join(__dirname, '.', dir);
}

module.exports = {
  // 修改的配置
  baseUrl: process.env.NODE_ENV==='production'?'./':'./',

  // publicPath:
  devServer: {
    proxy: {
      '/api': {

        target: 'http://192.168.5.81:8089',
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    },
  },
  runtimeCompiler: true,


};
