CREATE VIEW flexible_discounts AS
SELECT  VD.Discount_idDiscount, VD.Task_task_id, VD.discount_rate, T.task_Description
FROM variable_discount VD
JOIN task T ON VD.Task_task_id = T.task_id
