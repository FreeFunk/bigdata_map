package com.edgedo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @ClassName HandleCallable
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/8/1 16:47
 **/
@SuppressWarnings("rawtypes")
public class HandleCallable<E> implements Callable<ResultBean> {
    private static Logger logger = LoggerFactory.getLogger(HandleCallable.class);
    // 线程名称
    private String threadName = "";
    // 需要处理的数据
    private List<E> data;
    // 辅助参数
    private Map<String, Object> params;
    // 具体执行任务
    private ITask<ResultBean<String>, E> task;

    public HandleCallable(String threadName, List<E> data, Map<String, Object> params,
                          ITask<ResultBean<String>, E> task) {
        this.threadName = threadName;
        this.data = data;
        this.params = params;
        this.task = task;
    }

    @Override
    public ResultBean<List<ResultBean<String>>> call() throws Exception {
        // 该线程中所有数据处理返回结果
        ResultBean<List<ResultBean<String>>> resultBean = ResultBean.newInstance();
        if (data != null && data.size() > 0) {
            logger.info("线程：{},共处理:{}个数据，开始处理......", threadName, data.size());
            // 返回结果集
            List<ResultBean<String>> resultList = new ArrayList<>();
            // 循环处理每个数据
            for (int i = 0; i < data.size(); i++) {
                // 需要执行的数据
                E e = data.get(i);
                // 将数据执行结果加入到结果集中
                resultList.add(task.execute(e, params));
                logger.info("线程：{},第{}个数据，处理完成", threadName, (i + 1));
            }
            logger.info("线程：{},共处理:{}个数据，处理完成......", threadName, data.size());
            resultBean.setData(resultList);
        }
        return resultBean;
    }

}
