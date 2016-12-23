class Singleton_DoubleCheck{
	private volatile static Singleton_DoubleCheck instance = null;
	private Singleton_DoubleCheck(){}
	public static Singleton_DoubleCheck getInstance(){
		if(instance == null){
			synchronized (Singleton_DoubleCheck.class){
				if (instance == null) {
					instance = new Singleton_DoubleCheck();
				}
			}
		}
		return  instance;
	}

}