

## 基础
### 常用值类型

![常用值类型](D:\Study\Learning-record\Python\常用值类型.png)

### 注释

```python
# 单行注释

"""
多行注释
多行注释
多行注释
"""
```

### 类型转换

```python
# 字符串与数字的相互转换
int("111")

str(1111.22)
```

### 运算符

![运算符](D:\Study\Learning-record\Python\运算符.png)

- 逻辑运算符

```python
# python使用关键字来表示与或非的

# 定义布尔变量  
is_student = True  
is_adult = True  
is_teacher = False  
  
# 使用 and 运算符  
print("is_student and is_adult:", is_student and is_adult)  # 当两个条件都为真时，结果为真  
  
# 使用 or 运算符  
print("is_student or is_teacher:", is_student or is_teacher)  # 当至少一个条件为真时，结果为真  
  
# 使用 not 运算符  
print("not is_teacher:", not is_teacher)  # 反转条件的真假值  
  
# 复杂的逻辑表达式示例  
print("is_student and (not is_teacher) or is_adult:", is_student and (not is_teacher) or is_adult)  
# 解释：如果is_student为真，并且is_teacher为假（即not is_teacher为真），则结果为真。  
# 如果is_student和is_teacher都为假（即not is_teacher也为假），则由于or运算符，is_adult会被检查，  
# 因为is_adult为真，所以整个表达式的结果为真。
```

### 字符串的多种定义方式

```python
str1 = '单引号定义'
str2 = "双引号定义"
str3 = 
"""
三引号定义
"""
```

### 字符串格式化

1. 占位符方式

```python
str = "你好，这里是使用百分号对整数进行字符串格式化的一个例子，他的数值是：%s" % 11111

# 同理，也存在 %d , %f 之类的占位符，和C语言类似
```

2. 模板字符串

```python
# 使用f""的方式，类似于Vue的模板字符串
int3 = 9.15
str1 = f"衬衫的价格是{int3}便士"
str2 = f"模板字符串，关于我想说的话：{str1}"
print(str2)
```

### 获取键盘输入值

```python
name = input("你是谁？\n");
print("你好：" + name);
```

### 流程控制

1. if-elif-else

```python
age = 15

if age < 10:
    print("条件1成立");
elif 10 < age < 20:
    print("条件2成立");
else:
    print("条件都不成立");
```

2. 嵌套

```python
age = 5

if age < 10:
    print("条件1成立");
    if age <= 5:
        print("条件1第二层")
elif 10 < age < 20:
    print("条件2成立");
else:
    print("条件都不成立");
```

3. 循环

```python
i = 0
while i<100:
    print(f"i={i}");
    i += 1;
```

4. for-in

```python
# 定义一个列表  
fruits = ['apple', 'banana', 'cherry']

# 使用for循环遍历列表  
for fruit in fruits:
    print(fruit)
```

### 数字序列

配合for-in使用

```python
# 使用range函数生成一个从0到4（不包括4）的数字序列  
for i in range(5):
    print(i)

# 使用range函数生成一个从2到10（不包括10）的数字序列  
for i in range(2, 10):
    print(i)

# 使用range函数生成一个从1到10（不包括10），步长3的数字序列  
for i in range(1, 10, 3):
    print(i)
```

### 函数

- python函数的使用`def`关键词进行定义，通常使用`小写字母+下划线组成`命名
- 入参不需要指定参数类型

```python
# 示例1：计算两个数的和  
def calculate_sum(a, b):  
    return a + b  
  
# 示例2：检查一个数是否是偶数  
def is_even(number):  
    return number % 2 == 0  
  
# 示例3：获取字符串的长度  
def get_string_length(s):  
    return len(s)  
```

- 函数的多返回值

```python
# 定义一个函数，计算给定数字的平方和立方，并返回这两个结果  
def calculate_square_and_cube(number):  
    square = number ** 2  
    cube = number ** 3  
    return square, cube  # 返回一个包含平方和立方的元组  
  
# 调用函数并接收返回值  
square_result, cube_result = calculate_square_and_cube(5)  
  
# 打印结果  
print(f"数字5的平方是: {square_result}")  
print(f"数字5的立方是: {cube_result}")
```

- 函数的多种入参形式

