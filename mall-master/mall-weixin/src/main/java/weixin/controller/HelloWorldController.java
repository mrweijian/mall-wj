package weixin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weixin.menu.CheckoutUtil;
import weixin.message.MessageUtil;
import weixin.message.ReplyTextMsg;
import weixin.twocolorball.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestController
public class HelloWorldController {
	/**
	 * 微信消息接收和token验证
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/hello")
	public String hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			// 微信加密签名
			String signature = request.getParameter("signature");
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			// 随机数
			String nonce = request.getParameter("nonce");
			// 随机字符串
			String echostr = request.getParameter("echostr");
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
				return echostr;
			}
		}else {
			InputStream in=request.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
			String sReqData="";
			String itemStr="";//作为输出字符串的临时串，用于判断是否读取完毕
			while((itemStr=reader.readLine())!=null){
				sReqData+=itemStr;
			}
			in.close();
			reader.close();

			System.out.println("收到消息："+sReqData);
			//封装获取的消息
			ReplyTextMsg fromMsg = MessageUtil.convertMessage(sReqData);
			//测试功能， 接入双色球彩票信息
			if(fromMsg.getContent().equals("彩票")){

				StringBuilder codes = Test.getCodes();
				fromMsg.setContent(codes.toString());
			}else {
				fromMsg.setContent("发送“彩票”获取一注双色球彩票！");
			}

			//防止中文乱码
			response.setCharacterEncoding("UTF-8");
			String s = MessageUtil.replyMessage(fromMsg,null);
			return s;
		}
		return null;
	}

	@RequestMapping("/message")
	public String message(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
		Iterator<Map.Entry<String, String[]>> iterator = entries.iterator();
		while (iterator.hasNext()){
			Map.Entry<String, String[]> next = iterator.next();
			System.out.println(next.getKey());
			System.out.println(next.getValue());

		}
		System.out.println(parameterMap.toString());
		return "SUCCESS";
	}
}
