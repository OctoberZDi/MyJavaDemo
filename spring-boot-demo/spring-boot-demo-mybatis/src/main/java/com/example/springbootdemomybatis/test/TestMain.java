package com.example.springbootdemomybatis.test;

import com.example.springbootdemomybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestMain
 * @Description: testmain
 * @Author: zhangdi
 * @Date: 2020年12月26日 17:09
 **/
public class TestMain {
    public static void main(String[] args) throws IOException, SQLException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        // 任何打开的SQLSession都要保证被妥善关闭。最佳模式使用try-with-resource
        try (SqlSession sqlSession = build.openSession(true)) {
            // 使用类mapper注解
            // User user = (User)sqlSession.selectOne("com.example.springbootdemomybatis.mapper.UserMapper", "1342678073950191629");
            Configuration configuration = sqlSession.getConfiguration();
            System.out.println(configuration.toString());
            User user = new User() {
                {
                    this.setName("张迪");
                    this.setAge(21);
                    this.setEmail("912688695@qq.com");
                    this.setCreate_time(new Timestamp(System.currentTimeMillis()));
                    this.setUpdate_time(new Timestamp(System.currentTimeMillis()));
                }
            };
            System.out.println(user);
            int insertUser = sqlSession.insert("insertUser", user);
            System.out.println("调用insertUser:插入条数：" + insertUser);
            System.out.println("批量插入 开始");
            List<User> users = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                int finalI = i;
                users.add(new User() {
                    {
                        this.setName("张迪" + finalI);
                        this.setAge(21 + finalI);
                        this.setEmail("912688695@qq.com");
                        this.setCreate_time(new Timestamp(System.currentTimeMillis()));
                        this.setUpdate_time(new Timestamp(System.currentTimeMillis()));
                    }
                });
            }

            // 转为map
            Map useMap = new HashMap(5);
            useMap.put("users", users);
            // 方式2，使用resource文件
            int insertUsers = sqlSession.insert("insertUsers", useMap);
            System.out.println("插入条数：" + insertUsers);
            System.out.println("批量插入 结束");

            System.out.println("查询全部！");
            List<User> selectAll = sqlSession.selectList("selectAll");
            System.out.println(selectAll);

            System.out.println("限定行数查询！");
            List<User> selectAll1 = sqlSession.selectList("selectAll", null, new RowBounds(0, 5));
            System.out.println(selectAll1);

            // 更新指定id
            User targetUser = (User) sqlSession.selectOne("selectById", "1342678073950191779");
            System.out.println("目标用户信息");
            System.out.println(targetUser);

            System.out.println("开始更新");
            targetUser.setAge(30);
            targetUser.setName("张迪update");

            int updateById = sqlSession.update("updateUserById", targetUser);
            System.out.println("更新结果条数：" + updateById);
            sqlSession.commit();
        }

        /*// Resources使用 demo code
        TransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setURL("jdbc:mysql://localhost:3306/mydb?");
        dataSource.getConnection("root", "root");
        Connection connection = dataSource.getConnection();
        Environment environment = new Environment("development", jdbcTransactionFactory, dataSource);
        Configuration configuration = new Configuration();
        configuration.setEnvironment(environment);
        SqlSessionFactory build1 = new SqlSessionFactoryBuilder().build(configuration);
        build1.openSession(true);
        // SqlSessionFactory创建SqlSession
        SqlSession sqlSession1 = new SqlSessionFactoryBuilder().build(configuration).openSession(true);
        configuration.setLocalCacheScope(LocalCacheScope.STATEMENT);
        // 清空本地缓存
        sqlSession1.clearCache();
        // 关闭SqlSession
        sqlSession1.close();*/
    }
}
