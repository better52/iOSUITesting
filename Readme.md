# 工程结构
工程采用Java代码实现，主目录包含三个文件夹：
1. src：存放源代码
2. resource：存放资源和配置
3. library：存放外部依赖库

# 源代码结构
源代码以package的形式组织，不同模块的测试用例放在不同的package中，比如：com.xkeshi.iostesting.cashier.member是会员模块的测试用例，com.xkeshi.iostesting.cashier.login是登录模块的测试用例等。
除此之外，还有一些配置相关的package，具体说明如下：
1. com.xkeshi.iostesting: 通用接口定义
2. com.xkeshi.iostesting.capability: 连接Appium Server需要使用的DesiredCapability定义，使用config.properties配置文件
3. com.xkeshi.iostesting.util: 通用工具

# 配置文件的结构
## config.properties文件
该文件用于描述连接Appium Server的方式，采用properties文件方式，主要字段如下：
1. automaticName: 自动化测试框架名，iOS目前固定是XCUITest，不需要更改
2. platformName: 系统名，iOS平台采用iOS，不需要更改
3. platformVersion: 系统版本，iOS系统版本
4. deviceName: 测试设备名，在通用->关于本机里获得
5. udid: 测试设备的设备号，可以在Xcode中获取
6. app: 测试App的BundleID，收银台一般用com.xkeshi.coffee.cashier
7. url: Appium Server的访问地址，本地访问一般用http://127.0.0.1:4723/wd/hub