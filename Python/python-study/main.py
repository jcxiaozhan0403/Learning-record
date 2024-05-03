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