```python
# 定义一个函数，接受多种类型的参数  
def demo_function(arg1, arg2, optional_arg='default', *args, **kwargs):
    print(f"位置参数 arg1: {arg1}")
    print(f"位置参数 arg2: {arg2}")
    print(f"可选参数 optional_arg (缺省值 'default'): {optional_arg}")
    print(f"不定长位置参数 args: {args}")
    print(f"不定长关键字参数 kwargs: {kwargs}")


# 使用位置入参调用函数  
demo_function('value1', 'value2')

# 使用关键字入参调用函数  
demo_function(arg1='value1', arg2='value2')

# 使用缺省参数调用函数，只提供部分位置参数  
demo_function('value1')

# 使用不定长位置参数调用函数（默认使用元组进行接收）
demo_function('value1', 'value2', 'extra1', 'extra2')

# 使用不定长关键字参数调用函数（默认使用字典进行接收）
demo_function(arg1='value1', arg2='value2', extra_key1='extra_value1', extra_key2='extra_value2')

# 混合使用各种参数类型调用函数  
demo_function('value1', 'value2', 'extra1', 'extra2', optional_arg='custom_default', extra_key1='extra_value1')
```

#### 常用内置函数

```python
print("hello world")


s = "123"
i = int(s)
b = bool(s)
f = float(s)


# bin, oct, hex
a = 18  # 十进制
print(bin(a))  # 0b10010
print(oct(a))  # 0o22
print(hex(a))  # 0x12

a = 0b10010
print(int(a))  # 二进制转化成十进制


# 次幂
a = 10
b = 3
# a的b次方
print(pow(a, b))
print(a ** b)


# 最大、最小、求和
lst = [12,456,32,18,64,57]
print(max(lst))
print(min(lst))
print(sum(lst))


s = {1,2,3,}
lst = list("呵呵哒")
print(lst)


# 相当于[1:4:2]
s = slice(1, 4, 2)
print("呵呵呵呵呵呵呵呵呵"[s])


a = 18
# b: 二进制, o: 八进制, x: 十六进制
print(format(a, "08b"))


# python的内存中使用的是unicode
a = "中"
# 获取"中"字在unicode中码位
print(ord(a))
# 给出编码位置. 展示出文字
print(chr(20013))
# 遍历打印本机内存中所有字符
for i in range(65536):
    print(chr(i)+" ", end="")


# 当成and来看  t and t and t
print(all([1, "123", '豆沙包']))
# 当成or来看
print(any([0, "", '']))
lst = ["张无忌", "张翠山", "张三丰", "张大大"]

for index, item in enumerate(lst):
    print(index, item)

for i in range(len(lst)):
    print(i, lst[i])


s = "呵呵哒"
# 获取哈希值
print(hash(s))
# 获取内存地址
print(id(s))


s = "呵呵哒"
print(help(s))
# 当前这个数据能执行哪些操作
print(dir(s))
```

#### 函数的嵌套

```python
# 把一个函数当成一个变量进行返回的
def func():
    def inner():
        print(123)
    print(inner)
    return inner

b1 = func()
print(b1)
b1()

# 把函数作为参数进行传递(代理模式)
def func(an):
    an()

def target():
    print("我是target")

func(target)  # 实参可以是函数
```

#### 两个关键字

```python
"""
global : 在局部. 引入全局变量
nonlocal: 在局部, 引入外层的局部变量
"""
# a = 10
#
# def func():
#     # print(a)
#     # 此时我就想在函数内部修改全局的变量a
#     global a  # 把外面的全局变量引入到局部
#     a = 20  # 创建一个局部变量. 并没有去改变全局变量中的a
# func()
# print(a)

def func():
    a = 10
    def func2():
        nonlocal a  # 向外找一层. 看看有没有该变量. 如果有就引入, 如果没有, 继续向外一层, 直到全局(不包括)
        a = 20
    func2()
    print(a)

func()
```

#### 闭包

本质, 内层函数对外层函数的局部变量的使用. 此时内层函数被称为闭包函数

1. 可以让一个变量常驻与内存
2. 可以避免全局变量被修改

