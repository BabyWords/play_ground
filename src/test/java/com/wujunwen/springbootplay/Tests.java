package com.wujunwen.springbootplay;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SpringBootTest
public class Tests {

    @Test
    public void reduceTests() {
        List<TestEntity> testList = new ArrayList<>();
        testList.add(new TestEntity(new BigDecimal(3)));
        testList.add(new TestEntity(new BigDecimal(4)));
        testList.add(new TestEntity(new BigDecimal(5)));
        BigDecimal result = testList.stream().map(TestEntity::getNum).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(result);
    }

    /**
     * list.stream().mapToDouble(User::getHeight).sum()//和
     * list.stream().mapToDouble(User::getHeight).max()//最大
     * list.stream().mapToDouble(User::getHeight).min()//最小
     * list.stream().mapToDouble(User::getHeight).average()//平均值
     *
     * @return
     */
    @Test
    public void sumTest() {
        List<TestEntity> testList = new ArrayList<>();
        testList.add(new TestEntity(1));
        testList.add(new TestEntity(2));
        testList.add(new TestEntity(3));
        OptionalInt intee = testList.stream().mapToInt(TestEntity::getNum1).max();
        List<TestEntity> mewss = testList.stream().filter(s -> s.getNum1() > 2).collect(Collectors.toList());
        System.out.println(mewss.toArray());
    }


    /**
     * 匹配获得<>中的内容
     */
    @Test
    public void testRegex() {
        String content = "2017-11-15 11:22:46.463 WARN <BDK-offline><ClientCnxn><org.apache.zookeeper.ClientCnxn$SendThread><run><1102>";
        Pattern pattern = Pattern.compile("(?<=\\<)[^\\>]+");
        Matcher matcher = pattern.matcher(content);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        System.out.println(list);
    }

    /**
     * 日志消息中如果还有<>
     */
    @Test
    public void extractMessage() {
        JSONObject data = new JSONObject();

        String content = "2017-11-15 11:22:46.463 WARN <BDK-offline<sss>><ClientCnxn><org.apache.zookeeper.ClientCnxn$SendThread<run><1102><234234232>";
        List<String> list = new ArrayList<String>();
        int start = 0;
        int startFlag = 0;
        int endFlag = 0;
        int count=1;
        for (int i = 0; i < content.length(); i++) {
            if (count==3){
                break;
            }
            if (content.charAt(i) == '<') {
                startFlag++;
                if (startFlag == endFlag + 1) {
                    start = i;
                }
            } else if (content.charAt(i) == '>') {
                endFlag++;
                if (endFlag == startFlag) {
                    data.put("log_filter"+count,content.substring(start + 1, i));
//                    list.add(content.substring(start + 1, i));
                    count++;
                }
            }
        }
        System.out.println(data);
    }

    @Test
    public void test(){
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }

    @Test
    public void test2(){
        ClassLoader classLoader=Tests.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }

    @Test
    public void diguitest(){

    }

}
