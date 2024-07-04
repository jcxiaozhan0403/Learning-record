## order by

- asc顺序（默认值），desc倒序

```sql
# 一般写法
select * from students order by birthdate

# 多字段排序，优先级从前往后依次递减
select * from students order by birthdate asc,student_name desc
```

## group by

```sql
# 可以多条件分组，如果分组后有某一字段有多个不同值，需要用sql函数进行处理，比如max(),min()等
SELECT max(entry_code),material_code,count(*)
FROM enter_warehouse_info
WHERE warehouse_type_name = '模具库' AND status <> '5' and deleted = 0
GROUP BY entry_code,material_code
# HAVING相当于WHERE，只是使用位置不同，它是对分组后的数据进行筛选
HAVING count(*) <> 3
```

## count

- count(1)和count(*)

```sql
# 这两种都是用于统计行数据的，不关系行存储内容，也就是NULL值也会被统计在内
# 功能上大同小异，由于数据库优化，性能上也没有过大差异
SELECT COUNT(*) FROM student
```

- count(column_name)

```sql
# 可以指定某一列，这样子统计的就是列的有效值，不包含NULL值
# 还可以使用distinct关键字去重
SELECT COUNT(distinct name) FROM student
```

## 搜索case...when...then...else...end

```sql
# 满足条件when，执行then，否则执行else
CASE WHEN (SELECT count(1) FROM production_instruct_material i_m WHERE i_m.production_instruct_id = p_i.id AND
i_m.type = '1' AND i_m.deleted = '0') > 0
THEN '1' ELSE '0' END as onStart
```

## 转换函数cast(xxx,xxxx)

```sql
# 长度18,4位小数
CAST((SELECT SUM(p_r.release_num) + SUM(p_r.qualified_num)
FROM production_rewind p_r
WHERE p_r.production_instruct_id = p_i.id and p_r.deleted = '0') / p_i.order_quantity as DECIMAL(18,4)) as productionProgress
```

## coalesce函数

```sql
# COALESCE是一个函数，(expression_1, expression_2, ...,expression_n)依次参考各参数表达式，遇到非null值即停止并返回该值。
# 一般用在空校验，如果查出null，使用一个默认值来替代它
SELECT
p_r.production_instruct_id as id,
COALESCE(SUM(p_r.release_num + p_r.qualified_num), 0) completeNumber,
COALESCE(SUM(p_r.scrap_num), 0) as scrap,
COALESCE(SUM(p_r.rework_num), 0) as rework,
COALESCE(SUM(p_r.release_num), 0) as releaseNum,
COALESCE(SUM(p_r.qualified_num), 0) as qualifiedNum,
COALESCE(SUM(p_r.scrap_num + p_r.rework_num + p_r.release_num + p_r.qualified_num), 0) realOutput,
COALESCE(SUM(p_r.scrap_num + p_r.release_num + p_r.qualified_num), 0) consumption
from production_rewind p_r
```

## 窗口函数（没玩懂）

```sql
SELECT ROW_NUMBER
					 ( ) OVER ( PARTITION BY production_order_number_child ORDER BY vornr DESC ) row_id, *
FROM
		production_instruct
WHERE
		deleted	= '0'
```

## string_agg()

```sql
# 多列拼接为一个字符串
select (select string_agg(exi.exit_code,',') from exit_warehouse_info exi where exi.warehouse_type_id = ewi.warehouse_type_id) as exits,ewi.*
from enter_warehouse_info ewi
```

## distinct on()

```sql
# 在查询结果中去重，遇到的第一行保留，后续再有重复的，不保留
# 通常会对需要去重的字段使用order b做排序
SELECT
distinct on (pi.production_order_number_child) pi.*
FROM production_instruct pi
LEFT JOIN craft_standard_process csp ON csp.id = pi.standard_process_id
ORDER BY production_order_number_child asc
```

## 类型转换

```sql
# ::INT就是
SELECT w_i.material_code as materialCode,
   SUM(w_i.material_num::INT) as materialNum
FROM enter_warehouse_info as w_i
     LEFT JOIN warehouse_type w_t ON w_t.id = w_i.warehouse_type_id
WHERE w_t.warehouse_type = '线边库' AND w_i.deleted = '0'
GROUP BY w_i.material_code
```

## 日期转字符串

```sql
to_char(p_r.create_time  ,'YYYY-MM-dd')  = #{p.date}
```

