import {service} from '@/utils/service.js';

export  const request = {
  post:function(url,param){
    return new Promise((resolve,reject) => {
      service.post(url,param)
        .then(res=>{
          resolve(res);
        })
    })
  }
  }

