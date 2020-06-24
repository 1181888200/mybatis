# JDBC连接Mysql数据库过程


## 1. 加载驱动
    java.sql.Driver 它在MySQL Connector / J 中实现的类的名称 是 com.mysql.jdbc.Driver，也就是驱动程序。
    ` Class.forName(DRIVER_CLASS_NAME) `
## 2. 获取数据库连接
    Connection 与数据库建立连接关系,通常为 DriverManager.getConnection（url, username, password）。
    这里可以很明显的感觉出来，每个元素所产生的作用 
* 2.1 获取连接的时候需要设置数据库相关的参数

        URL: 数据库的地址及库的名称，通用的格式
                protocol//[hosts][/database][?properties]
                protocol：一种连接协议，约定的规则。
                hosts：主机名，通常后跟端口号，例如当前主机默认就是localhost:3306，当然也可以多主机连接，这里暂时不表。
                database:数据库嘛
        username: 数据库连接的用户名
        password: 数据库连接密码

## 3. 进行数据库操作
* 3.1 操作数据库一般使用Statement / PreparedStatement / CallableStatement (调用存储过程) , 使用PreparedStatement的情况居多，主要有以下优点：
    * 3.1.1 Statement每次执行sql语句，相关数据库都要执行sql语句的编译，PreparedStatement是预编译得,PreparedStatement支持批处理
    * 3.1.2 PreparedStatement是预编译的,对于批量处理可以大大提高效率
    * 3.1.3 不用拼接，易编写易读懂
    * 3.1.4 防止SQL注入，提高安全性
* 3.2 有了PreparedStatement，我们就要对sql进行预编译和设置参数
    * 3.2.1 设置预编译 psst = con.prepareStatement(sql); 其中sql = "insert into user (name, password, sex, phone) VALUES(?,?,?,?)";
    * 3.2.2 设置参数：根据占位符的位置和数据类型，占位符从1开始，采用相对应的方法，比如设置字符串：psst.setString(1, "我的名字");
* 3.3 执行sql
    * 3.3.1 psst.executeQuery() 针对查询而言
    * 3.3.2 psst.executeUpdate()  针对数据更新
    * 3.3.3 psst.execute()  不知道是查询还是修改，可以使用这个语句
* 3.4 返回结果
    * 3.4.1 针对删除、修改、新增 返回的是影响条数 int
    * 3.4.2 针对查询，返回的ResultSet 结果集，通过返回的sql对应的字段类型和位置分别获取对应的值：String name = resultSet.getString(2);

## 4. 关闭相关资源
* 4.1 关闭返回结果资源（如果有返回结果ResultSet）
* 4.2 关闭操作资源 PreparedStatement
* 4.3 关闭数据库连接资源 Connection