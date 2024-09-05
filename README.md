# DoraCacheSample

### 运行效果

<img width="400" height="860" src="https://dorachat.oss-cn-hongkong.aliyuncs.com/SVID_20240904_225619_1.gif">

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
def latest_version = '2.4.13'
api "com.github.dora4:dcache-android:$latest_version"
```
