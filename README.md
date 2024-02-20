# OutPower (越权)

* burp插件
* 主要用于测试越权、未授权
* 在xia yue插件的基础上进行二开
* 感谢名单：算命瞎子、darkfive

**********

### 注意
* 默认使用jdk1.8编译
* 旨在于帮助安全测试人员提高日常测试效率，请勿违规使用，后果自负！

**********
### 新增越权测试场景描述
* 灵感来源于日常测试中发现越来越多的公司采用mvc开发模式，比如以下应用场景：</br>
Url：https://www.baidu.com/webui/user/query/123456
而这里的123456便是我们需要越权测试的关键参数，目前只针对于整形参数进行测试，后期会加入测试参数值为字符串的情况，如：BC1231412412
**********
### 插件截图
<img width="1262" alt="image" src="https://github.com/darkfive2022/OutPower/assets/136411443/bf32c98c-fb35-4eae-bcc6-78a4df8eeaea">

