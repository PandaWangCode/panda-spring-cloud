package nx.panda.main02_java8_stream;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * 使用lambda表达式和stream实现wordcount功能
 * 参考网上列子
 * @author panda
 * 
 */
public class StreamWordCount {
	
	// 例子数据list
	static List<String> wordList = Arrays.asList("",
		 "You Have Only One Life ",
		 "There are moments in life when you miss someone so much that you just ",
		 "want to pick them from your dreams and hug them for real! Dream what ",
		 "you want to dream;go where you want to go;be what you want to be,",
		 "because you have only one life and one chance to do all the things you want to do.",
		 "because you have only one life and one chance to do all the things you want to do");
	
	public static void main(String[] args) {
		// 初始化存放每个word个数的hashmap
		HashMap<String, Integer> wordToCounts = new HashMap<>();
		
		// 函数型方法：<传入T,返回R>,这里：传入String，返回：Stream<String>。
		//说明: 将没一行字符转换为字符串数组，然后将字符串数组映射成一个流,以空格区分每一个单词
		Function<String, Stream<String>>  strToStream = everyLines -> Arrays.stream(everyLines.toLowerCase().split(" "));
		
		//消费型方法void()：将每一个单词，放入hashmap中统计其个数
		Consumer<String> mapActions = (str) ->{ 
			if (wordToCounts.containsKey(str))
				wordToCounts.put(str, wordToCounts.get(str) + 1);
			else 
				wordToCounts.put(str, 1);
		};
		
		wordList.stream().flatMap(strToStream).forEach(mapActions);
		//输出
		wordToCounts.entrySet().forEach(System.out::println);
	}
	
	/**
	 * 第二种方法：
	 */
	@Test
	public void Test() {
		//临时变量，用于计数(这里用数组是因为lambda表达式内不能改变外部变量，java的闭包有缺陷)
        int[] count = {1};

        // BinaryOperator 接受两个相同类型的参数，并返回其参数相同类型的结果
        BinaryOperator<String> wordCount = (prevWrod, nowWord) -> {
        	if (nowWord.equals(prevWrod)) {
                count[0]++;
            } else if (!"".equals(prevWrod)) {
                System.out.println(prevWrod + "=" + count[0]);
                count[0] = 1;
            }
            return nowWord;
        };
        
        wordList.stream().flatMap(line -> Arrays.stream(line.toLowerCase().split(" ")))
        //必须将单词先排序,相同的单词连接在一起
        .sorted().reduce("", wordCount);
	}
	
}
