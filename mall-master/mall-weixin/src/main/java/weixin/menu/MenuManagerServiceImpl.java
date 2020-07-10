package weixin.menu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther: zqtao
 * @description: 微信自定义菜单核心服务实现类
 * @version: 1.0
 */
@Slf4j
public class MenuManagerServiceImpl implements MenuManagerService {

	/**
	 * 创建菜单
	 *
	 * @param menu        菜单实例
	 * @param accessToken 有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	@Override
	public int createMenu(Menu menu, String accessToken) {
		System.out.println("创建菜单开始");
		int result = 0;
		// MENU_CREATE_URL菜单创建（POST） 限100（次/天）
		// 拼装创建菜单的url
		String url = WechatInterface.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		System.out.println("创建菜单的URL：" + url);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSON.toJSONString(menu);
		// 调用接口创建菜单
		JSONObject jsonObject = HttpRequestUtil.httpRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInteger("errcode")) {
				result = jsonObject.getInteger("errcode");
				log.error("======>>>   创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInteger("errcode"), jsonObject.getString("errmsg"));
			}
		}
		System.out.println("创建菜单结束");
		return result;
	}

	/**
	 * 删除菜单
	 * 对应创建接口，正确的Json返回结果:
	 * {"errcode":0,"errmsg":"ok"}
	 *
	 * @param accessToken 有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	@Override
	public int deleteMenu(String accessToken) {
	/*	int result = 0;
		String url = WechatInterface.MENU_DELETE_URL.replace("ACCESS_TOKEN", accessToken);
		// 调用接口删除菜单
		HttpRequestUtil.httpRequest(url, "GET", null);
		if (null != jsonObject) {
			if (0 != jsonObject.getExpires_in()) {
				result = jsonObject.getExpires_in();
				log.error("======>>>   删除菜单失败 errcode:{} errmsg:{}", jsonObject.getExpires_in(), jsonObject.getAccess_token());
			}
		}
		return result;*/
		return 1;
	}
}