```python
def func():
    a = 10
    def inner():
        nonlocal a
        a += 1
        return a
    return inner


ret = func()
a = 20
# inner => ret => 什么时候执行
r1 = ret()
print(r1)

# 1000000

r2 = ret()
print(r2)
```

### 空值

Python中使用`None`表示空值，类似于Java的null，可用于返回值或者判断

### 函数中定义全局变量

global关键字

```python
# 定义一个全局变量
count = 0


def increment():
    # 使用 global 关键字声明 count 是全局变量
    global count
    # 修改全局变量 count 的值
    count += 1
    print(f"Count inside function: {count}")


def print_count():
    # 直接访问全局变量 count
    print(f"Count outside function: {count}")


# 调用函数以修改全局变量并打印其值
increment()
print_count()

# 再次调用函数并打印值，以展示全局变量的变化
increment()
print_count()
```

### 关于编码

- ascii：是最开始由美国制定的一套编码规则，编排了128个文字符号（包括英文、数字和符号），只需要7个0和1就可以表示了。`01111111 => 1 byte => 8 bit`
- ANSI：一套标准， 是为了扩充不同国家的文字字符所制定的，需要不同的国家根据这个标准来制定自己的编码。每个字符 `00000000 01111111 => 2 byte => 65536 bit`
- GB2312是根据ANSI标准制定的第一套国标编码，GBK是扩充版
- Unicode：万国码，由国际标准化组织制定，==只是一套标准==，由于它规定用`4 byte`表示一个字符，过于占用内存，故无法使用
- UTF-8：根据Unicode标准制定的可变长度的编码，规则入下，最短的字节长度8 bit
  1. 英文: 8 bit, 1byte
  2. 欧洲文字: 16 bit, 2 byte
  3. 中文: 24 bit, 3 byte
- 程序员平时遇见的所有的数据最终单位都是字节byte

### 数据容器

类似Java集合

```python
# 列表：可以嵌套，不同的元素项可以是不同的类型
mixed_list = [10, 'Hello', 3.14, True, [1, 2, 3], {'key': 'value'}]
# 正向索引从0开始
mixed_list[0]
# 反向索引从-1开始
mixed_list[-1]


# 元组：相当于一个只能查看的列表，其中的内容元素是不可修改的
my_tuple = (10, 'Hello', 3.14, True)
# 定义空元组的两种方式
my_tuple = ()
my_tuple = tuple()


# set集合：无序、不可重复、不能使用序列
my_set = {1, 2, 3, 4, 5}   
# 调用 pop()，移除任意元素，随机的 
element1 = my_set.pop()  
print(element1)


# 字典：键值对，类似于JSON数据格式
# 创建一个包含学生信息的字典  
student = {  
    'name': '张三',  
    'age': 18,  
    'grade': 90  
}  
# 访问学生字典中的字段  
print("学生姓名:", student['name'])  
print("学生年龄:", student['age'])  
print("学生成绩:", student['grade']) 
```

### 切片

序列（连续、有序、可使用下标索引的一类数据）都支持切片，比如列表、元组、字符串

```python
# 定义一个列表  
my_list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]  
  
# 使用切片获取列表的子序列  
# 切片语法：my_list[start:stop:step]
#			序列[起始:结束:步长]
  
# 获取从索引1到索引4（不包括4）的元素  
sub_list_1 = my_list[1:4]  
print("切片1:", sub_list_1)  # 输出: [1, 2, 3]  
  
# 获取从索引2开始到列表末尾的元素，步长为2  
sub_list_2 = my_list[2::2]  
print("切片2:", sub_list_2)  # 输出: [2, 4, 6, 8]  
  
# 获取从列表开头到索引5的元素，步长为-1（逆序）  
sub_list_3 = my_list[:5:-1]  
print("切片3:", sub_list_3)  # 输出: [4, 3, 2, 1, 0]  
  
# 字符串倒序
sub_list_4 = my_list[::-1]  
 
# 使用切片修改列表的一部分  
my_list[1:4] = [10, 11, 12]  
print("修改后的列表:", my_list)  # 输出: [0, 10, 11, 12, 4, 5, 6, 7, 8, 9]
```



### 文件操作

关于`.write()`和`.flush()`

