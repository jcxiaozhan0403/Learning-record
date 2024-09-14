import datetime
import chinese_calendar as calendar

def calculate_workdays(start_month_str, end_month_str):
    # 解析输入字符串，提取开始和结束的年月
    start_month = datetime.datetime.strptime(start_month_str.strip(), '%Y-%m')
    end_month = datetime.datetime.strptime(end_month_str.strip(), '%Y-%m')

    # 计算实际的起始日期和结束日期
    start_date = start_month + datetime.timedelta(days=27)
    end_date = end_month + datetime.timedelta(days=26)

    # 初始化工作天数
    workdays = 0

    # 遍历日期范围
    current_day = start_date
    while current_day <= end_date:
        # 判断是否为工作日
        if calendar.is_workday(current_day):
            workdays += 1
        current_day += datetime.timedelta(days=1)

    return workdays

# 获取用户输入，仅输入结束月份 (格式: YYYY-M)
end_month_str = input("请输入查询月份(格式: YYYY-M): ")

# 计算前一个月的日期
end_month = datetime.datetime.strptime(end_month_str.strip(), '%Y-%m')
start_month = (end_month - datetime.timedelta(days=end_month.day)).replace(day=1)
start_month_str = start_month.strftime('%Y-%m')

# 计算并输出工作天数
workdays = calculate_workdays(start_month_str, end_month_str)
start_date = start_month + datetime.timedelta(days=27)
end_date = end_month + datetime.timedelta(days=26)
print(f"在 {start_date.strftime('%Y-%m-%d')} 到 {end_date.strftime('%Y-%m-%d')} 的时间段内，您工作了 {workdays} 天。")
