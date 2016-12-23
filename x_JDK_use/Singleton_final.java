class Singleton_final{
	private final static Singleton_final instance = new Singleton_final();
	private Singleton_final(){}
	public static Singleton_final getInstance(){
		return instance;
	}

}