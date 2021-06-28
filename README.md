## DCache使用大全

简介：一个使用在Android平台的数据缓存框架，支持将model数据从后端接口下载后，简单的配置即可自动映射到数据库，并在断网的情况下可以离线读取。



### 开发前的准备

#### 开发环境

Android Studio、gradle

#### 需要具备的技能

SQLite数据库和Android网络数据请求相关的基础知识

#### gradle依赖配置

```groovy
maven { url 'https://jitpack.io' }

def latest_version = '1.0.1'

api "com.github.dora4:dcache-android:$latest_version"
```



### 使用文档

#### 一、dcache的orm详解

1. **配置初始化**

   ```kotlin
   Orm.init(this, OrmConfig.Builder()
                   .database("dcache_sample")
                   .tables(Account::class.java)
                   .version(1)
                   .build())
   ```

   在自定义的Application类的入口加入一行配置，database为数据库名，version从1开始每次递增1，tables用来配置需要初始化的表，dcache中所有的表需要实现OrmTable接口。

2. **注解详解**

   - 表和列相关
     - @Table
     
       此注解配置在OrmTable的实现类的类名之上，用来指定一个类映射到表的名称
     
     - @Column
     
       此注解配置在OrmTable的实现类的成员属性之上，用来指定一个属性映射到字段的名称
     
     - @Ignore
     
       此注解的优先级高于@Column，配置在OrmTable的实现类的成员属性之上，配置了此注解的成员属性，不会作为表的字段进行映射
   - 约束相关
     - @NotNull
     
       此注解配置在OrmTable的实现类的成员属性之上，用来指定这个字段为非空字段
     
     - @PrimaryKey
     
       此注解配置在OrmTable的实现类的成员属性之上，用来指定这个字段为表的主键
     
     - @Id
     
       此注解配置在OrmTable的实现类的成员属性之上，作用类似于@PrimaryKey，并
     
       在它的基础上指定了该字段名为”_id“，相当于@PrimaryKey+@Column("\_id")
     
     - @Unique
     
       此注解配置在OrmTable的实现类的成员属性之上，表示这个字段的值在这张表中从不重复
     
     - @Default
     
       此注解配置在OrmTable的实现类的成员属性之上，通过它可以给字段指定默认值

3. **CRUD操作**

   - 插入数据

     ```kotlin
     DaoFactory.getDao(Account::class.java).insert(Account(generateAccKey(),
                         "D"+generateAccKey(), "P"+generateAccKey()))
     ```

     insert不仅可以被用来插入单条数据，也可以插入一个List数据

   - 删除数据

     ```kotlin
     val selectOne = DaoFactory.getDao(Account::class.java)
                         .selectOne(QueryBuilder.create().orderBy(QueryBuilder.ID))
                 if (selectOne != null) {
                     DaoFactory.getDao(Account::class.java).delete(selectOne)
                 }
     ```

   - 更新数据

     ```kotlin
     DaoFactory.getDao(Account::class.java).update(Account("这个是key",
                         "D"+generateAccKey(), "P"+generateAccKey()))
     ```

   - 查询数据

     - Condition

       selection：where子句，不带where，可以带”？“占位符

       selectionArgs：”？“占位符的所有值

     - WhereBuilder

       where子句的构建类，通过WhereBuilder.create ()创建实例

       ```java
       public WhereBuilder addWhereEqualTo(String column, Object value) {
               return append(null, column + EQUAL_HOLDER, value);
           }
       ```

       可以通过调用addWhereEqualTo添加key=value条件。

     - QueryBuilder

       支持where、orderBy、limit、groupBy等

   - 查询记录数

     ```kotlin
     val count = DaoFactory.getDao(Account::class.java).selectCount()
     ```

     通过selectCount查询符合查询条件的记录条数。

4. 其他注意事项

   - 复杂数据类型字段映射
   - 表结构升级
   - 事务操作

#### 二、网络数据的读取和解析

1. 自定义RetrofitManager
   - 基本配置
     - URL配置
     - json解析配置
     - OkHttpClient配置
     - 拦截器配置
       - Token拦截器
       - 格式化输出响应数据到日志
   - 模块化的数据接口设计
2. DoraCallback和DoraListCallback

#### 三、repository的使用

1. 数据缓存的设计思维
2. BaseRepository和@Repository
3. 本地缓存数据处理
   - 过滤
     - DataFetcher
     - ListDataFetcher
   - 分页
     - DataPager
     - 基于访问者模式的数据读取
