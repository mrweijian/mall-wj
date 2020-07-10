package weixin.menu;

import lombok.Data;

/**
 * @auther: zqtao
 * @description: 复合类型的按钮（含有子菜单的一级菜单）
 * @version: 1.0
 */
@Data
public class ComplexButton extends BasicButton{
	private BasicButton[] sub_button;
}
