class SuperParseUtils{
	private static String fileName;

	public static void main(String[] args) {
		
	}

	public static void superParse(String file) {
		try{
			FileReader reader = new FileReader("file_path");
			BufferedReader br = new BufferedReader(reader);
			String perLine = null;
			while ((perLine = br.readLine()) != null) {
				int index = 0;
				if( parseLine(perLine);){
					System.out.prinln("line " + i + "parse successed" );
				}else {
					System.out.prinln("line " + i + "parse failed" );
				}
			}

		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static boolean parseLine(String line) {
		String[] sarr = line.split("\t");
		String[] res = new String[sarr.length];
		int index = 0;
		for (String col : sarr) {
			String column = parseColumn(col);
			res[index++] = column;
		}
		return true;
	}

	public static String parseColumn(String col){
		if (col.cotains("num:")) {
			col = col.trim().subString(4);
			String[] sarr = col.split(",");
			//  return xxx;
		}else if () {

		}else {
			String str = parseLang(col);
			//  return xxx;
		}
	}

	public static String parseLang(String col){
		
	}
}