- `write()` 方法是写入数据到文件的缓冲区，而 `flush()` 方法则是将缓冲区中的数据强制写入到磁盘上的文件中;`write()` 方法通常在你想要写入数据时调用，而 `flush()` 方法则是在你需要确保写入的数据被保存到文件时调用。

- 在正常情况下，当你关闭文件时（例如在 with 语句块结束时），Python 会自动调用 flush() 方法，以确保所有待写入的数据都被写入到文件中。因此，在大多数情况下，你不需要显式调用 flush()。然而，在某些特殊情况下，如日志记录或需要实时写入数据的场景，你可能需要在写入数据后立即调用 flush()，以确保数据不会丢失或延迟写入。

```python
# f = open(); 需要手动关闭文件
# with open() as f: 系统自动在操作完后关闭文件
# 打开文件并写入内容  
with open('example.txt', 'w') as file:  
    file.write('Hello, World!')  
  
# 打开文件并读取内容  
with open('example.txt', 'r') as file:  
    content = file.read()  
    print(content)  
  
# 打开文件并逐行读取内容  
with open('example.txt', 'r') as file:  
    for line in file:  
        print(line, end='')  
  
# 追加内容到文件末尾  
with open('example.txt', 'a') as file:  
    file.write('\nHello again!')  
  
# 检查文件是否存在  
if os.path.exists('example.txt'):  
    print('File exists.')  
  
# 获取文件大小  
file_size = os.path.getsize('example.txt')  
print('File size:', file_size, 'bytes')  
  
# 列出目录中的文件  
files = os.listdir('.')  
print('Files in directory:', files)  
  
# 复制文件  
shutil.copy('example.txt', 'example_copy.txt')  
  
# 删除文件  
os.remove('example_copy.txt')
```

### 异常

异常的捕获

```python
try:  
    # 尝试执行一些代码  
    x = 10 / 0  
except ZeroDivisionError:  
    # 如果发生 ZeroDivisionError 异常，则执行这里的代码  
    print("不能除以零!")  
else:  
    # 如果没有异常发生，则执行这里的代码  
    print("计算成功!")  
finally:  
    # 无论是否发生异常，都会执行这里的代码  
    print("执行结束")
```

异常的传递

```python
def divide(a, b):  
    if b == 0:  
        raise ValueError("Cannot divide by zero")  
    return a / b  
  
def calculate_average(numbers):  
    return sum(numbers) / len(numbers)  
  
def main():  
    try:  
        numbers = [1, 2, 3, 0]  
        average = calculate_average(numbers)  
        print(f"The average is: {average}")  
    except ValueError as e:  
        print(f"An error occurred: {e}")  
  
if __name__ == "__main__":  
    main()
```

### 包和模块导入

包导入和模块导入类似

python包的定义：文件夹中又一个`__init__.py`文件，标志这是一个python包

![模块导入](D:\Study\Learning-record\Python\模块导入.png)

```python
# 指定模块下哪些函数被暴露，单独指定后则只有指定的方法被暴露
# 现在只有function2()被暴露
__all__ = ['function2()']  
  
# 直接导入整个模块  
import my_module  
  
# 使用别名导入整个模块  
import my_module as mm  
  
# 从模块中导入特定的函数  
from my_module import function1  
  
# 从模块中导入特定的类  
from my_module import MyClass  
  
# 使用  
my_module.function2()  # 通过模块名调用函数  
mm.function1()  # 通过别名调用函数  
function1()  # 直接调用函数（因为已经从模块中导入了它）  
```

### 安装第三方包

```shell
# 默认安装方式
pip install [包名]

# 指定从某个地址进行安装
# 下为清华大学提供的安装网址
pip install -i https://pypi.tuna.tsinghua.edu.cn/simple [包名]
```

```shell
pip install -i https://pypi.douban.com/simple/ pyinstaller #豆瓣源
pip install -i https://pypi.tuna.tsinghua.edu.cn/simple pyinstaller #清华源
```

### 定义程序入口

```python
if __name__ == '__main__':
    print("Hello World!")
```

### 打包为exe

```shell
Pyinstaller -F py_word.py
```

## 类与对象

python中的成员方法都必须包含一个self属性，来表示类本身

