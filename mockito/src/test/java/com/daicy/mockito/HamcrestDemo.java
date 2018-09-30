package com.daicy.mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daicy.mockito.user.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestDemo {
    private com.daicy.mockito.user.User User;
    private User User1;
    private User User2;
    private List<User> list = new ArrayList<>(3);
    private Map<String, User> map = new HashMap<>();
    String[] strArray = { "1", "2" };

    @Before
    public void setUp() {
        User = new User();
        User1 = new User();
        User2 = User1;
        list.add(User);
        list.add(User1);
        list.add(User2);
        map.put("User", User);
        map.put("User1", User1);
        map.put("User2", User2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test() throws Exception {
        /******************* 对象相关方法 ********************************/
        // equalTo：判断2个对象是否相等，使用Object.equals方法
        assertThat(User1, Matchers.equalTo(User2));
        System.out.println(User1.toString());
        // hasToString：判断一个对象的toString方法
        assertThat(User, Matchers.hasToString("User(name=null, age=null)"));
        // instanceOf：判断对象是否为某个类的实例对象
        assertThat(User, Matchers.instanceOf(User.class));
        // notNullValue，nullValue：判断对象是否为null值
        assertThat(null, Matchers.nullValue());
        assertThat(User, Matchers.notNullValue());
        // sameInstance： 测试2个对象是否同一个实例
        assertThat(User1, Matchers.sameInstance(User2));

        /******************* javaBean相关方法 ****************************/
        assertThat(User, Matchers.hasProperty("name"));

        /******************* 集合相关方法 ********************************/
        assertThat(strArray, Matchers.array(Matchers.equalTo("1"), Matchers.equalTo("2")));
        // hasEntry, hasKey, hasValue：测试一个Map包含一个实体,键或者值
        assertThat(map, Matchers.hasEntry("User", User));
        assertThat(map, Matchers.hasKey("User"));
        assertThat(map, Matchers.hasValue(User));
        // hasItem, hasItems：测试一个集合包含一个元素
        assertThat(list, Matchers.hasItem(User));
        assertThat(list, Matchers.hasItems(User, User1));
        // hasItemInArray：测试一个数组包含一个元素
        assertThat(strArray, Matchers.hasItemInArray("1"));
//        // in：测试一个对象在一个集合中
//        assertThat(User, Matchers.in(list));

        /******************* 数字相关方法 ********************************/
        // closeTo：测试浮点值接近给定的值
        assertThat(1.5, Matchers.closeTo(1.0, 0.6));
        // greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo：测试大于，小于
        assertThat(1.0, Matchers.greaterThan(0.5));
        assertThat(1.5, Matchers.lessThanOrEqualTo(1.5));

        /******************* 文本相关方法 ********************************/
        // equalToIgnoringCase：测试字符串相等忽略大小写
        assertThat("UserPark", Matchers.equalToIgnoringCase("Userpark"));
        // equalToIgnoringWhiteSpace：测试字符串忽略空白
        assertThat("  UserPark111", Matchers.equalToIgnoringWhiteSpace("UserPark111"));
        // containsString, endsWith, startsWith：测试字符串匹配
        assertThat("UserPark", Matchers.containsString("User"));
        assertThat("UserPark", Matchers.startsWith("User"));
        assertThat("UserPark", Matchers.endsWith("Park"));

        /******************* 逻辑相关方法 ********************************/
        // allOf：如果所有匹配器都匹配才匹配
        assertThat("UserPark", Matchers.allOf(Matchers.endsWith("Park"), Matchers.startsWith("User")));
        // anyOf：如果任何匹配器匹配就匹配
        assertThat("UserPark", Matchers.anyOf(Matchers.endsWith("P22ark"), Matchers.notNullValue()));
        // not：如果包装的匹配器不匹配器时匹配，反之亦然
        assertThat("UserPark", Matchers.not(Matchers.endsWith("P22ark")));
        // is：如果包装的匹配器匹配器时匹配，反之亦然
        assertThat(User1, Matchers.is(User2));
        assertThat("UserPark", Matchers.is(Matchers.endsWith("Park")));
    }

}
