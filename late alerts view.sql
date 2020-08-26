
CREATE VIEW late_alert_view AS
SELECT  C.first_name, C.second_name,C.customer_id, C.state, C.valued_customer,PA.aknowledged,PA.alert_type, PA.next_check,PA.idAlert, J.Job_number, J.payment_state, C.address_line1,C.phone, C.email,C.city, C.postcode
FROM customer C 
JOIN job J ON C.customer_id = J.Customer_customer_id
JOIN Payment_Alert PA ON PA.job_Job_number = J.Job_number