```python
class Person:
    # 构造方法
    def __init__(self, name, age):  
        # 成员变量  
        self.name = name  
        self.age = age  
  
    # 成员方法  
    def introduce(self):  
        print(f"Hello, my name is {self.name} and I am {self.age} years old.")  
  
    def change_age(self, new_age):  
        # 修改成员变量的值  
        self.age = new_age  
        print(f"My age has been changed to {self.age}.")  
  
  
# 创建一个Person对象  
person1 = Person("Alice", 25)  
  
# 调用成员方法  
person1.introduce()  
  
# 修改成员变量的值  
person1.change_age(30)  
  
# 再次调用成员方法，查看变化  
person1.introduce()
```

### 魔术方法

统一命名格式`__***__`，类似于Java的Object常用类方法，在对象定义的时候进行重写定义，可以完成指定功能操作

```python
class MyClass:  
    def __init__(self, value):  
        # 初始化方法，创建对象时自动调用  
        self.value = value  
  
    def __str__(self):  
        # 定义对象的字符串表示形式  
        return f"MyClass({self.value})"  
  
    def __repr__(self):  
        # 定义对象的官方字符串表示形式，通常用于调试  
        return f"MyClass(value={self.value})"  
  
    def __add__(self, other):  
        # 定义对象相加的操作  
        if isinstance(other, MyClass):  
            return MyClass(self.value + other.value)  
        else:  
            raise TypeError("Unsupported operand type for +: 'MyClass' and '{}'".format(type(other).__name__))  
  
    def __eq__(self, other):  
        # 定义对象相等性的比较  
        if isinstance(other, MyClass):  
            return self.value == other.value  
        return False  
    
    def __lt__(self, other):  
        # 定义小于比较  
        if isinstance(other, MyClass):  
            return self.value < other.value  
        return NotImplemented  
  
    def __le__(self, other):  
        # 定义小于等于比较  
        if isinstance(other, MyClass):  
            return self.value <= other.value  
        return NotImplemented 
  
# 创建对象  
obj1 = MyClass(10)  
obj2 = MyClass(20)  

# 使用 __str__ 方法  
print(obj1)  # 输出: MyClass(10)  
  
# 使用 __repr__ 方法  
print(repr(obj1))  # 输出: MyClass(value=10)，通常用于调试  
  
# 使用 __add__ 方法  
obj3 = obj1 + obj2  
print(obj3)  # 输出: MyClass(30)，因为 10 + 20 = 30  
  
# 使用 __eq__ 方法  
print(obj1 == obj2)  # 输出: False，因为 10 不等于 20  
print(obj1 == MyClass(10))  # 输出: True，因为值相等
  
# 使用 __str__ 方法  
print(obj1)  # 输出: MyClass(10)  
  
# 使用 __repr__ 方法  
print(repr(obj1))  # 输出: MyClass(value=10)，通常用于调试  
  
# 使用 __add__ 方法  
obj3 = obj1 + obj2  
print(obj3)  # 输出: MyClass(30)，因为 10 + 20 = 30  
  
# 使用 __eq__ 方法  
print(obj1 == obj2)  # 输出: False，因为 10 不等于 20  
print(obj1 == MyClass(10))  # 输出: True，因为值相等
```

### 私有成员变量和私有成员方法

通过`__***`来定义

```python
class MyClass:
    def __init__(self, value):
        # 私有成员变量  
        self.__private_var = value

    def public_method(self):
        # 调用私有成员方法  
        self.__private_method()
        print("Public method called.")

    def __private_method(self):
        # 私有成员方法  
        print("Private method called.")

    def get_private_var(self):
        # 提供一个公共的获取私有成员变量的方法  
        return self.__private_var

# 创建对象  
obj = MyClass(42)

# 尝试直接访问私有成员变量（会抛出AttributeError）  
# print(obj.__private_var)  # 错误做法，会抛出 AttributeError  

# 通过公共方法获取私有成员变量的值  
print(obj.get_private_var())  # 输出: 42  

# 调用公共方法，它内部会调用私有方法  
obj.public_method()
# 输出:  
# Private method called.  
# Public method called.
```

### 继承

- 多继承中，如果父类有同名方法或属性，由左向右取优先级，最左边的优先级最高
- pass关键字：占位语句，用来保证函数（方法）或类定义的完整性，表示无内容，空的意思

