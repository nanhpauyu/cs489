SELECT * FROM Dentists
ORDER BY lastName ASC;

SELECT A.*, P.firstName AS patientFirstName, P.lastName AS patientLastName
FROM Appointments A
JOIN Dentist_appointment DA ON A.appointment_id = DA.appointment_id
JOIN Patients P ON A.patient_id = P.patient_id
WHERE DA.dentist_id = 1; -- Replace with desired dentist_id


SELECT * FROM Appointments
WHERE surgery_id IS NOT NULL;

SELECT * FROM Appointments
WHERE patient_id = 1 
AND date = '2025-04-05'; 
