package weixin.message;

import org.dom4j.Document;
import org.dom4j.Element;

import java.io.PrintWriter;

public class MessageUtil {
	public static String replyMessage(ReplyTextMsg message, PrintWriter out) {
		try {
			String string = String.format("<xml>\n" +
							"  <ToUserName><![CDATA[%s]]></ToUserName>\n" +
							"  <FromUserName><![CDATA[%s]]></FromUserName>\n" +
							"  <CreateTime>%s</CreateTime>\n" +
							"  <MsgType><![CDATA[text]]></MsgType>\n" +
							"  <Content><![CDATA[%s]]></Content>\n" +
							"  <MsgId>%s</MsgId>\n" +
							"</xml>", message.getFromUserName(),
					message.getToUserName(), message.getCreateTime(), message.getContent(), message.getMsgId());
			/*out.println(string);
			out.flush();
			out.close();*/
			return string;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ReplyTextMsg convertMessage(String str) {
		ReplyTextMsg msg = new ReplyTextMsg();
		Document document = XMLUtil.readString2XML(str);
		Element root = document.getRootElement();
		String msgType = XMLUtil.readNode(root, "MsgType");
		String toUserName = XMLUtil.readNode(root, "ToUserName");
		String fromUserName = XMLUtil.readNode(root, "FromUserName");
		String createTime = XMLUtil.readNode(root, "CreateTime");
		String content = XMLUtil.readNode(root, "Content");
		String msgId = XMLUtil.readNode(root, "MsgId");
		msg.setMsgType(msgType);
		msg.setContent(content);
		msg.setToUserName(toUserName);
		msg.setFromUserName(fromUserName);
		msg.setCreateTime(createTime);
		msg.setMsgId(msgId);
		return msg;
	}

}
