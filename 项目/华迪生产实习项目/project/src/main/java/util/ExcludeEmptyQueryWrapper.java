package util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Objects;

/**
 * 继承QueryWrapper，重写其构造条件方法，使条件为null的查询条件，不再执行。
 * @since Mybatis+ version: 3.x.x
 * @author firewolf
 */
public class ExcludeEmptyQueryWrapper<T> extends QueryWrapper<T> {
    @Override
    public QueryWrapper<T> eq(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.eq(condition, column, val);
    }

    @Override
    public QueryWrapper<T> ne(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.ne(condition, column, val);
    }

    @Override
    public QueryWrapper<T> gt(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.gt(condition, column, val);
    }

    @Override
    public QueryWrapper<T> ge(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.ge(condition, column, val);
    }

    @Override
    public QueryWrapper<T> lt(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.lt(condition, column, val);
    }

    @Override
    public QueryWrapper<T> le(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.le(condition, column, val);
    }

    @Override
    public QueryWrapper<T> like(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.like(condition, column, val);
    }

    @Override
    public QueryWrapper<T> notLike(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.notLike(condition, column, val);
    }

    @Override
    public QueryWrapper<T> likeLeft(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.likeLeft(condition, column, val);
    }

    @Override
    public QueryWrapper<T> likeRight(boolean condition, String column, Object val) {
        condition = !Objects.isNull(val);
        return super.likeRight(condition, column, val);
    }

    @Override
    public QueryWrapper<T> between(boolean condition, String column, Object val1, Object val2) {
        if(Objects.isNull(val1) && Objects.isNull(val2)){
            condition = false;
        }else if(Objects.isNull(val1)){
            return super.lt(true,column,val2);
        }else if(Objects.isNull(val2)){
            return super.ge(true,column,val1);
        }
        return super.between(condition, column, val1, val2);
    }

    @Override
    public QueryWrapper<T> notBetween(boolean condition, String column, Object val1, Object val2) {
        if(Objects.isNull(val1) && Objects.isNull(val2)){
            condition = false;
        }else if(Objects.isNull(val1)){
            return super.lt(true,column,val2);
        }else if(Objects.isNull(val2)){
            return super.ge(true,column,val1);
        }
        return super.notBetween(condition, column, val1, val2);
    }
}
