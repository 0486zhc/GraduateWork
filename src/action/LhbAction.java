package action;

import model.lhb.User;
import bo.LhbBo;

import com.opensymphony.xwork2.ActionSupport;

public class LhbAction extends ActionSupport
{
   private LhbBo lhbBo;
   private User  user;

   public LhbBo getLhbBo()
   {
      return lhbBo;
   }

   public void setLhbBo(LhbBo lhbBo)
   {
      this.lhbBo = lhbBo;
   }

   public User getUser()
   {
      return user;
   }

   public void setUser(User user)
   {
      this.user = user;
   }

   public String loginQuery()
   {
      return lhbBo.loginQuery(user.getUser(), user.getPwd());
   }

}
