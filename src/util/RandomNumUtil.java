package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class RandomNumUtil
{
   private ByteArrayInputStream image;//图像
   private String str;//验证码
   private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',  
         'K', 'L', 'M', 'N',  'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
         'X', 'Y', 'Z',  '1', '2', '3', '4', '5', '6', '7', '8', '9' };  
   
   //初始化属性
   private RandomNumUtil()
   {
      init();
   }
   
   //获取RandomNumUtil实例
   public static RandomNumUtil instance()
   {
      return new RandomNumUtil();
   }
   
   //取得验证码图片
   public ByteArrayInputStream getImage()
   {
      return this.image;
   }
   
   //取得图片的验证码
   public String getString()
   {
      return this.str;
   }
   
   private void init()
   {
      //在内存中创建图像
      int width = 85;
      int height = 35;
      BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
      //获取图形上下文
      Graphics g = image.getGraphics();
      //生成随机类
      Random random = new Random();
      //设定背景色
      g.setColor(getRandColor(200,500));
      g.fillRect(0,0,width,height);
      //设定字体
      g.setFont(new Font("Times New Roman",Font.PLAIN,20));
      //随机生成155条干扰线,使图像中的验证码不易被其他程序探测到
      g.setColor(getRandColor(160,200));
      for (int i = 0; i < 155; i++)
      {
         int x = random.nextInt(width);
         int y = random.nextInt(height);
         int xl = random.nextInt(12);
         int yl = random.nextInt(12);
         g.drawLine(x, y, x+xl, y+yl);
      }
      //取随机产生的验证码(6位数字)
      StringBuilder sRand = new StringBuilder();
      for (int i = 0; i < 6; i++)
      {
         String rand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);  
         sRand.append(rand);
         //将验证码显示到图像中
         g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110)
               ,20+random.nextInt(110)));
         //调用函数出来的颜色相同,所以只能直接生成 下面一行是为了设置字体在图片中位置
         g.drawString(rand, 13*i+6, 25);
      }
      //赋值验证码
      this.str = sRand.toString();
      //图像生效
      g.dispose();
      ByteArrayInputStream input = null;
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      try
      {
         ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
         ImageIO.write(image, "JPEG", imageOut);
         imageOut.close();
         input = new ByteArrayInputStream(output.toByteArray());
      }
      catch(Exception ex)
      {
         System.out.println("验证码图片生成出现错误" + ex.toString());
      }
      this.image = input;//赋值图像
   }
   
   //给定范围获得随机颜色
   private Color getRandColor(int fc,int bc)
   {
      Random random = new Random();
      if(fc > 255)
      {
         fc = 255;
      }
      if(bc > 255)
      {
         bc = 255;
      }
      int r = fc + random.nextInt(bc - fc);
      int g = fc + random.nextInt(bc - fc);
      int b = fc + random.nextInt(bc - fc);
      return new Color(r,g,b);
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
