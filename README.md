# DoraCacheSample

### 运行截图

![avatar](https://github.com/dora4/DoraCacheSample/blob/main/art/dcache.png)

### Gradle依赖配置

将dcache-android克隆到根目录下。

```bash
// 进入项目根目录
cd DoraCacheSample
// 克隆依赖的主框架
git clone https://github.com/dora4/dcache-android.git
```
也可以将本地的库依赖修改为远程jitpack的依赖。

```groovy
// 依赖dcache
def latest_version = '2.2.7'
api "com.github.dora4:dcache-android:$latest_version"
```

### dcache-android 地址
https://github.com/dora4/dcache-android
