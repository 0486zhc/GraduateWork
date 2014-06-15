package action;

import java.io.ByteArrayInputStream;

import util.RandomNumUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RandomAction extends ActionSupport
{
   private ByteArrayInputStream inputStream;
   public String execute()
   {
      RandomNumUtil rdnu = RandomNumUtil.instance();
      this.setInputStream(rdnu.getImage());//取得带有随机字符串的图片
      ActionContext.getContext().getSession().put("random", rdnu.getString());
      return "success";
     
   }
   public ByteArrayInputStream getInputStream()
   {
      return inputStream;
   }
   public void setInputStream(ByteArrayInputStream inputStream)
   {
      this.inputStream = inputStream;
   }
   
}
