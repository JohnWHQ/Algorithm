import java.util.*;
class UseEnum{
	public static void main(String[] args) {
		enumTest.ONE.setVal("fuck");
		System.out.println(enumTest.ONE.getVal());
	}
	public enum enumTest{
		ONE("TEST1"),
		TWO("TEST2"),
		THREE("TEST3"),
		FOUR("TEST4"),
		FIVE("TEST5");

		String val ;

		private enumTest(String val){
			this.val = val;
		}
		public void setVal(String val){
			this.val = val;
		}
		public String getVal(){
			return val;
		}

	}
}