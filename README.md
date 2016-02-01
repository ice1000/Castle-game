# 城堡游戏
![icon](https://github.com/ice1000/Castle-game/blob/master/drawable/ic_launcher.png)

# 内容介绍

这是一个很~~猥琐~~励志的DOS游戏。你是一名勇士，你要闯荡城堡，~~推倒~~偶遇几个妹子。<br/>
至于你最终要怎么样，我现在也不知道。<br/>
如果你有好的想法请务必告诉我，谢谢！！！！<br/>
我从初学Java开始就在写这个玩意了，这是一个纯Java项目，希望大家喜欢。<br/>
随着我不断地更新，GUI也出来了<br/>
不过根据无无的说法，这款游戏的特色就是只有CUI<br/>
而且由于开发者之一的奶茶同学要求我做一个CUI的<br/>
所以现在就是双版本共存哦！既有CUI也有GUI哦！！<br/>
存档就是根目录下的“save.ice”文件的说<br/>
地图：<br/>
![map](https://github.com/ice1000/Castle-game/blob/master/drawable/%E8%BE%85%E5%8A%A9%E5%B7%A5%E5%85%B7%E4%B9%8B%E5%9C%B0%E5%9B%BE.png)

# 运行方法
### 首先你得安装了JRE7以上的环境。
然后根据你的个人情况进行选择：
## 你有Java的IDE或者你会命令行编译运行
~~有卵用~~<br/>
那就简单了，下载代码编译运行，<br/>
~~其实直接像下面说的那样运行jar包是一样的。。。~~<br/>
由于你是编译运行，绝对能享受到最新的功能。<br/>

## 你使用基于Linux或者Unix的操作系统
~~你了不起啊你这是歧视瘟都死吗~~<br/>
看到那个jar包了吗，castle.jar，这个是我已经打包好了的。<br/>
所以你们只需要打开终端<br/>
在终端先进入城堡游戏文件夹。<br/>
如果你想尝试CUI版，请输入：<br/>
> $ java -jar ./castle-cui.jar
如果你想尝试GUI版，请输入：<br/>
> $ java -jar ./castle-gui.jar

按理说应该是可以运行的。

## 你使用瘟都死操作系统
~~妈的你用这种垃圾系统还好意思下载老子的游戏~~<br/>
~~去学习如何编译运行~~<br/>
首先确保你安装了Java环境。<br/>
右上角"download zip"看到了吗，下载下来，解压，<br/>
然后根据你的需求，找到“城堡游戏-GUI.exe”<br/>
双击运行就行了。<br/>
Windows平台不提供CUI的可执行文件，如果你执意运行的话，cmd运行jar包吧。<br/>
方法和上面一样。

# 实现情况
- [X] 一个图标
- [X] 地图系统(完善)
- [X] 存档系统(完善)
- [X] 战斗系统(完善)
- [X] BOSS系统(不完善)
- [X] 等级系统(较为完善)
- [X] ~~GUI~~封装的CUI
- [X] GUI、CUI双版本共存
- [ ] 物品、背包系统
- [ ] NPC系统
- [ ] 与服务器端的通讯。

# 更新日志

## 本次更新

### 2016年2月1日
1. 根据[j8的朋友的反馈](http://tieba.baidu.com/p/4332888079?pid=83364878659#83364878659)修复了一个空指针异常 感谢这位朋友！
1. 更改背景颜色。
1. 增加两个新指令。

## 早期更新

### 2016年1月31日
1. 在奶茶同学的要求下，分别封装了CUI和GUI两个版本，各自有各自的main。（工作量极大！！)
1. 因此有了两个MANIFEST。
1. 然后更改了重命名的方式。
1. 大量简化API。

### 2016年1月30日
1. 扩张地图。增加了一个村庄。
1. 来到一个地方的问候方式改变。
1. 开始做物品系统。
1. 简化代码

### 2016年1月29日
1. 有了~~GUI~~GUI封装的CUI
1. 修复GUI无法退出的问题
1. 修复GUI无法重命名、重命名之后又反正就是乱七八糟的一大堆解释起来很麻烦的问题

### 2016年1月29日
1. 封装了所有数据库操作
1. 将所有的交互放在了主类中
1. 现在可以保存每个Room的状态了
1. 妈的今天修bug修惨了，我真可怜

### 2016年1月28日
1. 大规模更改设计模式, 用一个地图类封装了地图的操作
1. 扩张地图

### 2016年1月27日
1. 扩张地图
1. 增加新企划

### 2016年1月26日
1. 解决存档的问题
1. 修复地点不能保存的bug

### 2016年1月26日 
1. 各种封装
1. 写Javadoc
1. 搞了个图标出来
1. 去掉暂时无用的功能

### 2016年1月25日
1. 游戏完整化