```python
# 单继承示例  
class Animal:  
    def __init__(self, name):  
        self.name = name  
  
    def speak(self):  
        print(f"{self.name} makes a sound")  
  
class Dog(Animal):  # Dog类继承自Animal类  
    def speak(self):  
        print(f"{self.name} barks")  
  
# 创建Dog对象并调用speak方法  
dog = Dog("Buddy")  
dog.speak()  # 输出: Buddy barks  
  
# 多继承示例  
class Mammal(Animal):  
    def give_milk(self):  
        print(f"{self.name} gives milk")  
  
class Canine(Animal):  
    def chase_cat(self):  
        print(f"{self.name} chases cats")  
  
class DogWithExtraFeatures(Dog, Mammal, Canine):  # DogWithExtraFeatures类继承自Dog, Mammal, 和Canine类  
    pass  # 这里没有定义新的方法，只是继承了父类的方法  
  
# 创建DogWithExtraFeatures对象并调用方法  
dog_extra = DogWithExtraFeatures("Max")  
dog_extra.speak()  # 输出: Max barks，调用的是Dog类的speak方法  
dog_extra.give_milk()  # 输出: Max gives milk，调用的是Mammal类的give_milk方法  
dog_extra.chase_cat()  # 输出: Max chases cats，调用的是Canine类的chase_cat方法
```

- 调用父类方法和属性

```python
class Parent:  
    def __init__(self):  
        self.parent_attribute = "I am from Parent"  
  
    def parent_method(self):  
        print("This is a method from Parent")  
  
class Child(Parent):  
    def __init__(self):  
        super().__init__()  # 调用父类的构造函数  
        self.child_attribute = "I am from Child"  
  
    def child_method(self):  
        print("This is a method from Child")  
  
    def use_parent_method(self):  
        super().parent_method()  # 调用父类的方法  
  
    def show_attributes(self):  
        print("Parent attribute:", self.parent_attribute)  # 直接访问父类的属性  
        print("Child attribute:", self.child_attribute)  
  
# 创建Child类的实例  
child_obj = Child()  
  
# 调用Child类的方法  
child_obj.child_method()  # 输出: This is a method from Child  
  
# 调用父类的方法  
child_obj.use_parent_method()  # 输出: This is a method from Parent  
  
# 显示父类和子类的属性  
child_obj.show_attributes()  
# 输出:  
# Parent attribute: I am from Parent  
# Child attribute: I am from Child
```

### 类型注解

python中的类型注解是非强制性的，一般在不好理解返回类型的时候才需要注解一下

```python
from typing import List, Any  
  
class MyData:  
    def __init__(self, value: int) -> None:  
        """初始化函数，接受一个整数类型的value作为参数"""  
        self.value: int = value  # 变量类型注解  
  
    def process_data(self, data: List[float]) -> List[Any]:  
        """处理数据的函数，接受一个浮点数列表，返回一个包含任意类型元素的列表"""  
        result: List[Any] = []  # 变量类型注解  
        for item in data:  
            if item > 0:  
                result.append(item ** 2)  # 平方  
            else:  
                result.append(str(item))  # 转为字符串  
        return result  # 函数返回值类型注解  
  
# 使用示例  
my_data = MyData(42)  # 创建MyData对象，传入整数类型的value  
data_list = [1.2, -3.4, 5.6]  # 创建一个浮点数列表  
  
# 调用process_data方法，并传入浮点数列表  
processed_data = my_data.process_data(data_list)  
  
# 输出处理后的数据  
print(processed_data)  # 输出可能类似于 [1.44, '-3.4', 31.36]
```

联合注解

```python
from typing import Union  
  
class Shape:  
    def __init__(self, name: str, sides: Union[int, None] = None):  
        self.name = name  
        self.sides = sides  
  
    def describe(self):  
        if self.sides is None:  
            print(f"{self.name} has no defined sides.")  
        else:  
            print(f"{self.name} has {self.sides} sides.")  
  
# 创建一个圆形对象，圆形没有边  
circle = Shape("Circle")  
circle.describe()  # 输出: Circle has no defined sides.  
  
# 创建一个三角形对象，三角形有3条边  
triangle = Shape("Triangle", 3)  
triangle.describe()  # 输出: Triangle has 3 sides.  
  
# 尝试传递一个非int或非None的值给sides参数，这将导致类型错误（如果在运行时使用类型检查）  
# square = Shape("Square", "four")  # 这将在运行时抛出异常，如果使用了类型检查
```

