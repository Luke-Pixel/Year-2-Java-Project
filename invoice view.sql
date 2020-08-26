CREATE VIEW Invoice as
SELECT JT.Task_task_id,J.Job_number,J.total_cost,J.deadline, T.task_Description, T.price, C.customer_id, C.first_name, C.second_name, C.address_line1, C.city, C.postcode, C.phone

FROM job_task JT

JOIN job J ON JT.Job_Job_number = J.Job_number
JOIN customer C ON JT.Job_Customer_customer_id = C.customer_id
JOIN Task T ON JT.Task_task_id = T.task_id
