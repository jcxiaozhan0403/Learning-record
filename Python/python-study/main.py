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