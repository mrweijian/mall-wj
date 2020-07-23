import axios from 'axios'

// let baseUrl = window.location.pathname;
let baseUrl = "http://192.168.5.81:8089"

export const service = axios.create({
  baseURL: baseUrl, // api 的 base_url
  timeout: 600000, // request timeout
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded'
  },
  responseType: 'text'
});
service.defaults.retry = 4;
service.defaults.retryDelay = 10000000;
// response interceptor
service.interceptors.response.use(
  response => {
    let data = response.data;
    if (typeof data === undefined || data === 'null' || data === null) {
      return Promise.resolve(null);
    } else {
      if (typeof data === 'string') {
        if (data.indexOf('error_respone') < 0) {
          return Promise.resolve(data);
        } else {
          const result = eval('(' + data + ')');
          const errorObj = {
            Code: 65535,
            Msg: result.error_respone.errMsg
          };
          return Promise.reject(errorObj);
        }
      }else {
          if (JSON.stringify(data).indexOf('error_respone') > 0) {
            let msg = data.error_respone.errMsg;
            let m = msg.indexOf(':');
            if (m > 0) {
              msg = msg.substr(m + 1);
            }
            let n = msg.indexOf('\n');
            if (n >= 0) {
              msg = msg.substr(0, n);
            }
            const errorObj = {
              Code: data.error_respone.errCode,
              Msg: msg
            };
            return Promise.reject(errorObj);
          }
          return Promise.resolve(data);
        }
      }
    },
    // 服务异常捕获
    err => {
      const errorObj = {
        Code: err.response.data.error_respone.errCode,
        Msg: err.response.data.error_respone.errMsg
      };
      return Promise.reject(errorObj);
    }
    );
export const url = baseUrl;

