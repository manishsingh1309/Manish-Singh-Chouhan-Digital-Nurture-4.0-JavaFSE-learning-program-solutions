BEGIN
  FOR dueLoan IN (
    SELECT loan_id, customer_id, due_date
    FROM loans
    WHERE due_date <= (SYSDATE + 30)
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('📢 Reminder: Loan [' || dueLoan.loan_id ||
                         '] for Customer [' || dueLoan.customer_id ||
                         '] is scheduled to close on ' || TO_CHAR(dueLoan.due_date, 'DD-Mon-YYYY'));
  END LOOP;
END;
/
