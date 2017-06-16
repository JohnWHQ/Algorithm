enum Singleton{
	A,
	B,
	C;

    int value;

    Singleton(){
    	System.out.println(System.currentTimeMillis());
    	// value = (int)System.currentTimeMillis();
    }
    public int getValue() {
        return value;
    }
    public void setValue(int data){
    	value = data;
    }	
}
// class D{
// 	private int a = 0;
// 	public D(){
// 		a = 12;
// 	}
// }
class try_enum{
	public static void main(String[] args) throws Exception{
		// Singleton.A.setValue(123);
		System.out.println("______________________________");
		System.out.println(Singleton.A.getValue());
		// try{
		// 	Thread.sleep(1);
		// }catch(Exception e){

		// }

		// Singleton.B.setValue(321);

		System.out.println(Singleton.B.getValue());
		System.out.println(Singleton.C.getValue());

		System.out.println("______________________________");
		Singleton.A.setValue(123);

		System.out.println(Singleton.A.getValue());
		System.out.println(Singleton.B.getValue());
		System.out.println(Singleton.C.getValue());

		// System.out.println(Singleton.value);
		// D d = new D();
		// d.a = 13;
		// System.out.println(d.a);
	}

}