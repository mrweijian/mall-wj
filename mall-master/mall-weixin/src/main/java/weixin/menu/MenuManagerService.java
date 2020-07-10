package weixin.menu;

public interface MenuManagerService {

	int createMenu(Menu menu, String accessToken);
	int deleteMenu(String accessToken);
}
