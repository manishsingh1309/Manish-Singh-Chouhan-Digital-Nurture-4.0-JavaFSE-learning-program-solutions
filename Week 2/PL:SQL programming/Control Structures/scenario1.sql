BEGIN
  FOR custRec IN (
    SELECT customer_id, interest_rate
    FROM customers
    WHERE age > 60
  ) LOOP
    UPDATE customers
    SET interest_rate = interest_rate - 1
    WHERE customer_id = custRec.customer_id;

    DBMS_OUTPUT.PUT_LINE('🔽 Discount Applied: Customer ID ' || custRec.customer_id || 
                         ', New Interest Rate = ' || (custRec.interest_rate - 1));
  END LOOP;

  COMMIT;
END;
/
