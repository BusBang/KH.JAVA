package samsung.vo;

public class Laptop extends Phone{
	   
	   private int wide;

	   public Laptop() {
	      
	   }
	   
	   public Laptop(String name, int price, int stock, int wide) {
	      super(name, price, stock);
	      this.wide=wide;
	   }
	   
	   public int getWide() {
	      return wide;
	   }
	   
	   public void setWide(int wide) {
	      this.wide=wide;
	   }
	   
	}