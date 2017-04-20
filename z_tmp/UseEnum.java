import java.util.*;
class UseEnum{
	public static void main(String[] args) {
		// enumTest.ONE.setVal("test");
		// System.out.println(enumTest.ONE.getVal());

		// enumTest e1 = enumTest.ONE;
		// System.out.println("e1:" + e1.getVal());

		// enumTest.ONE.setVal("test");
		// enumTest e2 = enumTest.ONE;
		// System.out.println("e2:" + e2.getVal());

		// System.out.println("e1: last" + e1.getVal());

		// System.out.println(e1.equals(e2));

		System.out.println(enumTest.ONE);
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