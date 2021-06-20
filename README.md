## DCache使用大全

简介：一个使用在Android平台的数据缓存框架，支持将model数据从后端接口下载后，简单的配置即可自动映射到数据库，并在断网的情况下可以离线读取。



### 开发前的准备

#### 开发环境

Android Studio、gradle

#### 需要具备的技能

SQLite数据库和Android网络数据请求相关的基础知识

#### gradle依赖配置

maven { url 'https://jitpack.io' }

def latest_version = 1.0.0

api 'com.github.dora4:dcache-android:${latest_version}'



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

   在自定义的Application类的入口加入一行配置

2. 注解详解

   - 表和列相关
     - @Table
     - @Column
     - @Ignore
   - 约束相关
     - @NotNull
     - @PrimaryKey
     - @Id
     - @Unique
     - @Default
     - @Unique

3. CRUD操作

   - 插入数据

   - 删除数据

   - 更新数据

   - 查询数据

     - Condition

     - WhereBuilder
     - QueryBuilder

   - 查询记录数

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

# DoraCacheSample