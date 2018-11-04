开发一个简单的maven插件，要求能通过配置获取简单数据和统计工程路径下的Java文件数量
1.新建一个maven项目
    <groupId>com.rico.study</groupId>
    <artifactId>mvn-plugin</artifactId>
    <version>1.0-SNAPSHOT</version>
2.定义打包类型为maven-plugin
3.引入maven插件类库
4.新建一个java类，继承AbstractMojo类并重写execute()方法
5.实现自己的业务逻辑

在新项目中使用
1.引入插件
    <build>
        <plugins>
            <plugin>
                <groupId>com.rico.study</groupId>
                <artifactId>mvn-plugin</artifactId>
                <version>1.0-SNAPSHOT</version>
                <configuration>
                    <msg>Hello Word!</msg>
                    <options>
                        <option>one</option>
                        <option>two</option>
                    </options>
                </configuration>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>myplugin</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>




