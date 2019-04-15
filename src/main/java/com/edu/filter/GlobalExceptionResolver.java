package com.edu.filter;

import com.edu.common.ResultBean;
import com.edu.exception.AlarmRuntimeException;
import com.edu.exception.BizRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局Controller层异常处理类
 */
@ControllerAdvice
public class GlobalExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * 处理所有不可知异常
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handleException(Exception e) {
        //其它操作，比如：发短信告知开发人员

        // 打印异常堆栈信息
        LOG.error(e.getMessage(), e);
        return ResultBean.error(500,e.getMessage());
    }
    /**
     * 处理所有严重异常
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(AlarmRuntimeException.class)
    @ResponseBody
    public ResultBean handleAlarmException(AlarmRuntimeException e) {
        //其它操作，比如：发短信告知开发人员

        // 打印异常堆栈信息
        LOG.error(e.getMessage(), e);
        return ResultBean.error(500,e.getMessage());
    }
    /**
     * 处理业务异常
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(BizRuntimeException.class)
    @ResponseBody
    public ResultBean handleCustomException(BizRuntimeException e) {
        // 打印异常堆栈信息
        LOG.error(e.getMessage(), e);
        return ResultBean.error(e.getCode(),e.getMessage());
    }

}

