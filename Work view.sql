CREATE VIEW baper_work as
SELECT J.current_shelf,J.job_number, J.deadline, J.late,J.special_instructions,J.rushed,T.shelfSlot, T.task_id, T.task_Description, T.location, T.duration, JT.Job_TaskID, JT.start_time, JT.end_Time,  JT.state, JT.time_taken, JT.shift_type, JT.user_account_employee_id, JT.Job_Customer_customer_id
FROM job_task JT
JOIN job J ON JT.Job_Job_number = J.Job_number
JOIN Task T ON JT.Task_task_id = T.task_id
order by J.rushed DESC AND J.priority ASC
