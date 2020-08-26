CREATE VIEW Performance_Data as
select  JT.Job_TaskID,JT.start_time,JT.time_taken, UA.employee_id, JT.shift_type, JT.Job_Job_number,UA.first_name, UA.second_name,T.task_id,T.location,T.shelfSlot,JT.duration
FROM job_task JT 
JOIN user_account UA ON UA.employee_id = JT.user_account_employee_id
JOIN Task T ON JT.Task_task_id = T.task_id