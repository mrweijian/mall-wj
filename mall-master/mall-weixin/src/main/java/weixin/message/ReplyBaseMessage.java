package weixin.message;

public class ReplyBaseMessage {

	protected String ToUserName;
	protected String FromUserName;
	protected String CreateTime;
	protected String MsgType;

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public String getMsgType() {
		return MsgType;
	}
}
