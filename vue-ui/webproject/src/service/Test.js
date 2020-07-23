import {request} from '@/utils/request.js';
import Qs from 'qs';

export class Test {

  TestOne(userid){
    return request.post('test',Qs.stringify({userid:userid}))
  }

  TestTwo(){
    return request.post('test')
  }
}
