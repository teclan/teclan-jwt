## Jwt 的简单使用

参考项目[jjwt](https://github.com/jwtk/jjwt)


## 引用本项目

克隆本项目，在项目目录下执行

``` 
mvn install
```

在项目下引入以下依赖依赖

```xml

    <dependency>
        <groupId>teclan.jwt</groupId>
        <artifactId>teclan-jwt</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```

## 使用示例

```java

import com.teclam.jwt.JwtFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TokenTest {

    String subject="teclan";
    String token="";

    @Before
    public  void setUp(){
        token = JwtFactory.getJws(subject);
    }

    @Test
    public void vaildTest(){
        Assert.assertEquals(JwtFactory.verify(subject,token),true);
    }
}


```