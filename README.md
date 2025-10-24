# DoraCacheSample

### 运行效果

![avatar](https://github.com/dora4/DoraCacheSample/blob/main/art/get_started.gif)

### App下载

[Android](https://www.pgyer.com/Qiiq8emN)

![0](https://github.com/user-attachments/assets/ce6f3af2-a032-41ad-9bf0-9277f7398d82)

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
def latest_version = '3.1.9'
api "com.github.dora4:dcache-android:$latest_version"
```