### 抽象类

```python
from abc import ABC, abstractmethod  
  
# 定义一个抽象类  
class Shape(ABC):  
    @abstractmethod  
    def area(self):  
        pass  # 抽象方法没有实现  
  
    @abstractmethod  
    def perimeter(self):  
        pass  # 抽象方法没有实现  
  
# 定义一个非抽象子类，继承自Shape抽象类  
class Circle(Shape):  
    def __init__(self, radius):  
        self.radius = radius  
  
    # 实现Shape抽象类的area方法  
    def area(self):  
        return 3.14 * self.radius ** 2  
  
    # 实现Shape抽象类的perimeter方法  
    def perimeter(self):  
        return 2 * 3.14 * self.radius  
  
# 定义一个非抽象子类，继承自Shape抽象类  
class Rectangle(Shape):  
    def __init__(self, length, width):  
        self.length = length  
        self.width = width  
  
    # 实现Shape抽象类的area方法  
    def area(self):  
        return self.length * self.width  
  
    # 实现Shape抽象类的perimeter方法  
    def perimeter(self):  
        return 2 * (self.length + self.width)  
  
# 创建Circle和Rectangle的实例，并调用它们的方法  
circle = Circle(5)  
print(f"Circle area: {circle.area()}")  
print(f"Circle perimeter: {circle.perimeter()}")  
  
rectangle = Rectangle(4, 6)  
print(f"Rectangle area: {rectangle.area()}")  
print(f"Rectangle perimeter: {rectangle.perimeter()}")
```

## 爬虫

### HTTP协议

请求头和响应头里面比较常见的重要参数

```
User-Agent:请求载体的身份标识（系统、浏览器之类的标识信息）
Referer:防盗链（请求从哪个页面进行发送的）
cookie:用户令牌
```

## 三方库

### 图表库（pyecharts）

### Mysql连接（pymysql）

```python
import pymysql  
  
class MySQLHandler:  
    def __init__(self, host, user, password, db):  
        self.host = host  
        self.user = user  
        self.password = password  
        self.db = db  
        self.connection = None  
        self.cursor = None  
  
    def connect(self):  
        self.connection = pymysql.connect(  
            host=self.host,  
            user=self.user,  
            password=self.password,  
            db=self.db,  
            charset='utf8mb4',  
            cursorclass=pymysql.cursors.DictCursor  
        )  
        self.cursor = self.connection.cursor()  
  
    def close(self):  
        if self.cursor:  
            self.cursor.close()  
        if self.connection:  
            self.connection.close()  
  
    def execute_query(self, query):  
        try:  
            self.cursor.execute(query)  
            result = self.cursor.fetchall()  
            return result  
        except Exception as e:  
            print(f"Error executing query: {e}")  
            return None  
  
    def execute_command(self, query):  
        try:  
            self.cursor.execute(query)  
            self.connection.commit()  
            print("Command executed successfully.")  
        except Exception as e:  
            print(f"Error executing command: {e}")  
            self.connection.rollback()  
  
# 使用示例  
if __name__ == '__main__':  
    # 数据库连接信息  
    host = 'localhost'  
    user = 'your_username'  
    password = 'your_password'  
    db = 'your_database'  
  
    # 创建MySQLHandler实例  
    mysql_handler = MySQLHandler(host, user, password, db)  
  
    # 连接数据库  
    mysql_handler.connect()  
  
    # 执行查询操作  
    query = "SELECT * FROM your_table_name"  
    results = mysql_handler.execute_query(query)  
    for row in results:  
        print(row)  
  
    # 执行插入操作  
    insert_query = "INSERT INTO your_table_name (column1, column2) VALUES (%s, %s)"  
    data = ('value1', 'value2')  
    mysql_handler.cursor.execute(insert_query, data)  
    mysql_handler.connection.commit()  
    print("Data inserted successfully.")  
  
    # 关闭数据库连接  
    mysql_handler.close()
```

### 分布式弹性计算库（PySpark）
