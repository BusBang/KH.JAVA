package samsung.vo;

public class Display extends Phone{
   
   private String depth;
   private int wide;

   public Display() {
      
   }
   
   public Display(String name, int price, int stock, String depth, int wide) {
      super(name,price,stock);
      this.depth=depth;
      this.wide=wide;
   }
   
   public String getDepth() {
      return depth;
   }
   public void setDepth(String depth) {
      this.depth=depth;
   }
   public int getWide() {
      return wide;
   }
   public void setWide(int wide) {
      this.wide=wide;
   }
}