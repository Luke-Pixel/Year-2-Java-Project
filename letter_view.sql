CREATE VIEW letter_view AS
SELECT  C.first_name, C.second_name,C.customer_id, C.phone, C.address_line1, C.city, C.postcode, J.Job_number, J.payment_state, J.completion_date, J.total_cost
FROM customer C 
JOIN job J ON C.customer_id = J.Customer_customer_id
