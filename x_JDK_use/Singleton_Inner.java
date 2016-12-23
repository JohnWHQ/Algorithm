class Singleton_Inner{
	private	static class SingletonHolder{
		private static final Singleton_Inner instance = new Singleton_Inner();
	}
	private Singleton_Inner(){}
	public static Singleton_Inner getInstance(){
		return  SingletonHolder.instance;
	}
}