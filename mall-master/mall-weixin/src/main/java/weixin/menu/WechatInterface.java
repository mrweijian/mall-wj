package weixin.menu;
/**
 * @auther: zqtao
 * @description: 微信官方提供的功能性接口常量
 * @version: 1.0
 */
public class WechatInterface {
	/**
	 * 获取access_token的接口地址（GET） 限200（次/天）
	 */
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * 自定义菜单删除接口
	 */
	public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * 自定义菜单的创建接口
	 */
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * 自定义菜单的查询接口
	 */
	public static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
}
