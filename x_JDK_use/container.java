import java.util.*;
class container{
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("fuck");
		arrayList.add(null);
		arrayList.add("shit");

		for (String s : arrayList) {
			System.out.println(s);
		}	

		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("fuck");
		linkedList.add(null);
		linkedList.add("shit");
		for (String s : linkedList) {
			System.out.println(s);
		}

		HashMap<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("fuck1","shit1");
		hashMap.put(null,"none lalala!");
		hashMap.put(null,null);
		hashMap.put("fuck2","shit2");
		for (Map.Entry<String,String> entry : hashMap.entrySet() ) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

		// don't give me the fuck null!

		// TreeMap<String,String> treeMap = new TreeMap<String,String>();
		// treeMap.put("fuck1","shit1");
		// treeMap.put(null,"none lalala!");
		// treeMap.put("fuck2","shit2");
		// for (Map.Entry<String,String> entry : treeMap.entrySet() ) {
		// 	System.out.println(entry.getKey()+":"+entry.getValue());
		// }		

		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("fuck");
		hashSet.add(null);
		hashSet.add("shit");
		Iterator<String> iterator1 =  hashSet.iterator();
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}

		// don't give me the fuck null!

		// TreeSet<String> treeSet = new TreeSet<String>();
		// treeSet.add("fuck");
		// // treeSet.add(null);
		// treeSet.add("shit");
		// Iterator<String> iterator2 = treeSet.iterator();
		// while(iterator2.hasNext()){
		// 	System.out.println(iterator2.next());
		// }
		System.out.println(1 % 2);

	}
}