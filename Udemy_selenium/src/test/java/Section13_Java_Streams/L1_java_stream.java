package Section13_Java_Streams;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L1_java_stream {
//		@Test
//	filter the results 
		public void streamFilter() {
			ArrayList<String> names = new ArrayList<String>();
			names.add("Sam"); names.add("Ayesha");names.add("Hamza");names.add("Alisha");
			names.add("Hammad");names.add("Azhar");names.add("Asma");
			
//			Filter & Count
//			filter out name starts with "A"
			Long count = names.stream()
				.filter(name -> name.startsWith("A"))
				.count();
			System.out.println(count);
				
		}
		
//		@Test
		public void streamCount() {
//			filter out names ends with "A"
			long names = Stream.of("Ayesha", "Samra", "Alisha", "Ali", "Raza", "Maaz")
				.filter(name -> name.endsWith("a"))
				.count();
			
			System.out.println(names);
		}
		
//		@Test
		public void nameCount() {
			long length = Stream.of("Aisha", "Maya", "Sameed", "Hadia", "Tayyaba", "Hammad", "Wazir", "Yumna", "Raza")
					.filter(c -> c.length()>4)
					.count();
			System.out.println(length);
		}
		
//		@Test
		public void streamMap() {
//			map() -> helps to modify the stream
			Stream.of("Aisha", "Maya", "Sameed", "Hadia", "Tayyaba", "Asad")
					.filter(n -> n.startsWith("A"))
					.map(s -> s.toUpperCase())
					.forEach(s -> System.out.println(s));
		}
		
//		@Test
//		Print Name that Starts-with 'A' in a sorted manner
		public void sortedNames() {
			String[] name1 = {"Asad", "Aisha", "Maya", "Samra", "Alisha", "Ali"};
			List<String> nameList = Arrays.asList(name1);
			
			nameList.stream()
					.filter(s -> s.startsWith("A"))
					.map(s -> s.toUpperCase())
					.sorted()
					.forEach(System.out::println);
			
		}
		
//		@Test
//		Merge/ Concat two arrays and print them in a Sorted manner
//		anyMatch() -> return type = boolean and gives result
		public void mergeStream() {
			String[] names1 = {"Asad", "Aisha", "Maya", "Samra", "Alisha", "Ali"};
			String[] names2 = {"Enna", "Zia", "Aiman", "Noor", "Sana", "Raza"};
			List<String> namesList1 = Arrays.asList(names1);
			List<String> namesList2 = Arrays.asList(names2);
			
			 Stream<String> concatStream = Stream.concat(namesList1.stream(), namesList2.stream());
			 boolean res = concatStream.anyMatch(s-> s.equalsIgnoreCase("raza"));
			 Assert.assertTrue(res);
		}
		
//		@Test
//		Collect() ==> creates a new collection of List/Set
		public void collectStream() {
			String[] names2 = {"Enna", "Zia", "Aiman", "Noor", "Sana", "Raza"};
			List<String> namesList1 = Arrays.asList(names2);
			namesList1.stream()
					.filter(s -> s.endsWith("a"))
					.sorted()
					.collect(Collectors.toList())
					.forEach(System.out::println);
		}
		
		@Test
//		distinct()
		public void distinctStream() {
			List<Integer> values = Arrays.asList(1, 2, 3, 4, 13, 1, 2,5, 3, 2, 7, 5, 0);
//			find unique numbers and sort them
			values.stream().distinct().sorted().forEach(System.out::println);

//			after sorting find the Element on the 4th index
			List<Integer> val = values.stream().distinct().sorted().collect(Collectors.toList());
			System.out.println(val.get(3));
			
		}
	}
