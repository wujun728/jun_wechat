package com.app.quartz.config;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import com.app.dao.SysQuartzDao;
import com.app.entity.SysQuartz;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QuartzService {
	
    @Autowired
    private SysQuartzDao sysQuartzDao;

    @Autowired @Qualifier(value = "SchedulerFactory") //红线运行无错,貌似是idea的问题 ,可忽略
    private SchedulerFactoryBean schedulerFactoryBean;

    /**
     * 
         * @Title: addJob
         * @Description: 增/改任务 - 名称+分组 不能重复
         * @param @param sysQuartz
         * @param @throws SchedulerException    参数
         * @return void    返回类型
         * @throws
     */
    public void addJob(SysQuartz sysQuartz) throws SchedulerException {
    	sysQuartzDao.insert(sysQuartz);
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(sysQuartz.getName(), sysQuartz.getGroups());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        //不存在，创建一个
        if (null == trigger) {
            JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class).withIdentity(sysQuartz.getName(), sysQuartz.getGroups()).build();
            jobDetail.getJobDataMap().put("scheduleJob", sysQuartz);
            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysQuartz.getCron());
            //按新的cronExpression表达式构建一个新的trigger
            trigger = TriggerBuilder.newTrigger().withIdentity(sysQuartz.getName(),sysQuartz.getGroups()).withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            // Trigger已存在，那么更新相应的定时设置
            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysQuartz.getCron());
            //按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            //按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }
    
    /**
     * 启动任务
     * @param sysQuartz
     * @throws SchedulerException
     */
    public void startJob(SysQuartz sysQuartz) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(sysQuartz.getName(), sysQuartz.getGroups());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        //不存在，创建一个
        if (null == trigger) {
            JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class).withIdentity(sysQuartz.getName(), sysQuartz.getGroups()).build();
            jobDetail.getJobDataMap().put("scheduleJob", sysQuartz);
            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysQuartz.getCron());
            //按新的cronExpression表达式构建一个新的trigger
            trigger = TriggerBuilder.newTrigger().withIdentity(sysQuartz.getName(),sysQuartz.getGroups()).withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            // Trigger已存在，那么更新相应的定时设置
            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysQuartz.getCron());
            //按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            //按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }

    /**
     * 
         * @Title: delete
         * @Description: 删除任务
         * @param @param sysQuartz
         * @param @throws SchedulerException    参数
         * @return void    返回类型
         * @throws
     */
    public void delete(SysQuartz sysQuartz) throws SchedulerException{
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(sysQuartz.getName(), sysQuartz.getGroups());
        scheduler.deleteJob(jobKey);
    }

    /**
     * 
         * @Title: checkCron
         * @Description: 检查cron表达式是否是可执行的。
         * @param @param cron
         * @param @return    参数
         * @return boolean    返回类型
         * @throws
     */
    public boolean checkCron(String cron){
        CronTriggerImpl trigger = new CronTriggerImpl();
        try {
            trigger.setCronExpression(cron);
            Date date = trigger.computeFirstFireTime(null);
            return date != null && date.after(new Date());
        } catch (Exception e) {
            log.error("[TaskUtils.isValidExpression]:failed. throw ex:" , e);
        }
        return false;
    }
}
