# 第一次课
Linux之父   Linus Torvalds   **Linux内核**
自由软件之父/GNU   Richard Stallman  **软件外壳**
GNU Not Unix
Unix：付费操作系统，源代码不开放
Linux：不一定免费，源代码开放
自由软件：不是免费软件，它可以不受限制地自由**使用、复制、研究、修改、发布**。

# 第二次课
shell
含义
1、shell命令
2、shell解释器（解释用户输入的命令，然后交给系统运行）
3、shell脚本

大多数Linux版本都是用Bash作为默认的Shell程序

命令符`[nbcc@localhost~]$`
`nbcc` 当前用户名
`localhost` 当前主机名
`~` 当前工作目录 
`$` 普通用户类型
`#` 管理员用户类型

Linux命令三类：**二进制可执行文件**、**Shell脚本文件**、**Shell内建函数**

wohami 输出当前用户用户名

`echo "你好" `  输出字符串
`-n ""`不换行显示
`-e ""`字符串可接转义字符

nano 文本编辑器（ctrl+o 填入文件名 保存    ctrl+g 查看帮助文档    ctrl+x 退出）

# 第三次课
切换用户   `su 用户名`
退出管理员   `exit`
清屏   `clear`
切换到当前用户主目录   `cd`
查看当前系统的Shell解释器   cat /etc/shells
帮助命令（man、help、pinfo）
创建/修改文件   vi 文件名    i进入编辑    Esc退出编辑模式  冒号进入命令模式，输入wq


**关机/重启**
命令格式：shutdown [选项...] [时间] [警告...]
```
shutdown 
-r    重启系统
-h    关闭系统
-k    仅仅发送警告，不关机或者重启
-c    取消shutdown命令
```
关机
```
shutdown 10
shutdown +10
shutdown -h 10
shutdown -h +10
shutdown -h（默认一分钟后）
```

重启
```
shutdown -r now
shutdown -r 0
shutdown -r +0
shutdown -r（默认一分钟后）
```

# 第四次课
Linux命令一般格式
命令名 [选项1] [选项2]...<参数1><参数2>...
命令名：由小写字母构成
选项：对命令的特别定义，一般以"-"开始，ls -l -a 与ls -la 相同
参数：提供命令运行的信息，或者是命令执行过程中使用的文件名
命令、选项参数之间必须有空格

在linux中，目录也是文件
目录：**创建、切换、删除、显示、查看目录**（mkdir、cd、rmdir、pwd、ls）
文件：**创建、复制、移动、删除、查看**（touch、cp、mv、rm、file、cat、head、tail、less、more）
```
mkdir 
-m 建立目录同时设置目录权限
-p  不管建立目录的上层目录是否成立，都一并创建（作用结果为，同时创建指定目录和上层目录）
```
例子：
创建一个text目录，权限444（r--r--r--）
`mkdir -m 444 text`
当前目录的test目录下创建test2，test不存在
`mkdir -p test/test2`
当前目录一次创建多个目录
`mkdir test1 test3 test 5`
`mkdir test{1,3,5}`
当前目录创建10个目录
`mkdir test{1..10}`
在/tmp目录下创建dir
`mkdir /tmp/dir`

```
drwxr-xr-x. 2 lishuang lishuang  6 2月  17 17:13 公共
d目录  r 4读  w 2写  x 1执行  -没有的权限
```
（rwx：文件拥有者权限  r-x:同组其他用户  r-x：其他用户）

```
/bin  可执行文件
/boot  系统启动所需文件
/dev  设备目录，放设备文件
/etc  配置目录，放配置文件
/home  里面放普通用户的家目录
/lib  放库函数
/root  管理员家目录
/sbin  放管理文件，管理员才能运行
/srv  服务运行时所需信息
/tmp  临时目录，放临时文件
/opt  大型软件或者第三方软件目录
/media  可移动设备信息
```

